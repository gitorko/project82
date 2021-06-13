package com.demo.project82;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collections;

import com.demo.project82.college.Department;
import com.demo.project82.college.DepartmentRepository;
import com.demo.project82.college.Person;
import com.demo.project82.college.Student;
import com.demo.project82.college.StudentRepository;
import com.demo.project82.customer.Customer;
import com.demo.project82.customer.CustomerRepository;
import com.demo.project82.customer.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerTest {

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    private DepartmentRepository departmentRepo;
    @Autowired
    private StudentRepository studentRepo;

    @Test
    public void test() {
        Customer customer = Customer.builder().firstName("John").lastName("Doe").build();
        customer.setDateOfBirth(LocalDate.now());
        customer.setGender(Gender.MALE);
        customerRepo.save(customer);


        Assertions.assertEquals(customerRepo.count(), 1);
        customerRepo.findAll().forEach(e -> {
            System.out.println(e);
            System.out.println(e.getUpdatedAt());
        });
    }

}
