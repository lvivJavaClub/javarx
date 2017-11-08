package com.lohika.javaclub.rxdata.reactive.subscribers;

import com.lohika.javaclub.rxdata.reactive.publishers.SimplePublisher;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

import io.reactivex.schedulers.Schedulers;

/**
 * Simple subscriber that subscribes to publisher and read data
 */
//@Component
public class SimpleSubscriber {

  @Autowired
  private SimplePublisher publisher;

  @PostConstruct
  public void subscribe() {

    publisher
        .subscribeOn(Schedulers.newThread())
        .subscribe(customer -> System.out.println("Subscriber 1 : " + customer));

    //System.out.println("Wait me here !!!");
  }


}
