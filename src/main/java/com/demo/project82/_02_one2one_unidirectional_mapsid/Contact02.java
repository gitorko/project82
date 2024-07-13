package com.demo.project82._02_one2one_unidirectional_mapsid;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contact_02")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact02 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;
}
