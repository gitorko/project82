package com.demo.project82.college;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseView {
    private String name;
    private String instructorLastName;
    private String deptName;
}
