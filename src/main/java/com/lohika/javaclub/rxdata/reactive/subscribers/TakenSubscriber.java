package com.lohika.javaclub.rxdata.reactive.subscribers;

import com.lohika.javaclub.rxdata.reactive.publishers.SimplePublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import io.reactivex.schedulers.Schedulers;

/**
 * Retrieve exact amount of data from publisher.
 */
//@Component
public class TakenSubscriber {

  @Autowired
  private SimplePublisher publisher;

  @PostConstruct
  public void subscribe() {

    publisher
        .subscribeOn(Schedulers.newThread())
        .take(10)
        //.take(10, TimeUnit.SECONDS)
        .subscribe(customer -> System.out.println("Subscriber 1 : " + customer));
  }


}
