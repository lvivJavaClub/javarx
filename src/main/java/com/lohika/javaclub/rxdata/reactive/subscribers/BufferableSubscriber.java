package com.lohika.javaclub.rxdata.reactive.subscribers;

import com.lohika.javaclub.rxdata.reactive.publishers.SimplePublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import io.reactivex.schedulers.Schedulers;

/**
 * Bufferable subscriber. Subscribes to publisher and introduce buffer. When buffer capacity
 * reached then data will be processed by butch.
 *
 * Buffer can be introduced by capacity or time wait.
 */
//@Component
public class BufferableSubscriber {

  @Autowired
  private SimplePublisher publisher;

  @PostConstruct
  public void subscribe() {

    publisher
        .subscribeOn(Schedulers.newThread())
        .buffer(1000)
        //.buffer(5, TimeUnit.SECONDS)
        .subscribe(customer -> System.out.println("Subscriber 1 : " + customer));
  }


}
