package com.starlingbank.training.company.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

// these are my DTOs because they are meant to be used to transfer data
public class EmployeeRequest {
  private final String name;
  private final String dateOfBirth;
  private final String employeeType;
  private final SalaryRequest salary;

  public EmployeeRequest(
      @JsonProperty("name") String name,
      @JsonProperty("dateOfBirth") String dateOfBirth,
      @JsonProperty("employeeType") String employeeType,
      @JsonProperty("salary") SalaryRequest salary
  ) {
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.employeeType = employeeType;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public String getEmployeeType() {
    return employeeType;
  }

  public SalaryRequest getSalary() {
    return salary;
  }
}
