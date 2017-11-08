package com.lohika.javaclub.rxdata.reactive.subscribers;

import com.lohika.javaclub.rxdata.reactive.publishers.ErrorPublisher;
import com.lohika.javaclub.rxdata.reactive.publishers.SimplePublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import io.reactivex.schedulers.Schedulers;

/**
 * Simple subscriber that subscribes to publisher and read data
 */
@Component
public class RecoverableSubscriber {

  @Autowired
  private SimplePublisher publisher;

  @Autowired
  private ErrorPublisher errorPublisher;

  @PostConstruct
  public void subscribe() {

    errorPublisher
        .subscribeOn(Schedulers.newThread())
        .onErrorResumeNext(publisher)
        .take(200)
        .subscribe(customer -> System.out.println("Subscriber 1 : " + customer));
  }


}
