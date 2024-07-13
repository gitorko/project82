package com.demo.project82._31_java_records.repo;

import com.demo.project82._31_java_records.Student31;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Student31Repository extends CrudRepository<Student31, Long> {
}
