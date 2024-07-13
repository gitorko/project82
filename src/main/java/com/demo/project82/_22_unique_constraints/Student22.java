package com.demo.project82._22_unique_constraints;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
/**
 * Don't use these, let liquibase create the constraints.
 */
@Table(name = "student_22", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "user_name"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student22 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "student_name")
    @NotBlank
    private String studentName;

    @Column(name = "user_name")
    @NotBlank
    private String userName;

    @Column(name = "email")
    @NotBlank
    private String email;

}
