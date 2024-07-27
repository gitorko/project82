package com.demo.project82._33_query_by_example.service;

import java.util.List;

import com.demo.project82._33_query_by_example.Student33;
import com.demo.project82._33_query_by_example.repo.Student33Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Student33Service {

    final Student33Repository student33Repository;

    public Student33 findByOneExample1(Student33 student) {
        return student33Repository.findOne(Example.of(student)).orElseThrow();
    }

    public Student33 findByOneExample2(Student33 customer) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.EXACT);
        Example<Student33> example = Example.of(customer, matcher);
        return student33Repository.findOne(example).orElseThrow();
    }

    public List<Student33> findAllExample1(Student33 student) {
        return student33Repository.findAll(Example.of(student));
    }

    public List<Student33> findAllExample2(Student33 student) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.EXACT);
        Example<Student33> example = Example.of(student, matcher);
        return student33Repository.findAll(example);
    }

    public Page<Student33> findAllByPage(PageRequest pageRequest) {
        return student33Repository.findAll(pageRequest);
    }

    public Page<Student33> findAllByPageSort(PageRequest pageRequest) {
        return student33Repository.findAll(pageRequest.withSort(Sort.by("studentName").descending()));
    }

    public List<Student33> findByNameAndAgeIndex(String name, Integer age) {
        return student33Repository.findByNameAndAgeIndex(name, age);
    }

    public List<Student33> findByNameAndAgeParam(String name, Integer age) {
        return student33Repository.findByNameAndAgeParam(name, age);
    }

}
