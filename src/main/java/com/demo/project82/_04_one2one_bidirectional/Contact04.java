package com.demo.project82._04_one2one_bidirectional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "contact_04")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact04 {
    @Id
    @GeneratedValue
    private Long id;

    private String address;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contact", referencedColumnName = "id")
    private Student04 student;
}
