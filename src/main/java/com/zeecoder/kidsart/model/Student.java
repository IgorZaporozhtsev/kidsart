package com.zeecoder.kidsart.model;

import java.util.UUID;

public class Student {
  private final UUID uuid;
  private final String firstName;
  private final String lastName;
  private final String email;
  private final Gender gender;

  public Student(UUID uuid, String firstName, String lastName, String email, Gender gender) {
    this.uuid = uuid;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.gender = gender;
  }

  public UUID getUuid() {
    return uuid;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public Gender getGender() {
    return gender;
  }

  public enum Gender{
    MALE, FEMALE
  }
}
