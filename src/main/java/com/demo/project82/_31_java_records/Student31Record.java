package com.demo.project82._31_java_records;

/**
 * Using Java Records with Spring Data JPA requires some consideration,
 * since JPA traditionally relies on mutable entities and requires no-argument constructors.
 */
public record Student31Record(Long id,
                              String studentName) {
}
