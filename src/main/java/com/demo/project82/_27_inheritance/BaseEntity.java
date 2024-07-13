package com.demo.project82._27_inheritance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
}
