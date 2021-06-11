package com.demo.project82;

import java.util.Collections;

import com.demo.project82.college.Department;
import com.demo.project82.college.DepartmentRepo;
import com.demo.project82.college.Person;
import com.demo.project82.college.Student;
import com.demo.project82.college.StudentRepo;
import com.demo.project82.customer.Customer;
import com.demo.project82.customer.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestService {

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void test() {
        customerRepo.save(Customer.builder().firstName("John").lastName("Doe").build());
        Assertions.assertEquals(customerRepo.count(), 1);
    }

    @Test
    public void collegeTests() {
        studentRepo.save(new Student(new Person("jane", "doe"), true, 20, Collections.emptyList()));
        studentRepo.save(new Student(new Person("john", "doe"), true, 22, Collections.emptyList()));
        studentRepo.save(new Student(new Person("mike", "smith"), true, 18, Collections.emptyList()));
        studentRepo.save(new Student(new Person("ally", "kim"), !true, 19, Collections.emptyList()));
        studentRepo.findAll().forEach(System.out::println);
        studentRepo.findAll().forEach(student -> {
            student.setAge(student.getAge() + 1);
            studentRepo.save(student);
        });
        studentRepo.findAll().forEach(System.out::println);
        studentRepo.deleteAll();
        studentRepo.findAll().forEach(System.out::println);

        departmentRepo.save(Department.builder().name("Humanities").build());
        departmentRepo.flush();
        departmentRepo.saveAndFlush(Department.builder().name("Computers").build());
        departmentRepo.save(Department.builder().name("Political Science").build());
        Assertions.assertEquals(departmentRepo.count(), 3);
        departmentRepo.findAll().forEach(System.out::println);
        departmentRepo.deleteAllInBatch();
        Assertions.assertEquals(departmentRepo.count(), 0);
    }

}
