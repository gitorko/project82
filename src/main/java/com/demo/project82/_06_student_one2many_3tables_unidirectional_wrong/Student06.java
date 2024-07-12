package com.demo.project82._06_student_one2many_3tables_unidirectional_wrong;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_06")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student06 {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    /**
     * Creates a 3rd join table
     * Has N+1 issue
     * When 3 tables get created, from a DBA, this looks more like a many-to-many database association than a
     * one-to-many relationship. Not very efficient either.
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course06> courses;

}
