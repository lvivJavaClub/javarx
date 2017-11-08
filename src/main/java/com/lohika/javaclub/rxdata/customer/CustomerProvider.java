package com.lohika.javaclub.rxdata.customer;

import com.github.javafaker.Faker;
import com.lohika.javaclub.rxdata.domain.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerProvider {

  @Autowired
  private Faker faker;

  public Customer generateNextCustomer() {
    Customer customer = new Customer();

    customer.setStreet(faker.address().streetAddress());
    customer.setName(faker.name().firstName());
    customer.setSurName(faker.name().lastName());

    return customer;
  }
}
