package com.lohika.javaclub.rxdata.reactive.subscribers;

import com.lohika.javaclub.rxdata.reactive.publishers.SimplePublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import io.reactivex.schedulers.Schedulers;

/**
 * Split publisher data to smaller publishers (observables) according to window capacity.
 */
//@Component
public class WindowSubscriber {

  @Autowired
  private SimplePublisher publisher;

  @PostConstruct
  public void subscribe() {

    publisher
        .subscribeOn(Schedulers.newThread())
        //.take(100)
        .window(10)
        .subscribe(window -> window
            .subscribeOn(Schedulers.newThread())
            .subscribe(customer ->
                System.out.println(Thread.currentThread().getName() + " | Customer : " + customer)));
  }


}
