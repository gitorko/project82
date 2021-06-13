package com.demo.project82.college;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "COURSE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseEntity{

    @Column
    private String name;

    @Column
    private Integer credits;

    @OneToOne
    private Staff instructor;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Course> prerequisites = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private Department department;

    public Course addPrerequisite(Course prerequisite){
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
