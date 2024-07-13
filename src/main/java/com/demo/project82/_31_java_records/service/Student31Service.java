package com.demo.project82._31_java_records.service;

import com.demo.project82._31_java_records.Student31;
import com.demo.project82._31_java_records.Student31Record;
import com.demo.project82._31_java_records.repo.Student31Converter;
import com.demo.project82._31_java_records.repo.Student31Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Student31Service {

    final Student31Repository repository;
    final Student31Converter converter;

    public Student31Record save(Student31Record student) {
        Student31 entity = converter.convertToDatabaseColumn(student);
        Student31 savedEntity = repository.save(entity);
        return converter.convertToEntityAttribute(savedEntity);
    }

    public Student31Record findById(Long id) {
        Student31 entity = repository.findById(id).orElse(null);
        return converter.convertToEntityAttribute(entity);
    }
}
