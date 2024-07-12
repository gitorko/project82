package com.demo.project82._09_student_one2many_mappedby_wrong.repo;

import java.util.List;

import com.demo.project82._09_student_one2many_mappedby_wrong.Student09;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface Student09Repository extends CrudRepository<Student09, Long> {
    @EntityGraph(value = Student09.WITH_COURSE_GRAPH, type = EntityGraph.EntityGraphType.LOAD)
    List<Student09> findAll();
}
