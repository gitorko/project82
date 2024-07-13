package com.demo.project82._29_pessimistic_locking.service;

import com.demo.project82._29_pessimistic_locking.Student29;
import com.demo.project82._29_pessimistic_locking.repo.Student29Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Student29Service {

    private final Student29Repository student29Repository;

    public Student29 findById(Long id) {
        return student29Repository.findById(id).orElseThrow();
    }

    public Student29 findAndLockStudent(Long id) {
        return student29Repository.findByIdLocked(id);
    }

    public Student29 saveStudent(Student29 student) {
        return student29Repository.save(student);
    }
}
