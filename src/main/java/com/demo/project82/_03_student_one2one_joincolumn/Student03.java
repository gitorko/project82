package com.demo.project82._03_student_one2one_joincolumn;

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
@Table(name = "student_03")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student03 {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "student_name")
    private String studentName;
}
