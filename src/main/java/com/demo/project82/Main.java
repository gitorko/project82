package com.demo.project82;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor
@Slf4j
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner start() {
        return (args) -> {
            log.info("DB Created!");
        };
    }

//    public void testUser() {
//        userRepository.deleteAll();
//
//        // Insert a user with multiple phone numbers and addresses.
//        Set<String> phoneNumbers = new HashSet<>();
//        phoneNumbers.add("+91-9999999999");
//        phoneNumbers.add("+91-4564564564");
//
//        Set<Address> addresses = new HashSet<>();
//        addresses.add(new Address("747", "Golf View Road", "Bangalore",
//                "Karnataka", "India", "560008"));
//        addresses.add(new Address("Plot No 44", "Electronic City", "Bangalore",
//                "Karnataka", "India", "560001"));
//
//        User user = new User("John Doe", "JohnDoe@test.com",
//                phoneNumbers, addresses);
//
//        userRepository.save(user);
//        userRepository.findAll().forEach(System.out::println);
//    }

}
