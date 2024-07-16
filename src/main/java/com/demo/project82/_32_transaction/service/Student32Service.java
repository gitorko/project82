package com.demo.project82._32_transaction.service;

import java.util.concurrent.CountDownLatch;

import com.demo.project82._32_transaction.Student32;
import com.demo.project82._32_transaction.repo.Student32Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class Student32Service {

    final Student32Repository student32Repository;

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public void modifyStuden32(Long id, CountDownLatch latch) {
        Student32 readOnlyStudent = student32Repository.findById(id).orElseThrow();
        readOnlyStudent.setStudentName("UNKNOWN");
        try {
            student32Repository.save(readOnlyStudent);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            latch.countDown();
        }
    }
}
