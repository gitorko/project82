package com.demo.project82._29_pessimistic_locking.repo;

import java.util.List;

import com.demo.project82._29_pessimistic_locking.Student29;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Student29Repository extends CrudRepository<Student29, Long>, CustomStudent29Repository {

    /**
     * Pessimistic Lock Types:
     *
     * 1. LockModeType.PESSIMISTIC_READ - Data cannot be changed by other transactions while the read lock is held. However, other transactions can still read the data
     * 2. LockModeType.PESSIMISTIC_WRITE - Neither read nor write operations by other transactions can proceed on the locked data until the lock is released
     * 3. LockModeType.PESSIMISTIC_FORCE_INCREMENT - Rows are locked and cannot be modified or deleted. For versioned entities, their version number is incremented as soon as the query executes.
     *
     * Below query locks all the rows fetched (row level locking), as it uses @Lock
     *
     * Without time out it will wait forever or depend on the underlying JPA provider or database setting
     */
    @Query("""
            select s
            from Student29 s
            where s.studentName like :studentName
            """)
    @Lock(LockModeType.PESSIMISTIC_READ)
    @QueryHints({
            @QueryHint(name = "jakarta.persistence.lock.timeout", value = "3000")
    })
    List<Student29> findAllByStudentName(@Param("studentName") String studentName);

    /**
     * Acquiring write lock with timeout
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({
            @QueryHint(name = "jakarta.persistence.lock.timeout", value = "3000")
    })
    @Query("""
            select s
            from Student29 s
            where s.id = :id
            """)
    Student29 findByIdLocked(@Param("id") Long id);
}
