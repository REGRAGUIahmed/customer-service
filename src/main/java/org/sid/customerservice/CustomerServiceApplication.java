package org.sid.customerservice;

import org.sid.customerservice.Entities.Customer;
import org.sid.customerservice.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.stream.Stream;

@SpringBootApplication
@EnableFeignClients
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Customer.class);
            Customer customer1= new Customer(null,"REGRAGUI","Ahmed", "contact@regragui.ma");
            customerRepository.save(customer1);
            customerRepository.save(new Customer(null,"REGRAGUI","Ali", "contact2@regragui.ma"));
            customerRepository.save(new Customer(null,"HAJJI","MOHAMED", "contact2@HAJJI.ma"));
            customerRepository.save(new Customer(null,"LOKILI","ZAKARIA", "contact2@LOKILI.ma"));
            customerRepository.save(new Customer(null,"LMOKHTAR","HAKIM", "contact2@HAKIM.ma"));
        };
    }
}