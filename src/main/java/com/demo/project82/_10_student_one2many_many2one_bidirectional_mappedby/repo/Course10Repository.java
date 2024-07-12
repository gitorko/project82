package com.demo.project82._10_student_one2many_many2one_bidirectional_mappedby.repo;

import java.util.List;

import com.demo.project82._10_student_one2many_many2one_bidirectional_mappedby.Student10;
import com.demo.project82._10_student_one2many_many2one_bidirectional_mappedby.Course10;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface Course10Repository extends CrudRepository<Course10, Long> {
    @EntityGraph(value = Course10.WITH_STUDENT_GRAPH, type = EntityGraph.EntityGraphType.LOAD)
    List<Course10> findAllByCourseName(String courseName);

    List<Course10> findAllByStudent(Student10 student);
}
