package com.BankMngt.Service;

import java.util.List;

import com.BankMngt.Entity.Account;

public interface BankService {
   
	public Account createAccount(Account account);
	
	public List<Account> GetAllData();
	
	public Account GetById(Long account_No);
	
	public Account deposit(Long account_No, double amount);
	
	public Account withdraw(Long account_No, double amount);
	
	public String closeaccount(Long account_No);
}
