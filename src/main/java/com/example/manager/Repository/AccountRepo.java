package com.example.manager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.manager.Model.Account;

public interface  AccountRepo extends JpaRepository<Account,Integer>{
    Account save(int acc);
}