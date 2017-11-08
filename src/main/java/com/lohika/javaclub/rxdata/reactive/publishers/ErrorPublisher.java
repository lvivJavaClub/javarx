package com.lohika.javaclub.rxdata.reactive.publishers;

import com.lohika.javaclub.rxdata.customer.CustomerProvider;
import com.lohika.javaclub.rxdata.domain.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * PUBLISHER == OBSERVABLE
 *
 * Error publisher that based on fixed amount of data and then throw an error.
 */
@Component
public class ErrorPublisher extends Observable<Customer> {

  @Autowired
  private CustomerProvider customerProvider;

  @Override
  protected void subscribeActual(Observer<? super Customer> observer) {

    for (int i = 0; i < 100; i++) {
      observer.onNext(customerProvider.generateNextCustomer());
    }

    observer.onError(new NullPointerException());
  }
}
