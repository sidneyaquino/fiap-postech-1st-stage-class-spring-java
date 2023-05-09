package com.fiap.postech.bank.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {

   @JsonProperty
   private String bank;

   @JsonProperty
   private String agency;

   @JsonProperty
   private String number;

   public Account(String bank, String agency, String number) {
      this.bank = bank;
      this.agency = agency;
      this.number = number;
   }

   @Override
   public String toString() {
      return "Account [bank=" + bank + ", agency=" + agency + ", number=" + number + "]";
   }
}
