package com.demo.project82._11_many2one_unidirectional.repo;

import java.util.List;

import com.demo.project82._11_many2one_unidirectional.Student11;
import com.demo.project82._11_many2one_unidirectional.Course11;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface Course11Repository extends CrudRepository<Course11, Long> {
    @EntityGraph(value = Course11.WITH_STUDENT_GRAPH, type = EntityGraph.EntityGraphType.LOAD)
    List<Course11> findAllByStudent(Student11 student);
}
