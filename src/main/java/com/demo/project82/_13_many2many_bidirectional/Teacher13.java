package com.demo.project82._13_many2many_bidirectional;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teacher_13")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NamedEntityGraph(name = Teacher13.WITH_STUDENT_GRAPH,
        attributeNodes = @NamedAttributeNode("students"))
public class Teacher13 {

    public static final String WITH_STUDENT_GRAPH = "teacher.student13";

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "teacher_name")
    private String teacherName;

    /**
     * Use Set as it avoid hibernate bags which deletes all and add back.
     */
    @ManyToMany(mappedBy = "teachers", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Builder.Default
    private Set<Student13> students = new HashSet<>();

    public void addStudent(Student13 student) {
        students.add(student);
    }
}
