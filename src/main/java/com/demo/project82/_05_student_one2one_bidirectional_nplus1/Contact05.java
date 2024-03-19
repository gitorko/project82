package com.demo.project82._05_student_one2one_bidirectional_nplus1;

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
@Table(name = "contact_05")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact05 {
    @Id
    @GeneratedValue
    private Long id;

    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Student05 student;
}
