package com.demo.project82._06_student_one2many_3tables_unidirectional_wrong;

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
@Table(name = "course_06")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course06 {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "course_name")
    private String course_name;
}
