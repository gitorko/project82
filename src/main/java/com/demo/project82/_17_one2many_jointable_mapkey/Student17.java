package com.demo.project82._17_one2many_jointable_mapkey;

import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.MapKey;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_17")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student17 {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    /**
     * @JoinTable stores the id of  both the entity into a separate table
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_17_course_17_join",
            joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id")})
    @MapKey(name = "courseName")
    private Map<String, Course17> courseMap;

}
