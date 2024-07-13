package com.demo.project82._29_pessimistic_locking.repo;

import java.util.Map;

import com.demo.project82._29_pessimistic_locking.Student29;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class CustomStudent29RepositoryImpl implements CustomStudent29Repository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Fetches the row with a lock
     * Without timeout it will wait forever
     * Timeout after 3 seconds
     */
    @Override
    @Transactional
    public Student29 lockById(Long id, LockModeType lockMode) {
        Map<String, Object> properties = Map.of(
                "jakarta.persistence.lock.timeout", "3000"
        );
        return entityManager.find(Student29.class, id, lockMode, properties);
    }

}
