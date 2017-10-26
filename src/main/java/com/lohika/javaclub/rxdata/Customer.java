package com.lohika.javaclub.rxdata;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    String name;
    String surName;
    String street;
}