package com.BankMngt.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankMngt.Entity.Account;
import com.BankMngt.Repository.AccountRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BankServiceImp implements BankService{
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public List<Account> GetAllData() {
		return accountRepository.findAll();
	}

	@Override
	public Account GetById(Long account_No) {
		return accountRepository.findById(account_No)
				.orElseThrow(()->new EntityNotFoundException("Account not found with ID:" +account_No));
	}

	@Override
	public Account deposit(Long account_No, double amount) {
		Optional<Account> account = accountRepository.findById(account_No);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Account accountpresent = account.get();
		double totalamount = accountpresent.getAccount_No()+amount;
		accountpresent.setAmount(totalamount);
		return accountRepository.save(accountpresent);
	}

	@Override
	public Account withdraw(Long account_No, double amount) {
		Optional<Account> account = accountRepository.findById(account_No);
		if(account.isEmpty()) {
			throw new RuntimeException("amount is not present");
		}
		Account accountpresent = account.get();
		double totalamount = accountpresent.getAccount_No()-amount;
		accountpresent.setAmount(totalamount);
		return accountRepository.save(accountpresent);
	  
	}

	@Override
	public String closeaccount(Long account_No) {
		accountRepository.deleteById(account_No);
		return "Successfully delete account";
	}

}
