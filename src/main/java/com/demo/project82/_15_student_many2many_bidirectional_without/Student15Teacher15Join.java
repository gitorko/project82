package com.demo.project82._15_student_many2many_bidirectional_without;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student15Teacher15Join {

    @EmbeddedId
    private Student15Teacher15Id id;

    @ManyToOne
    @MapsId("studentId")
    private Student15 student;

    @ManyToOne
    @MapsId("teacherId")
    private Teacher15 teacher;
}
