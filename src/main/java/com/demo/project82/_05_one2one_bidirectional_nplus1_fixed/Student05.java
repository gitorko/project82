package com.demo.project82._05_one2one_bidirectional_nplus1_fixed;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_05")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NamedEntityGraph(name = Student05.WITH_CONTACT_GRAPH,
        attributeNodes = @NamedAttributeNode("contact"))
public class Student05 {

    public static final String WITH_CONTACT_GRAPH = "student05.contact";

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    /**
     * One with the mappedBy in bi-directional controls the entity
     */
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Contact05 contact;

    public void setContact(Contact05 contact) {
        this.contact = contact;
        this.contact.setStudent(this);
    }
}
