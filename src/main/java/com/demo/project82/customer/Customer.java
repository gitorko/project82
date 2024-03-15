package com.demo.project82.customer;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * https://www.netsurfingzone.com/jpa/elementcollection-example-in-hibernate-jpa-using-spring-boot/
 * https://stackoverflow.com/questions/8969059/difference-between-onetomany-and-elementcollection/8969169
 */

@Entity
@Table(name = "customer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends AuditModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Size(max = 45)
    @Column(name = "first_name", unique = true)
    private String firstName;
    @Size(max = 45)
    @Column(name = "last_name")
    private String lastName;

    @Lob
    private String content;

    @Column(name = "dob")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;

    @Column(columnDefinition = "TEXT")
    private String description;

}
