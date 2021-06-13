package com.demo.project82;

import java.util.Optional;

import com.demo.project82.tourist.Tourist;
import com.demo.project82.tourist.TouristIdentity;
import com.demo.project82.tourist.TouristRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Composite key
 */
@SpringBootTest
public class TouristTest {

    @Autowired
    private TouristRepository touristRepository;

    @Test
    public void test() {
        touristRepository.deleteAllInBatch();

        // Insert a new Employee in the database
        Tourist employee = new Tourist(new TouristIdentity("E-123", "D-457"),
                "John Doe",
                "john@test.com",
                "+91-9999999999");

        touristRepository.save(employee);
        touristRepository.findAll().forEach(System.out::println);
        Optional<Tourist> byId = touristRepository.findById(new TouristIdentity("E-123", "D-457"));
        System.out.println(byId.get());
    }
}
