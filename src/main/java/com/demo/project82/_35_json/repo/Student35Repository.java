package com.demo.project82._35_json.repo;

import java.util.List;

import com.demo.project82._35_json.Student35;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Student35Repository extends CrudRepository<Student35, Long> {

    /**
     * Querying using JSON columns
     * You can also create index on json
     * CREATE INDEX idx_city ON student_35 USING HASH((payload->'city'));
     */
    @Query(value = "SELECT * FROM student_35 WHERE payload->>'city' = :city", nativeQuery = true)
    List<Student35> findByCity(String city);
}
