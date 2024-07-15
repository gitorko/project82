package com.demo.project82._30_optimistic_locking.service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.demo.project82._30_optimistic_locking.Student30;
import com.demo.project82._30_optimistic_locking.repo.Student30Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class Student30Service {

    final Student30Repository student30Repository;

    public void modifyStudent30(Long id, CountDownLatch latch) {
        try {
            Student30 student = student30Repository.findById(id).orElseThrow();
            student.setAmount(student.getAmount() + 10);
            //Delay so that version is updated before next thread saves.
            TimeUnit.SECONDS.sleep(5);
            student30Repository.save(student);
        } catch (ObjectOptimisticLockingFailureException | InterruptedException ex) {
            log.error("[testOptimisticLocking] ObjectOptimisticLockingFailureException: {}", ex.getMessage());
        } finally {
            latch.countDown();
        }
    }
}
