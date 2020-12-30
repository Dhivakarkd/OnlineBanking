package com.project.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.dao.BankingDao;
import com.project.model.Account;
import com.project.model.Customer;
import com.project.model.Transaction;
@Repository
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	BankingDao bankingdao;

	@Override
	public int save(Customer customer) {
		// TODO Auto-generated method stub
		return bankingdao.save(customer);
	}

	

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return bankingdao.getAllCustomers();
	}



	@Override
	public Customer getCustomerbyId(String id) {
		// TODO Auto-generated method stub
		return bankingdao.findCustomerbyId(id);
	}



	@Override
	public int savepin(String customerid, String pin) {
		// TODO Auto-generated method stub
		return bankingdao.savepin(customerid, pin);
	}



	@Override
	public String getpin(String customerid) {
		// TODO Auto-generated method stub
		return bankingdao.getpin(customerid);
	}



	@Override
	public List<Account> getCustomerAccounts(String customerId) {
		// TODO Auto-generated method stub
		return bankingdao.getCustomerAccounts(customerId);
	}



	@Override
	public List<Transaction> getTransaction(String accountNumber) {
		// TODO Auto-generated method stub
		return bankingdao.getTransaction(accountNumber);
	}



	@Override
	public int saveAccount(Account account) {
		// TODO Auto-generated method stub
		return bankingdao.saveAccount(account);
	}



	@Override
	public int saveTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return bankingdao.saveTransaction(transaction);
	}



	@Override
	public int getAccountBalance(String type, String accnumber) {
		// TODO Auto-generated method stub
		return bankingdao.getAccountBalance(type, accnumber);
	}
	
	
	
}