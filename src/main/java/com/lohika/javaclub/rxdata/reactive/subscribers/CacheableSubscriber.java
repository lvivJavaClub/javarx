package com.lohika.javaclub.rxdata.reactive.subscribers;

import com.lohika.javaclub.rxdata.domain.Customer;
import com.lohika.javaclub.rxdata.reactive.publishers.SimplePublisher;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Cacheable subscriber. Introduces cache on publisher thats allow all new subscribers receive few
 * past data from cache.
 */
//@Component
public class CacheableSubscriber {

  @Autowired
  private SimplePublisher publisher;

  @PostConstruct
  public void subscribe() {

    Observable<Customer> customerObservable = publisher
        .subscribeOn(Schedulers.newThread())
        .cacheWithInitialCapacity(100);

    customerObservable
        .take(200)
        .subscribe(customer -> System.out.println("Subscriber 1 : " + customer));

    customerObservable.subscribeOn(Schedulers.newThread())
        .take(200)
        .subscribe(customer -> System.out.println("Subscriber 2 : " + customer));
  }


}
