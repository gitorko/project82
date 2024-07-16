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

    /**
     * You can also use @Async instead of using thread pool.
     */
    ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner start() {
        return (args) -> {
            try {
                log.info("DB Created!");
                testOptimisticLocking();
                testPessimisticLocking();
                testTransaction();
            } finally {
                threadPool.shutdown();
                threadPool.awaitTermination(5, TimeUnit.SECONDS);
            }
        };
    }

    @SneakyThrows
    public void testOptimisticLocking() {
        Long studentId = 200l;
        Student30 student = student30Repository.findById(studentId).orElseThrow();
        log.info("[testOptimisticLocking] Student Before: {}", student);
        CountDownLatch latch = new CountDownLatch(2);
        modifyStudent30(studentId, latch);
        modifyStudent30(studentId, latch);
        latch.await(10, TimeUnit.SECONDS);
        student = student30Repository.findById(studentId).orElseThrow();
        log.info("[testOptimisticLocking] Student After: {}", student);
        if (student.getUpdatedCount() != 1) {
            //We check that only one transaction was applied.
            throw new RuntimeException("TEST_ERROR");
        }
        if (student.getAmount() != 110) {
            throw new RuntimeException("TEST_ERROR");
        }
    }

    @SneakyThrows
    public void testPessimisticLocking() {
        Long studentId = 200l;
        Student29 student = student29Repository.findById(studentId).orElseThrow();
        log.info("[testPessimisticLocking] Student Before: {}", student);
        CountDownLatch latch = new CountDownLatch(2);
        modifyStudent29(studentId, latch);
        modifyStudent29(studentId, latch);
        latch.await(20, TimeUnit.SECONDS);
        student = student29Repository.findById(studentId).orElseThrow();
        log.info("[testPessimisticLocking] Student After: {}", student);
        if (student.getUpdatedCount() != 1) {
            //We check that only one transaction was applied.
            throw new RuntimeException("TEST_ERROR");
        }
        if (student.getAmount() != 110) {
            throw new RuntimeException("TEST_ERROR");
        }
    }

    @SneakyThrows
    public void testTransaction() {
        Long studentId = 200l;
        Student32 student = student32Repository.findById(200l).orElseThrow();
        log.info("[testTransaction] Student Before: {}", student);
        CountDownLatch latch = new CountDownLatch(1);
        modifyStudent32(studentId, latch);
        latch.await(1, TimeUnit.SECONDS);
        student = student32Repository.findById(studentId).orElseThrow();
        log.info("[testTransaction] Student After: {}", student);
        if (!student.getStudentName().equals("raj")) {
            //We check that modification didn't happen as we used readonly entity
            throw new RuntimeException("TEST_ERROR");
        }
    }

    private void modifyStudent29(Long id, CountDownLatch latch) {
        threadPool.submit(() -> {
            student29Service.modifyStudent29(id, latch);
        });
    }

    private void modifyStudent30(Long id, CountDownLatch latch) {
        threadPool.submit(() -> {
            student30Service.modifyStudent30(id, latch);
        });
    }

    private void modifyStudent32(Long id, CountDownLatch latch) {
        threadPool.submit(() -> {
            student32Service.modifyStuden32(id, latch);
        });
    }

}
