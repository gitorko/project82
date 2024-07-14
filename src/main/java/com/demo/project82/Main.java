package com.demo.project82;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.demo.project82._29_pessimistic_locking.Student29;
import com.demo.project82._29_pessimistic_locking.repo.Student29Repository;
import com.demo.project82._30_optimistic_locking.Student30;
import com.demo.project82._30_optimistic_locking.repo.Student30Repository;
import com.demo.project82._32_transaction.Student32;
import com.demo.project82._32_transaction.repo.Student32Repository;
import com.demo.project82._32_transaction.service.Student32Service;
import jakarta.persistence.PessimisticLockException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor
@Slf4j
public class Main {

    final Student29Repository student29Repository;
    final Student30Repository student30Repository;
    final Student32Repository student32Repository;
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
    public void testTransaction() {
        Student32 student = student32Repository.findById(200l).orElseThrow();
        log.info("Student Before: {}", student);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(1);
        student32Service.modifyStuden32(200l, latch);
        latch.await(1, TimeUnit.SECONDS);
        threadPool.shutdown();
        threadPool.awaitTermination(5, TimeUnit.SECONDS);
        student = student32Repository.findById(200l).orElseThrow();
        log.info("Student After: {}", student);
        if (!student.getStudentName().equals("raj")) {
            throw new RuntimeException("VALIDATION_ERROR");
        }
    }

    public void testOptimisticLocking() throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Student30 student = student30Repository.findById(200l).orElseThrow();
        log.info("[testOptimisticLocking] Student Before: {}", student);

        CountDownLatch latch = new CountDownLatch(2);
        modifyStudent30(200l, latch, threadPool);
        modifyStudent30(200l, latch, threadPool);
        latch.await(10, TimeUnit.SECONDS);
        threadPool.shutdown();
        threadPool.awaitTermination(5, TimeUnit.SECONDS);

        student = student30Repository.findById(200l).orElseThrow();
        log.info("[testOptimisticLocking] Student After: {}", student);
        if (student.getUpdatedCount() != 1) {
            throw new RuntimeException("VALIDATION_ERROR");
        }
        if (student.getAmount() != 110) {
            throw new RuntimeException("VALIDATION_ERROR");
        }
    }

    public void testPessimisticLocking() throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Student29 student = student29Repository.findById(200l).orElseThrow();
        log.info("[testPessimisticLocking] Student Before: {}", student);

        CountDownLatch latch = new CountDownLatch(2);
        modifyStudent29(200l, latch, threadPool);
        modifyStudent29(200l, latch, threadPool);
        latch.await(20, TimeUnit.SECONDS);
        threadPool.shutdown();
        threadPool.awaitTermination(5, TimeUnit.SECONDS);

        student = student29Repository.findById(200l).orElseThrow();
        log.info("[testPessimisticLocking] Student After: {}", student);
        if (student.getUpdatedCount() != 1) {
            throw new RuntimeException("VALIDATION_ERROR");
        }
        if (student.getAmount() != 110) {
            throw new RuntimeException("VALIDATION_ERROR");
        }
    }

    private void modifyStudent30(Long id, CountDownLatch latch, ExecutorService threadPool) {
        threadPool.submit(() -> {
            try {
                Student30 student = student30Repository.findById(id).orElseThrow();
                student.setAmount(student.getAmount() + 10);
                //Delay so that version is updated before next thread saves.
                TimeUnit.SECONDS.sleep(5);
                student30Repository.save(student);
            } catch (ObjectOptimisticLockingFailureException | InterruptedException ex) {
                log.info("[testOptimisticLocking] ObjectOptimisticLockingFailureException: {}", ex.getMessage());
            } finally {
                latch.countDown();
            }
        });
    }

    private void modifyStudent29(Long id, CountDownLatch latch, ExecutorService threadPool) {
        threadPool.submit(() -> {
            transactionTemplate.executeWithoutResult(status -> {
                modifyStudent29Transactional(id, latch);
            });
        });
    }

    /**
     * The whole function should be in a single transaction block for pessimistic locking to work.
     * Keep it in a public function, else it won't work.
     */
    @SneakyThrows
    public void modifyStudent29Transactional(Long id, CountDownLatch latch) {
        try {
            Student29 student = student29Repository.findByIdLocked(id);
            //Student29 student = student29Repository.lockById(id, LockModeType.PESSIMISTIC_WRITE);
            //No other transaction can modify the object with id 200l till this transaction is completed.
            //Others will wait till timeout
            log.info("[testPessimisticLocking] Student: {}, Thread: {}", student, Thread.currentThread().getName());
            student.setAmount(student.getAmount() + 10);
            //Delay so that version is updated before next thread saves. pessimistic lock timeout is set at 10 seconds.
            TimeUnit.SECONDS.sleep(15);
            student29Repository.save(student);
        } catch (PessimisticLockException ex) {
            log.info("[testPessimisticLocking] PessimisticLockException: {}", ex.getMessage());
        } finally {
            latch.countDown();
        }
    }

}
