package com.demo.project82._15_student_many2many_bidirectional_without;

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
@Table(name = "teacher_15")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher15 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "teacher_name")
    private String teacherName;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Student15Teacher15Join> students = new ArrayList<>();

    public void addStudent(Student15 student) {
        Student15Teacher15Id student15Teacher15Id = Student15Teacher15Id.builder()
                .studentId(student.getId())
                .teacherId(this.getId())
                .build();
        Student15Teacher15Join student15Teacher15Join = Student15Teacher15Join.builder()
                .id(student15Teacher15Id)
                .student(student)
                .teacher(this)
                .build();
        students.add(student15Teacher15Join);
    }
}
