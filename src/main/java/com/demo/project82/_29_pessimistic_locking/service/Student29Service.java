package com.demo.project82._29_pessimistic_locking.service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.demo.project82._29_pessimistic_locking.Student29;
import com.demo.project82._29_pessimistic_locking.repo.Student29Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class Student29Service {

    final Student29Repository student29Repository;

    /**
     * To ensure that the transaction commits and the update is flushed immediately after the method completes, you can explicitly manage the flush and commit behavior
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * The whole function should be in a single transaction block for pessimistic locking to work.
     */
    @SneakyThrows
    @Transactional
    public void modifyStudent29(Long id, CountDownLatch latch) {
        try {
            //explicitly setting flush mode to commit, spring.datasource.hikari.auto-commit=true
            entityManager.setFlushMode(FlushModeType.COMMIT);

            Student29 student = student29Repository.findByIdLocked(id);
            //Student29 student = student29Repository.lockById(id, LockModeType.PESSIMISTIC_WRITE);
            //No other transaction can modify the object with id 200l till this transaction is completed.
            //Others will wait till timeout
            log.info("[testPessimisticLocking] Student: {}, Thread: {}", student, Thread.currentThread().getName());
            student.setAmount(student.getAmount() + 10);
            // Delay so that version is updated before next thread saves. pessimistic lock timeout is set at 10 seconds
            // So this thread hold the transaction for 15 seconds
            TimeUnit.SECONDS.sleep(15);
            student29Repository.save(student);
        } catch (PessimisticLockingFailureException ex) {
            log.error("[testPessimisticLocking] PessimisticLockingFailureException: {}", ex.getMessage());
        } finally {
            //without the explict flush the transaction might not be flushed immediately after the method is complete.
            entityManager.flush();
            latch.countDown();
        }
    }
}
