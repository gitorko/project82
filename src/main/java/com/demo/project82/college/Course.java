package com.demo.project82.college;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COURSE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseEntity {

    @Column
    private String name;

    @Column
    private Integer credits;

    @OneToOne
    private Staff instructor;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @Builder.Default
    private List<Course> prerequisites = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private Department department;

    public Course addPrerequisite(Course prerequisite) {
        prerequisites.add(prerequisite);
        return this;
    }

    public Course(String name, Integer credits, Staff instructor, Department department) {
        this.name = name;
        this.credits = credits;
        this.instructor = instructor;
        this.department = department;
    }
}
