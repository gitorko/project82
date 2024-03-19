package com.demo.project82._07_student_one2many_joincolumn;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course_07")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course07 {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "student_id")
    private Integer studentId;
}
