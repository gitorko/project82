package com.demo.project82._33_query_by_example.repo;

import java.util.List;

import com.demo.project82._33_query_by_example.Student33;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Student33Repository extends JpaRepository<Student33, Long> {

    @Query("select e from Student33 e where e.studentName = ?1 and e.age = ?2")
    List<Student33> findByNameAndAgeIndex(String name, Integer age);

    @Query("select e from Student33 e where e.studentName = :name and e.age = :age")
    List<Student33> findByNameAndAgeParam(@Param("name") String name, @Param("age") Integer age);
}
