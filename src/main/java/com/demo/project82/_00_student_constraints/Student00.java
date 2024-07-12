package com.demo.project82._00_student_constraints;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_00")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student00 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "name", unique = true)
    @NotBlank
    private String studentName;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(name = "user_name", updatable = false, insertable = false, unique = true, nullable = false)
    private String userName;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dob;

    @NotNull
    @Column(name = "registered_on")
    private LocalDate registered_on;

    @Min(18)
    @Max(55)
    private Integer age;

    @Email
    @NotBlank
    private String email;

    @Digits(integer = 1, fraction = 2)
    @Column(name = "gpa_score", precision = 3, scale = 2)
    private BigDecimal gpaScore;

    @Lob
    private byte[] blob;

    @Column(columnDefinition = "text")
    private String notes;
}
