package com.demo.project82._09_student_one2many_mappedby_nplus1;

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
@NamedEntityGraph(name = Student09.WITH_COURSE_GRAPH,
        attributeNodes = @NamedAttributeNode("courses"))
public class Student09 {

    public static final String WITH_COURSE_GRAPH = "student09.course";

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    /**
     * Will not create the 3rd table
     * N+1 issue resolved
     */
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "studentId",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Course09> courses;

}
