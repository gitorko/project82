package com.demo.project82._01_student_one2one_unidirectional;

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
@Table(name = "contact_01")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact01 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    /**
     * Uni-Directional
     * This table will need 2 index, one on the primary key and other on foreign key.
     * Use @MapsId
     *
     * @JoinColumn - if name exists it will use it else will create a new column
     */
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Student01 student;
}
