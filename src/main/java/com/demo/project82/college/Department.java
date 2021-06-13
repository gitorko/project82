package com.demo.project82.college;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "Department")
public class Department extends BaseEntity{

    @Column
    private String name;

    @OneToOne
    private Staff chair;

    @Builder.Default
    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Department(String name, Staff chair) {
        this.name = name;
        this.chair = chair;
    }
}
