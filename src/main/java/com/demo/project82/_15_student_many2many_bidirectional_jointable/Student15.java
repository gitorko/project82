package com.demo.project82._15_student_many2many_bidirectional_jointable;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_15")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student15 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    /**
     * This has to be a List
     */
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Student15Teacher15Join> teachers = new ArrayList<>();

    public void addTeacher(Teacher15 teacher) {
        Student15Teacher15Id student15Teacher15Id = Student15Teacher15Id.builder()
                .studentId(this.getId())
                .teacherId(teacher.getId())
                .build();
        Student15Teacher15Join student15Teacher15Join = Student15Teacher15Join.builder()
                .id(student15Teacher15Id)
                .student(this)
                .teacher(teacher)
                .build();
        teachers.add(student15Teacher15Join);
    }
}
