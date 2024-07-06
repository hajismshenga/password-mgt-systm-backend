package com.example.manager.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.manager.Model.Account;
import com.example.manager.Service.AccountService;



@RestController
@CrossOrigin(origins = "http://localhost:3022")
@RequestMapping("/api/account")

public class AccountAPI {
  @Autowired
  private AccountService accountService;
  
  @GetMapping
  public ResponseEntity<List<Account>> getAllAccount()
  {
    List<Account> acc = accountService.getAllAccount();
    return new ResponseEntity<>(acc, HttpStatus.OK);
  }
  @PostMapping("/add")
  public ResponseEntity<Account> addAccount(@RequestBody Account acc)
  {
    Account savedAccount = accountService.addAccountById(acc);
    return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
  }

  @PostMapping("/bulk")
  public ResponseEntity<List<Account>> addAccount(@RequestBody List<Account> accounts) {
    List<Account> savedAccounts = accountService.addAccount(accounts);
    return new ResponseEntity<>(savedAccounts, HttpStatus.CREATED);
  }

  @GetMapping("/{Id}")
  public ResponseEntity<Account> getAcountById(@PathVariable("Id") int accId)
  {
    Account acc = accountService.getAccountById(accId);
    return new ResponseEntity<>(acc, HttpStatus.OK);
  }

  @DeleteMapping("/{Id}")
  public ResponseEntity<String> deleteAccount(@PathVariable("Id") int accId)
  {
    accountService.deleteAccount(accId);
    return new ResponseEntity<String>("account delete success", HttpStatus.OK);
  }

  @PutMapping("/{Id}")
  public ResponseEntity<Account> updateAccount(@PathVariable("Id") int accId, @RequestBody Account acc)
  {
    acc.setId(accId);
    Account accUpdate = accountService.updateAccount(acc);
    return new ResponseEntity<>(accUpdate, HttpStatus.CREATED);
  }

 }
 

  // @PostMapping("/add")
  //   public ResponseEntity<List<Account>> addAccounts(@RequestBody List<Account> accounts) {
  //       List<Account> savedAccounts = accountService.addAccount(acc);
  //       return new ResponseEntity<>(savedAccounts, HttpStatus.CREATED);
  //   }

  // @GetMapping("/{Id}")
  // public ResponseEntity<Account> getAcountById(@PathVariable("Id") int accId)
  // {
  //   Account acc = accountService.getAccountById(accId);
  //   return new ResponseEntity<>(acc, HttpStatus.OK);
  // }
