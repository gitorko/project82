package com.demo.project82._14_many2many_unidirectional;

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
@Table(name = "student_14")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student14 {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "student_14_teacher_join",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "teacher_id")})
    @Builder.Default
    private Set<Teacher14> teachers = new HashSet<>();

    public void addTeacher(Teacher14 teacher) {
        teachers.add(teacher);
    }

    public void removeTeacher(Teacher14 teacher) {
        teachers.remove(teacher);
    }
}
