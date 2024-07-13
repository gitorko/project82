package com.demo.project82._04_one2one_bidirectional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_04")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student04 {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    /**
     * One with the mappedBy in bi-directional controls the entity
     */
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Contact04 contact;

}
