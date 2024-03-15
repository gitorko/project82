package com.demo.project82.college;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * https://www.callicoder.com/hibernate-spring-boot-jpa-embeddable-demo/
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Staff_member")
public class Staff extends BaseEntity {
    @Embedded
    private Person member;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "street"))
    })
    private Address address;

}
