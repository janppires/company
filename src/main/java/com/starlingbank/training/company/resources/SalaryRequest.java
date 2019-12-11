package com.starlingbank.training.company.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SalaryRequest {
  private final double amount;
  private final String currency;

  public SalaryRequest(
      @JsonProperty("amount") double amount,
      @JsonProperty("currency") String currency
  ) {
    this.amount = amount;
    this.currency = currency;
  }

  public double getAmount() {
    return amount;
  }

  public String getCurrency() {
    return currency;
  }
}
