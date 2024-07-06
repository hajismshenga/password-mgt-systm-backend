package com.example.manager.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manager.Model.Account;
import com.example.manager.Repository.AccountRepo;

@Service
public class AccountService {

    
    @Autowired
    private AccountRepo accountRepo;

    public List<Account> getAllAccount() {
        return  accountRepo.findAll();
    }

    public Account addAccountById(Account acc){
        return accountRepo.save(acc);
    }

    // public List<Account> addAccount(List<Account> acc) {
    //     return accountRepo.saveAll(acc);
    // }

        public List<Account> addAccount(List<Account> accounts) {
        List<Account> savedAccounts = new ArrayList<>();
        for (Account account : accounts) {
            savedAccounts.add(accountRepo.save(account));
        }
        return savedAccounts;
    }

    public Account getAccountById(int accId){
        Optional<Account> optionalAccount = accountRepo.findById(accId);
        return optionalAccount.get();
    }

    public void deleteAccount(int accId){
        accountRepo.deleteById(accId);
    }
   
    public Account updateAccount(Account acc){
        Account existingAcc = accountRepo.findById(acc.getId()).get();
        existingAcc.setUsername(acc.getUsername());
        existingAcc.setPassword(acc.getPassword());
        existingAcc.setDescription(acc.getDescription());
        existingAcc.setUrl(acc.getUrl());
        Account updateAccount= accountRepo.save(existingAcc);
        return updateAccount;
    }

    
}
