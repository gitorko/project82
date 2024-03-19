package com.demo.project82._10_student_one2many_bidirectional_mappedby;

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
@NamedEntityGraph(name = Student10.WITH_COURSE_GRAPH,
        attributeNodes = @NamedAttributeNode("courses"))
public class Student10 {

    public static final String WITH_COURSE_GRAPH = "student10.course";

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    /**
     * bidirectional @OneToMany association is the best way to map a one-to-many database relationship
     * when we really need the collection on the parent side of the association.
     */
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<Course10> courses = new ArrayList<>();

    /**
     * We use this to synchronize both sides of the bidirectional association.
     * You should always provide these methods whenever you are working with a bidirectional association
     * Otherwise, you risk very subtle state propagation issues.
     */
    public void addCourse(Course10 course) {
        this.courses.add(course);
        course.setStudent(this);
    }

    public void removeCourse(Course10 course) {
        this.courses.remove(course);
        course.setStudent(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student10)) return false;
        return id != null && id.equals(((Student10) o).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

}
