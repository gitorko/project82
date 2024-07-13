package com.demo.project82._27_inheritance;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_27")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student27 extends BaseEntity {

    @NotBlank
    private String studentName;

}
