package com.demo.project82._08_student_one2many_unidirectional_nplus1.repo;

import java.util.List;

import com.demo.project82._08_student_one2many_unidirectional_nplus1.Student08;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface Student08Repository extends CrudRepository<Student08, Long> {
    @EntityGraph(value = Student08.WITH_COURSE_GRAPH, type = EntityGraph.EntityGraphType.LOAD)
    List<Student08> findAll();
}
