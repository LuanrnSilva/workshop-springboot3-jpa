package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        
        Category c1 = new Category(null, "Eletronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");
        
        User u1 = new User(null, "L", "l@gmail.com", "123124123", "12345");
        User u2 = new User(null, "C", "c@gmail.com", "819231212", "12345"); 

        Order o1 = new Order(null, Instant.parse("2024-09-21T09:15:02Z"), OrderStatus.PAID , u1);
        Order o2 = new Order(null, Instant.parse("2024-09-25T09:15:02Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o3 = new Order(null, Instant.parse("2024-09-23T09:15:02Z"), OrderStatus.WAITING_PAYMENT, u2);

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

        userRepository.saveAll(Arrays.asList(u1, u2));

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
