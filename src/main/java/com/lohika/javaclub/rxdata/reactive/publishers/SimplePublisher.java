package com.lohika.javaclub.rxdata.reactive.publishers;

import com.lohika.javaclub.rxdata.customer.CustomerProvider;
import com.lohika.javaclub.rxdata.domain.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * PUBLISHER == OBSERVABLE
 *
 * Simple publisher that based on infinity loop and produce infinity amount of Customer data.
 */
@Component
public class SimplePublisher extends Observable<Customer> {

  @Autowired
  private CustomerProvider customerProvider;

  @Override
  protected void subscribeActual(Observer<? super Customer> observer) {

    while (true) {

      try {

        Customer c = customerProvider.generateNextCustomer();

        if (Objects.isNull(c)) {

          observer.onComplete();
        } else {

          observer.onNext(c);
        }


      } catch (Exception e) {
        observer.onError(e);
      }
    }
  }
}
