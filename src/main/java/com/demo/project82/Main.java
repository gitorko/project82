package com.demo.project82;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.demo.project82._29_pessimistic_locking.Student29;
import com.demo.project82._29_pessimistic_locking.repo.Student29Repository;
import com.demo.project82._29_pessimistic_locking.service.Student29Service;
import com.demo.project82._30_optimistic_locking.Student30;
import com.demo.project82._30_optimistic_locking.repo.Student30Repository;
import com.demo.project82._30_optimistic_locking.service.Student30Service;
import com.demo.project82._32_transaction.Student32;
import com.demo.project82._32_transaction.repo.Student32Repository;
import com.demo.project82._32_transaction.service.Student32Service;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor
@Slf4j
public class Main {

    final Student29Repository student29Repository;
    final Student30Repository student30Repository;
    final Student32Repository student32Repository;

    final Student29Service student29Service;
    final Student30Service student30Service;
    final Student32Service student32Service;

    final TransactionTemplate transactionTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner start() {
        return (args) -> {
            log.info("DB Created!");
            testOptimisticLocking();
            testPessimisticLocking();
            testTransaction();
        };
    }

    @SneakyThrows
    public void testOptimisticLocking() {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Long studentId = 200l;
        Student30 student = student30Repository.findById(studentId).orElseThrow();
        log.info("[testOptimisticLocking] Student Before: {}", student);
        CountDownLatch latch = new CountDownLatch(2);
        modifyStudent30(studentId, latch, threadPool);
        modifyStudent30(studentId, latch, threadPool);
        latch.await(10, TimeUnit.SECONDS);
        student = student30Repository.findById(studentId).orElseThrow();
        log.info("[testOptimisticLocking] Student After: {}", student);
        if (student.getUpdatedCount() != 1) {
            throw new RuntimeException("TEST_ERROR");
        }
        if (student.getAmount() != 110) {
            throw new RuntimeException("TEST_ERROR");
        }
        threadPool.shutdown();
        threadPool.awaitTermination(5, TimeUnit.SECONDS);
    }

    @SneakyThrows
    public void testPessimisticLocking() {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Long studentId = 200l;
        Student29 student = student29Repository.findById(studentId).orElseThrow();
        log.info("[testPessimisticLocking] Student Before: {}", student);
        CountDownLatch latch = new CountDownLatch(2);
        modifyStudent29(studentId, latch, threadPool);
        modifyStudent29(studentId, latch, threadPool);
        latch.await(20, TimeUnit.SECONDS);

        // Explicitly shutdown the pool so that transaction is flushed.
        // Without this the update from other thread won't be persisted for the test to succeed.
        threadPool.shutdown();
        threadPool.awaitTermination(5, TimeUnit.SECONDS);

        student = student29Repository.findById(studentId).orElseThrow();
        log.info("[testPessimisticLocking] Student After: {}", student);
        if (student.getUpdatedCount() != 1) {
            throw new RuntimeException("TEST_ERROR");
        }
        if (student.getAmount() != 110) {
            throw new RuntimeException("TEST_ERROR");
        }
    }

    @SneakyThrows
    public void testTransaction() {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Long studentId = 200l;
        Student32 student = student32Repository.findById(200l).orElseThrow();
        log.info("Student Before: {}", student);
        CountDownLatch latch = new CountDownLatch(1);
        modifyStudent32(studentId, latch, threadPool);
        latch.await(1, TimeUnit.SECONDS);
        student = student32Repository.findById(studentId).orElseThrow();
        log.info("Student After: {}", student);
        if (!student.getStudentName().equals("raj")) {
            throw new RuntimeException("TEST_ERROR");
        }
        threadPool.shutdown();
        threadPool.awaitTermination(5, TimeUnit.SECONDS);
    }

    private void modifyStudent29(Long id, CountDownLatch latch, ExecutorService threadPool) {
        threadPool.submit(() -> {
            student29Service.modifyStudent29(id, latch);
        });
    }

    private void modifyStudent30(Long id, CountDownLatch latch, ExecutorService threadPool) {
        threadPool.submit(() -> {
            student30Service.modifyStudent30(id, latch);
        });
    }

    private void modifyStudent32(Long id, CountDownLatch latch, ExecutorService threadPool) {
        threadPool.submit(() -> {
            student32Service.modifyStuden32(id, latch);
        });
    }

}
