package com.demo.project82._16_one2many_jointable_unidirectional;

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
@Table(name = "course_16")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course16 {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "course_name")
    private String courseName;
}
