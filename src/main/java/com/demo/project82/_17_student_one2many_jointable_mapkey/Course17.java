package com.demo.project82._17_student_one2many_jointable_mapkey;

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
@Table(name = "course_17")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course17 {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "course_name")
    private String courseName;
}
