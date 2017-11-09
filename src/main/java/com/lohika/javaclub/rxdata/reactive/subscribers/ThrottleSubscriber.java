package com.lohika.javaclub.rxdata.reactive.subscribers;

import com.lohika.javaclub.rxdata.reactive.publishers.SimplePublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import io.reactivex.Observable;
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


    Observable<Long> intPab = Observable.interval(1, TimeUnit.MILLISECONDS);

    intPab
        .subscribeOn(Schedulers.newThread())
        .throttleLast(5, TimeUnit.SECONDS)
        .subscribe(customer -> System.out.println("Number : " + customer));
  }


}
