package com.demo.project82._25_map;

import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_25")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student25 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "student_name")
    @NotBlank
    private String studentName;

    @Convert(converter = EntityConverter.class)
    @Column(name = "attributes", columnDefinition = "jsonb")
    private Map<String, Object> attributes;

}
