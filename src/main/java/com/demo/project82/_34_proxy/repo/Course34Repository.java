package com.demo.project82._34_proxy.repo;

import java.util.List;

import com.demo.project82._34_proxy.Course34;
import com.demo.project82._34_proxy.Student34;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Course34Repository extends JpaRepository<Course34, Long> {
    @EntityGraph(value = Course34.WITH_STUDENT_GRAPH, type = EntityGraph.EntityGraphType.LOAD)
    List<Course34> findAllByStudent(Student34 student);
}
