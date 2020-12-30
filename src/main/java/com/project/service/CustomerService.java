package com.project.service;

import java.util.List;

import com.project.model.Account;
import com.project.model.Customer;
import com.project.model.Transaction;

public interface CustomerService {
	
		
		public int save(Customer customer);
		public List<Customer> getAllCustomers();
		public Customer getCustomerbyId(String id);
		public int savepin(String customerid,String pin);
		public String getpin(String customerid);
		public List<Account> getCustomerAccounts(String customerId);
		public List<Transaction> getTransaction(String accountNumber);
		public int saveAccount(Account account);
		public int saveTransaction(Transaction transaction);
		public int getAccountBalance(String type,String accnumber);
		

}