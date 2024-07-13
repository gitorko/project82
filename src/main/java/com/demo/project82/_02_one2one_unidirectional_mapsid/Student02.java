package com.demo.project82._02_one2one_unidirectional_mapsid;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_02")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student02 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    /**
     * Instead of having 2 columns to index you will now have 1 column
     */
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Contact02 contact;
}
