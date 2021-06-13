package com.demo.project82.college;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Address {
    @NotNull
    @Size(max = 100)
    private String addressLine1;

    @NotNull
    @Size(max = 100)
    private String addressLine2;

    @NotNull
    @Size(max = 100)
    private String city;
}
