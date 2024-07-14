package com.demo.project82;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.demo.project82._29_pessimistic_locking.Student29;
import com.demo.project82._29_pessimistic_locking.repo.Student29Repository;
import com.demo.project82._30_optimistic_locking.Student30;
import com.demo.project82._30_optimistic_locking.repo.Student30Repository;
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
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor
@EnableTransactionManagement
@Slf4j
public class Main {

    final Student29Repository student29Repository;
    final Student30Repository student30Repository;

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
        };
    }

    public void testOptimisticLocking() throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Student30 student = student30Repository.findById(100l).orElseThrow();
        log.info("[testOptimisticLocking] Student Before: {}", student);

        CountDownLatch latch = new CountDownLatch(2);
        modifyStudent30(100l, latch, threadPool);
        modifyStudent30(100l, latch, threadPool);
        latch.await(10, TimeUnit.SECONDS);
        threadPool.shutdown();
        threadPool.awaitTermination(5, TimeUnit.SECONDS);

        student = student30Repository.findById(100l).orElseThrow();
        log.info("[testOptimisticLocking] Student After: {}", student);
        assert student.getUpdatedCount() == 1;
    }

    public void testPessimisticLocking() throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Student29 student = student29Repository.findById(100l).orElseThrow();
        log.info("[testPessimisticLocking] Student Before: {}", student);

        CountDownLatch latch = new CountDownLatch(2);
        modifyStudent29(100l, latch, threadPool);
        modifyStudent29(100l, latch, threadPool);
        latch.await(20, TimeUnit.SECONDS);
        threadPool.shutdown();
        threadPool.awaitTermination(5, TimeUnit.SECONDS);

        student = student29Repository.findById(100l).orElseThrow();
        log.info("[testPessimisticLocking] Student After: {}", student);
        assert student.getUpdatedCount() == 1;
    }

    private void modifyStudent30(Long id, CountDownLatch latch, ExecutorService threadPool) {
        threadPool.submit(() -> {
            try {
                Student30 student = student30Repository.findById(id).orElseThrow();
                student.setStudentName(student.getStudentName() + "_" + Thread.currentThread().getName());
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

    public void modifyStudent29(Long id, CountDownLatch latch, ExecutorService threadPool) {
        threadPool.submit(() -> {
            transactionTemplate.executeWithoutResult(status -> {
                modifyStudent29Transactional(id, latch);
            });
        });
    }

    /**
     * The whole function should be in a single transaction block for pessimistic locking to work.
     */
    @SneakyThrows
    public void modifyStudent29Transactional(Long id, CountDownLatch latch) {
        try {
            Student29 student = student29Repository.findByIdLocked(id);
            //Student29 student = student29Repository.lockById(id, LockModeType.PESSIMISTIC_WRITE);
            //No other transaction can modify the object with id 100l till this transaction is completed.
            //Others will wait till timeout
            log.info("[testPessimisticLocking] Student: {}, Thread: {}", student, Thread.currentThread().getName());
            student.setStudentName(student.getStudentName() + "_" + Thread.currentThread().getName());
            student.setUpdatedCount(student.getUpdatedCount() + 1);
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
