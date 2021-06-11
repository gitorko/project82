package com.demo.project82.college;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STUDENT")
public class Student extends BaseEntity {

    @Embedded
    private Person attendee;

    @Column
    private boolean fullTime;

    @Column
    private Integer age;

    @OneToMany
    @Builder.Default
    private List<Course> courses = new ArrayList<>();
}
