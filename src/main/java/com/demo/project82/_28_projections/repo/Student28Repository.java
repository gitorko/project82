package com.demo.project82._28_projections.repo;

import com.demo.project82._28_projections.Student28;
import com.demo.project82._28_projections.Student28DTO;
import com.demo.project82._28_projections.Student28Pojo;
import com.demo.project82._28_projections.Student28View;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Student28Repository extends CrudRepository<Student28, Long> {
    @Query("select s.studentName, (s.monthlySalary * 12) as annualSalary from Student28 s where s.studentName=:studentName")
    Student28View getStudent27View(String studentName);

    @Query("select new com.demo.project82._28_projections.Student28Pojo" +
            "(s.studentName, s.monthlySalary * 12) from Student28 s where s.studentName=:studentName")
    Student28Pojo getStudent27Pojo(String studentName);

    @Query("select new com.demo.project82._28_projections.Student28DTO" +
            "(s.studentName, s.monthlySalary * 12) from Student28 s where s.studentName=:studentName")
    Student28DTO getStudent27Dto(String studentName);
}
