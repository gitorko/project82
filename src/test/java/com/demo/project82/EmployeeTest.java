package com.demo.project82;

import java.util.HashSet;
import java.util.Set;

import com.demo.project82.employee.Address;
import com.demo.project82.employee.User;
import com.demo.project82.employee.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        // Cleanup database tables.
        userRepository.deleteAll();

        // Insert a user with multiple phone numbers and addresses.
        Set<String> phoneNumbers = new HashSet<>();
        phoneNumbers.add("+91-9999999999");
        phoneNumbers.add("+91-4564564564");

        Set<Address> addresses = new HashSet<>();
        addresses.add(new Address("747", "Golf View Road", "Bangalore",
                "Karnataka", "India", "560008"));
        addresses.add(new Address("Plot No 44", "Electronic City", "Bangalore",
                "Karnataka", "India", "560001"));

        User user = new User("John Doe", "JohnDoe@test.com",
                phoneNumbers, addresses);

        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);
    }

}
