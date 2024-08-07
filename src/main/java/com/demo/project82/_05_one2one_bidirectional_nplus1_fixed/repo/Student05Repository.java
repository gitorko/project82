package com.demo.project82._05_one2one_bidirectional_nplus1_fixed.repo;

import java.util.List;

import com.demo.project82._05_one2one_bidirectional_nplus1_fixed.Student05;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface Student05Repository extends CrudRepository<Student05, Long> {
    @EntityGraph(value = Student05.WITH_CONTACT_GRAPH, type = EntityGraph.EntityGraphType.LOAD)
    List<Student05> findAll();
}
