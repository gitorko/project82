package com.demo.project82.tourist;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

/**
 * https://howtodoinjava.com/hibernate/hibernate-naturalid-example-tutorial/
 */
@Entity
@Table(name = "tourist")
@Data
public class Tourist {
    @EmbeddedId
    private TouristIdentity employeeIdentity;

    @NotNull
    @Size(max = 60)
    private String name;

    @NaturalId
    @NotNull
    @Size(max = 60)
    private String email;

    @Size(max = 15)
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    public Tourist() {

    }

    public Tourist(TouristIdentity employeeIdentity, String name, String email, String phoneNumber) {
        this.employeeIdentity = employeeIdentity;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}
