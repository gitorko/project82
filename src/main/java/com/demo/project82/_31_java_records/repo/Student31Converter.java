package com.demo.project82._31_java_records.repo;

import com.demo.project82._31_java_records.Student31;
import com.demo.project82._31_java_records.Student31Record;
import jakarta.persistence.AttributeConverter;
import org.springframework.stereotype.Component;

@Component
public class Student31Converter implements AttributeConverter<Student31Record, Student31> {

    @Override
    public Student31 convertToDatabaseColumn(Student31Record student) {
        if (student == null) {
            return null;
        }
        return new Student31(
                student.id(),
                student.studentName()
        );
    }

    @Override
    public Student31Record convertToEntityAttribute(Student31 student) {
        if (student == null) {
            return null;
        }
        return new Student31Record(
                student.getId(),
                student.getStudentName()
        );
    }
}
