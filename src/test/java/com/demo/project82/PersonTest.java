package com.demo.project82;

import java.util.HashMap;
import java.util.Map;

import com.demo.project82.jsondata.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonTest {
    @Test
    public void test() {
        Person customer = new Person();
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("address", "123 Main Street");
        attributes.put("zipcode", 12345);
        customer.setCustomerAttributes(attributes);
        customer.serializeCustomerAttributes();

        String serialized = customer.getCustomerAttributeJSON();

        customer.setCustomerAttributeJSON(serialized);
        customer.deserializeCustomerAttributes();

        Assertions.assertEquals(attributes, customer.getCustomerAttributes());
    }
}
