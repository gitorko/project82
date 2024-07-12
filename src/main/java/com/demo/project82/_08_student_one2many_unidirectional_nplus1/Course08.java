package com.demo.project82._08_student_one2many_unidirectional_nplus1;

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
@Table(name = "course_08")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course08 {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "student_id")
    private Integer studentId;
}
