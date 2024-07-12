package com.demo.project82._09_student_one2many_mappedby_wrong;

import java.util.List;

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
@Table(name = "student_09")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NamedEntityGraph(name = Student09.WITH_COURSE_GRAPH, attributeNodes = @NamedAttributeNode("courses"))
public class Student09 {

    public static final String WITH_COURSE_GRAPH = "student09.course";

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    /**
     * Wrong approach
     * Here course (child) owns the relationship as mappedBy present
     * But course doesn't define a @JoinColumn so the relation is not created
     *
     * mappedBy - defined in reference side
     * @JoinColumn - defined in owning side
     *
     * mappedBy in the parent entity to indicate the child entity's field that owns the relationship.
     */
    @OneToMany(mappedBy = "studentId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course09> courses;

}
