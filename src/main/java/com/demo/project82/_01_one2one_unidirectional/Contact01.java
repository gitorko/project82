package com.demo.project82._01_one2one_unidirectional;

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
}
