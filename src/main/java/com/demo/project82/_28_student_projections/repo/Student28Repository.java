package com.demo.project82._28_student_projections.repo;

import com.demo.project82._28_student_projections.Student28;
import com.demo.project82._28_student_projections.Student28View;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Student28Repository extends CrudRepository<Student28, Long> {
    @Query("select new com.demo.project82._28_student_projections.Student28View" +
            "(s.studentName) from Student28 s where s.studentName=:studentName")
    Student28View getStudent27View(String studentName);
}
