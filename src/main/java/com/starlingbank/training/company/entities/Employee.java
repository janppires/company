package com.starlingbank.training.company.entities;

import java.time.LocalDateTime;

public abstract class Employee {

  private final int employeeId;
  private final String name;
  private final String dateOfBirth;

  public Employee(int employeeId, String name, String dateOfBirth ) {

    this.employeeId = employeeId;
    this.name = name;
    this.dateOfBirth = dateOfBirth;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public String getName() {
    return name;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }


  @Override
  public String toString() {
    return "Employee{" +
        "employeeId=" + employeeId +
        ", name='" + name + '\'' +
        ", dateOfBirth=" + dateOfBirth +
        '}';
  }
}
