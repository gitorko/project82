package com.demo.project82._18_student_one2one_jointable_unidirectional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contact_18")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact18 {
    @Id
    @GeneratedValue
    private Long id;

    private String address;

}
