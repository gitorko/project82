package com.demo.project82._10_one2many_many2one_bidirectional_mappedby;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_10")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NamedEntityGraph(name = Student10.WITH_COURSE_GRAPH, attributeNodes = @NamedAttributeNode("courses"))
public class Student10 {

    public static final String WITH_COURSE_GRAPH = "student10.course";

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Course10> courses = new ArrayList<>();

    /**
     * Add method in parent (Student10) to ensure both sides in sync.
     */
    public void addCourse(Course10 course) {
        this.courses.add(course);
        course.setStudent(this);
    }

    /**
     * Remove method in parent (Student10) to ensure both sides in sync.
     */
    public void removeCourse(Course10 course) {
        this.courses.remove(course);
        course.setStudent(null);
    }

}
