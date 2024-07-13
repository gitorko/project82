package com.demo.project82._10_one2many_many2one_bidirectional_mappedby.repo;

import java.util.List;

import com.demo.project82._10_one2many_many2one_bidirectional_mappedby.Student10;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface Student10Repository extends CrudRepository<Student10, Long> {
    @EntityGraph(value = Student10.WITH_COURSE_GRAPH, type = EntityGraph.EntityGraphType.LOAD)
    List<Student10> findAll();
}
