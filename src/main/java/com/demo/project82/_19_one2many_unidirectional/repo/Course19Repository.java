package com.demo.project82._19_one2many_unidirectional.repo;

import java.util.List;

import com.demo.project82._19_one2many_unidirectional.Course19;
import com.demo.project82._19_one2many_unidirectional.Student19;
import org.springframework.data.repository.CrudRepository;

public interface Course19Repository extends CrudRepository<Course19, Long> {

    List<Course19> findAllByStudent(Student19 student);
}
