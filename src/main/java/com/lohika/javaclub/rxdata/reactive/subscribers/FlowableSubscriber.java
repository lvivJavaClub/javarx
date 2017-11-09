package com.lohika.javaclub.rxdata.reactive.subscribers;

import com.lohika.javaclub.rxdata.domain.Customer;
import com.lohika.javaclub.rxdata.reactive.publishers.SimplePublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import io.reactivex.BackpressureStrategy;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Convert simple publisher to Flowable publisher and define backpressure strategy. Then using
 * Disposable subscriber manipulate with data flow frequency.
 */
//@Component
public class FlowableSubscriber {

  @Autowired
  private SimplePublisher publisher;

  @PostConstruct
  public void subscribe() {

    publisher
        .subscribeOn(Schedulers.newThread())
        .toFlowable(BackpressureStrategy.DROP)
        .subscribe(new DisposableSubscriber<Customer>() {

          @Override
          protected void onStart() {
            request(1);
          }

          @Override
          public void onNext(Customer customer) {
            System.out.println("Customer : " + customer);

            try {
              Thread.sleep(1000);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

            request(1);
          }

          @Override
          public void onError(Throwable t) {

          }

          @Override
          public void onComplete() {

          }
        });
  }


}
