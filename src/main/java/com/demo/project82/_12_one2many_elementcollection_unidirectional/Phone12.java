package com.demo.project82._12_one2many_elementcollection_unidirectional;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Phone12 {

    @Column(name = "phone")
    private String phone;

}
