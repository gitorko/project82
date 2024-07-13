package com.demo.project82._24_composite_key;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_24")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student24 {

    @EmbeddedId
    private Student24Identity student24Identity;

    @Column(name = "student_name")
    @NotBlank
    private String studentName;

}
