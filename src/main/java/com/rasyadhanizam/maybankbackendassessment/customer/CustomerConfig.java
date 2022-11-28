package com.rasyadhanizam.maybankbackendassessment.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository) {
        return args -> {
            Customer jimmy = new Customer(
                    "Maybank",
                    "Jimmy",
                    "jimmy@x.y",
                    LocalDate.of(1990, Month.NOVEMBER, 15),
                    "0192345678",
                    "saving",
                    (float) 1999.90,
                    "MB123456789012"
            );

            Customer siti = new Customer(
                    "Maybank",
                    "Siti",
                    "siti@x.y",
                    LocalDate.of(1990, Month.NOVEMBER, 15),
                    "0192345678",
                    "saving",
                    (float) 1999.90,
                    "MB123456789012"
            );

            repository.saveAll(
                    List.of(jimmy,siti)
            );
        };
    }
}
