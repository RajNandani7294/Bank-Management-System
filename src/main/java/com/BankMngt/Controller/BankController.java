package com.BankMngt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankMngt.Entity.Account;
import com.BankMngt.Service.BankService;

@RestController
@RequestMapping("Api")
public class BankController {
	
	@Autowired
	 BankService  bankService;
  
	@PostMapping("create")
	public ResponseEntity<Account>createbank(@RequestBody Account account){
		 return ResponseEntity.ok(bankService.createAccount(account));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Account>> GetAllData(){
		return ResponseEntity.ok(bankService.GetAllData());
	}
	
	@GetMapping("/{account_no}")
	public ResponseEntity<Account> GetById(@PathVariable Long account_No){
		return ResponseEntity.ok(bankService.GetById(account_No));
	}
	
	@PutMapping("/deposite/{account_no}/{amount}")
	public ResponseEntity<Account>deposite(@PathVariable Long account_No, @PathVariable double amount){
		return ResponseEntity.ok(bankService.deposit(account_No, amount));
	}
	
	@PutMapping("/withdraw/{account_no}/{amount}")
	public ResponseEntity<Account> withdraw(@PathVariable Long account_No, @PathVariable double amount){
		return ResponseEntity.ok(bankService.withdraw(account_No, amount));
	}
	
	@DeleteMapping("/{account_no}")
	public ResponseEntity<?> deleteaccount(@PathVariable Long account_No) {
		return ResponseEntity.ok(bankService.closeaccount(account_No));
	}
}
