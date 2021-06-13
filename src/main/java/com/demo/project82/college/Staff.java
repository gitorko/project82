package com.demo.project82.college;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Staff_member")
public class Staff extends BaseEntity {
    @Embedded
    private Person member;
}
