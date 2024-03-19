package com.demo.project82._23_student_nartual_id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "student_23")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student23 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "student_name")
    @NotBlank
    private String studentName;

    /**
     * @NaturalId
     * Fields that uniquely identify the entity, but not a suitable primary key.
     */
    @Column(name = "email")
    @NotBlank
    @NaturalId
    private String email;

}
