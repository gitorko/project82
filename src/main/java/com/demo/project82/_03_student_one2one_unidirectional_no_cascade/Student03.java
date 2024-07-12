package com.demo.project82._03_student_one2one_unidirectional_no_cascade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_03")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student03 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    @OneToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact03 contact;
}
