package com.zeecoder.kidsart.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class Student {

  private final UUID uuid;
  @NotBlank
  private final String firstName;
  @NotBlank
  private final String lastName;
  @NotBlank
  private final String email;
  @NotNull
  private final Gender gender;

  public Student(@JsonProperty("student_id") UUID uuid,
                 @JsonProperty("firstName") String firstName,
                 @JsonProperty("lastName") String lastName,
                 @JsonProperty("email") String email,
                 @JsonProperty("gender") Gender gender) {
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
