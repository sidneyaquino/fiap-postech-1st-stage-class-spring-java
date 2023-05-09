package com.fiap.postech.bank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.postech.bank.domain.Account;
import com.fiap.postech.bank.domain.AccountTransaction;
import com.fiap.postech.bank.domain.Customer;

@RestController
@RequestMapping("/account")
public class AccountController {

   // curl -i -X GET
   // "http://localhost:8080/account?number=1513026321&bank=111&branch=2222"
   @GetMapping
   public String getBalance(
         String bank,
         @RequestParam(name = "branch") String agency, // it's not same.
         String number) {

      return String.format("Bank: %s, Agency: %s, Number: %s", bank, agency, number);
   }

   // curl -i -X POST "http://localhost:8080/account"
   // -H "content-type:application/json"
   // -d '{"idNumber": 33, "name": "Sidney"}'
   @PostMapping
   public ResponseEntity<Account> open(@RequestBody Customer customer) {
      Account account = new Account("111", "222", "333");

      return ResponseEntity.status(HttpStatus.CREATED).body(account);
   }

   // curl -i -X DELETE "http://localhost:8080/account/111
   @DeleteMapping("/{id}")
   public String close(@PathVariable String id) {
      return "Conta fechada com sucesso - id: " + id;
   }

   // curl -i -X DELETE "http://localhost:8080/account"
   // -H "content-type:application/json"
   // -d '{"bank": "111", "agency": "2222", "number": "33333"}'
   @DeleteMapping
   public String close(@RequestBody Account account) {
      System.out.println(account.toString());

      return "Conta fechada com sucesso";
   }

   // curl -i -X PUT "http://localhost:8080/account"
   // -H "content-type:application/json"
   // -d '{"transaction": "CREDIT", "value": 3333.33,
   // "account": {"bank": "111", "agency": "2222", "number": "33333"}}'
   @PutMapping
   public ResponseEntity<AccountTransaction> transact(@RequestBody AccountTransaction transaction) {
      return ResponseEntity.ok(transaction);
   }
}