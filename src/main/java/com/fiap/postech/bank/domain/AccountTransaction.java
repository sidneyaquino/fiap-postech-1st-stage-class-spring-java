package com.fiap.postech.bank.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountTransaction {

   @JsonProperty
   private Account account;
   
   @JsonProperty
   private BigDecimal value;
   
   @JsonProperty
   private Transaction transaction;
}
