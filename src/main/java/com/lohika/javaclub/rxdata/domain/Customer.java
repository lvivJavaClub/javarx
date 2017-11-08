package com.lohika.javaclub.rxdata.domain;

public class Customer {
  private String name;
  private String surName;
  private String street;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurName() {
    return surName;
  }

  public void setSurName(String surName) {
    this.surName = surName;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  @Override
  public String toString() {
    return getName() + ", " + getSurName() + ", " + getStreet();
  }
}
