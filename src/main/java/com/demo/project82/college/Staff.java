package com.demo.project82.college;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * https://www.callicoder.com/hibernate-spring-boot-jpa-embeddable-demo/
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Staff_member")
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
