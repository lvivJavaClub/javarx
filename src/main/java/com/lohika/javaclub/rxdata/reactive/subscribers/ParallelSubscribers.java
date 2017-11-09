package com.lohika.javaclub.rxdata.reactive.subscribers;

import com.lohika.javaclub.rxdata.reactive.publishers.SimplePublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import io.reactivex.schedulers.Schedulers;

/**
 * Demonstrate behavior of few subscribers for same publisher.
 */
//@Component
public class ParallelSubscribers {

  @Autowired
  private SimplePublisher publisher;

  @PostConstruct
  public void subscribe() {

    publisher
        .subscribeOn(Schedulers.newThread())
        .subscribe(customer -> System.out.println(Thread.currentThread().getName() + " | Subscriber 1 : " + customer));

    publisher
        .subscribeOn(Schedulers.newThread())
        .subscribe(customer -> System.out.println(Thread.currentThread().getName() + " | Subscriber 2 : " + customer));
  }


}
