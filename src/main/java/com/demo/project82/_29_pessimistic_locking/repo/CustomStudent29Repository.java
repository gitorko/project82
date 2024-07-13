package com.demo.project82._29_pessimistic_locking.repo;

import com.demo.project82._29_pessimistic_locking.Student29;
import jakarta.persistence.LockModeType;

public interface CustomStudent29Repository {
    Student29 lockById(Long id, LockModeType lockMode);
}