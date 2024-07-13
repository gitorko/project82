package com.demo.project82._12_one2many_elementcollection_unidirectional;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_12")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student12 {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    /**
     *  @ElementCollection is used when elements are completely owned by the containing entities
     *  They are modified when the entity is modified, deleted when the entity is deleted.
     *  They can't have their own lifecycle.
     *
     *  This will have the N+1 problem
     */
    @ElementCollection
    @CollectionTable(name = "phone_12", joinColumns = @JoinColumn(name = "phone_id"))
    private List<Phone12> phones;
}
