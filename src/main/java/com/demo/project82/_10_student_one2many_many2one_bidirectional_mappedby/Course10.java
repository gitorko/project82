package com.demo.project82._10_student_one2many_many2one_bidirectional_mappedby;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "course_10")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NamedEntityGraph(name = Course10.WITH_STUDENT_GRAPH,
        attributeNodes = @NamedAttributeNode("student"))
public class Course10 {

    public static final String WITH_STUDENT_GRAPH = "course10.student";

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    /**
     * Ensure you use lazy fetch to avoid performance issues
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private Student10 student;

    /**
     * The child entity implements the equals and hashCode methods.
     * Since we cannot rely on a natural identifier for equality checks, we need to use the entity identifier instead for the equals method.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course10)) return false;
        return id != null && id.equals(((Course10) o).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }
}
