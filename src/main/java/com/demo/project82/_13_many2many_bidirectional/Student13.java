package com.demo.project82._13_many2many_bidirectional;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_13")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student13 {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    /**
     * No need for CascadeType.REMOVE as both tables are independent.
     * Using CascadeType.ALL will be catastrophic
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "student_13_teacher_join",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "teacher_id")})
    @Builder.Default
    private Set<Teacher13> teachers = new HashSet<>();

    public void addTeacher(Teacher13 teacher) {
        teachers.add(teacher);
    }
}
