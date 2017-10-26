package com.lohika.javaclub.rxdata;

import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class TestController {

    @Autowired
    Faker faker;

    @Autowired
    CustomerPublisherService publisherService;

    @GetMapping(value = "/one")
    public Customer getAllCustomers() {
        return buildCustomer(0);
    }

    @GetMapping(value = "/rand")
    public List<Customer> getCustomers(@RequestParam int count) {
        List<Customer> customers = IntStream.range(0, count).mapToObj(this::buildCustomer).collect(Collectors.toList());
        customers.forEach(publisherService::call);
        return customers;
    }

    private Customer buildCustomer(int i) {
        return Customer.builder()
                .street(faker.address().streetAddress())
                .name(faker.name().firstName())
                .surName(faker.name().lastName())
                .build();
    }
}