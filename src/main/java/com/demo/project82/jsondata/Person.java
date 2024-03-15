package com.demo.project82.jsondata;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "resource_data", columnDefinition = "jsonb")
    private ObjectNode resourceData;

    private String customerAttributeJSON;

    @Convert(converter = HashMapConverter.class)
    private Map<String, Object> customerAttributes;

    @SneakyThrows
    public void serializeCustomerAttributes() {
        this.customerAttributeJSON = new ObjectMapper().writeValueAsString(customerAttributes);
    }

    @SneakyThrows
    public void deserializeCustomerAttributes() {
        this.customerAttributes = new ObjectMapper().readValue(customerAttributeJSON, HashMap.class);
    }
}
