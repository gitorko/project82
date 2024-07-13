package com.demo.project82._14_many2many_unidirectional;

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
@Table(name = "teacher_14")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher14 {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "teacher_name")
    private String teacherName;

}
