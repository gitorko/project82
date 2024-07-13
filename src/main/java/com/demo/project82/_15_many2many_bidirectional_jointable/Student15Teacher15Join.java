package com.demo.project82._15_many2many_bidirectional_jointable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_15_teacher_15_join")
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
