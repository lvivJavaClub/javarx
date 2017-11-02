package com.lohika.javaclub.rxdata;

import org.springframework.stereotype.Component;

import io.reactivex.subscribers.DisposableSubscriber;

@Component
public class CustomerSubscriber extends DisposableSubscriber<Customer> {

  @Override
  protected void onStart() {
    request(3);
  }

  @Override
  public void onNext(Customer customer) {
    System.out.print(Thread.currentThread().getName());
    System.out.println("Customer :  " + customer);

    slowDown();

    request(5);
  }

  @Override
  public void onError(Throwable t) {
    System.err.println("Error: " + t.getMessage());
  }

  @Override
  public void onComplete() {
    System.out.printf("COMPLETE!");
  }

  private void slowDown() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      //silent
    }
  }

}
