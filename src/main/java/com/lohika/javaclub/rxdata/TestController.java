package com.lohika.javaclub.rxdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

@RestController
public class TestController {

  @Autowired
  CustomerSubscriber customerSubscriber;

  @Autowired
  CustomerPublisher customerPublisher;


  @GetMapping(value = "/start")
  public String doStart() {
    Flowable.fromPublisher(customerPublisher)
        .subscribeOn(Schedulers.newThread())
        .subscribe(customerSubscriber);
    return "OK";
  }

  @GetMapping(value = "/stop")
  public String doStop() {
    customerPublisher.stop();
    return "OK";
  }

}
