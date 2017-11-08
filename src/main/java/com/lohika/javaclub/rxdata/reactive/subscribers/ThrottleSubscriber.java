package com.lohika.javaclub.rxdata.reactive.subscribers;

import com.lohika.javaclub.rxdata.reactive.publishers.SimplePublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import io.reactivex.schedulers.Schedulers;

/**
 * Receive exactly one element from publisher each throttle period.
 */
//@Component
public class ThrottleSubscriber {

  @Autowired
  private SimplePublisher publisher;

  @PostConstruct
  public void subscribe() {

    publisher
        .subscribeOn(Schedulers.newThread())
        .throttleFirst(5, TimeUnit.SECONDS)
        .subscribe(customer -> System.out.println("Subscriber 1 : " + customer));
  }


}
