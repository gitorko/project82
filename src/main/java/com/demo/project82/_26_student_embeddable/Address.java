package com.demo.project82._26_student_embeddable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    private String addressLine;

    private String city;

    private String state;

    private String country;

    private String zipCode;
}
