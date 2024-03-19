package com.demo.project82._03_student_one2one_joincolumn;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contact_03")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact03 {
    @Id
    @GeneratedValue
    private Long id;

    private String address;

    /**
     * Uni-Directional
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Student03 student;
}
