package com.demo.project82._20_enum_lob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_20")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student20 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    @Enumerated(EnumType.STRING)
    private StudentType studentType;

    @Column(columnDefinition = "text")
    private String notes;

    @Lob
    private String content;
}
