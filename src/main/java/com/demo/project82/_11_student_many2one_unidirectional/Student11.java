package com.demo.project82._11_student_many2one_unidirectional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_11")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student11 {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    /**
     * We don't add a managed collection as courses can become more over a given time.
     * Performance will not be impacted while fetching student records each time.
     */
}
