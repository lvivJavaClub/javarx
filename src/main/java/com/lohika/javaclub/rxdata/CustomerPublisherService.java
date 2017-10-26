package com.lohika.javaclub.rxdata;


import org.springframework.stereotype.Service;

import io.reactivex.subjects.PublishSubject;

@Service
public class CustomerPublisherService {

    private PublishSubject<Customer> publishSubject = PublishSubject.create();

    {
        publishSubject
                .filter(customer -> customer.name.length() > 5)
                .subscribe((customer) -> {
//                    Thread.sleep(5000);
                            System.out.print(Thread.currentThread().getName());
                            System.out.println("Names are more :: >5" + customer);
                        }
                );
        publishSubject
                .filter(customer -> customer.name.length() <= 5)
                .subscribe(customer -> {
                    System.err.print(Thread.currentThread().getName());
                    System.err.println("Names are less :: <=5" + customer);

                });
    }

    public void call(Customer customer) {
        publishSubject.onNext(customer);
    }

}