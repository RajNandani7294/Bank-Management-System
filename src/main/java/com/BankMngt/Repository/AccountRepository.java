package com.BankMngt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankMngt.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
