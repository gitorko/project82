package com.demo.project82._13_many2many_bidirectional.repo;

import java.util.List;

import com.demo.project82._13_many2many_bidirectional.Student13;
import com.demo.project82._13_many2many_bidirectional.Teacher13;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface Teacher13Repository extends CrudRepository<Teacher13, Long> {
    @EntityGraph(value = Teacher13.WITH_STUDENT_GRAPH, type = EntityGraph.EntityGraphType.LOAD)
    List<Teacher13> findAllByStudents(Student13 student13);
}
