package com.demo.project82._24_student_composite_key;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student24Identity implements Serializable {

    @NotNull
    private String registrationId;

    @NotNull
    private String studentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student24Identity)) return false;
        Student24Identity that = (Student24Identity) o;
        if (!registrationId.equals(that.registrationId)) {
            return false;
        }
        return studentId.equals(that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

}
