package com.lohika.javaclub.rxdata;

import com.github.javafaker.Faker;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.reactivex.Flowable;

@Component
public class CustomerPublisher extends Flowable<Customer> {

  public boolean work = true;

  @Autowired
  private Faker faker;


  private Customer buildCustomer() {
    Customer customer = new Customer();

    customer.setStreet(faker.address().streetAddress());
    customer.setName(faker.name().firstName());
    customer.setSurName(faker.name().lastName());

    return customer;
  }

  @Override
  protected void subscribeActual(Subscriber<? super Customer> s) {

    s.onSubscribe(new Subscription() {
      @Override
      public void request(long n) {
        if (work) {
          while (n > 0) {
            s.onNext(buildCustomer());
            n--;
          }
        } else {
          s.onComplete();
        }
      }

      @Override
      public void cancel() {
        s.onComplete();
      }
    });

  }

  public void stop() {
    work = false;
  }
}
