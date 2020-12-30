package com.project.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.Account;
import com.project.model.Customer;
import com.project.model.Otp;
import com.project.model.OtpPin;
import com.project.model.Transaction;
import com.project.service.CustomerService;

@Controller
@ComponentScan(basePackages = "com.project")

public class BankingController {

	@Autowired
	CustomerService customerservice;
	@Autowired
	Otp otp;

	@PostMapping("login")
	public String login(@RequestParam("id") String id, @RequestParam("password") String password, Model m) {
		Customer profile = customerservice.getCustomerbyId(id);
		String pin = customerservice.getpin(id);
		List<Account> acc = customerservice.getCustomerAccounts(id);
		System.out.println("pin is " + pin + "and the given pass is " + password);
		if (pin.equals(password)) {
			System.out.println("pin is correct");
			m.addAttribute("customer", profile);
			m.addAttribute("account", acc);
			return "customerDetails";
		}
		System.out.println(profile.toString() + "\n\n" + "The date is " + profile.getDob().toString());
		return "index";
	}

	@GetMapping("/")
	public Object String1(Model model) {

		return "index";
	}

	@RequestMapping(value = "/transactionDetails/{id}", method = RequestMethod.GET)
	public String showTransactions(@PathVariable String id, Model m) {

		List<Transaction> transactions = customerservice.getTransaction(id);
		Integer deposit =customerservice.getAccountBalance("D",id);
		Integer Withdrawal =customerservice.getAccountBalance("W",id);
		Integer balance=deposit-Withdrawal;
		System.out.println("Deposit = "+deposit+" WithDrawal "+Withdrawal);
	
		m.addAttribute("transaction", transactions);
		m.addAttribute("Balance", balance);
		return "transactionDetails";
	}


	  @GetMapping("register")
	  public Object String2 (Model model) {
	  model.addAttribute("customer", new Customer()); 
	  return "register"; }
	 

	@PostMapping("/registeruser")
	public String save(@Valid @ModelAttribute("customer") Customer customer, BindingResult res, Model m)
			throws DatabaseException {
		Random rand = new Random();
		String Customerid = "C" + rand.nextInt(100000);
		customer.setCustomerId(Customerid);
		if (res.hasErrors()) {
			return "register";
		}
		int count = customerservice.save(customer);
		String pin = OtpPin.OTP();



		int count1 = customerservice.savepin(customer.getCustomerId(), pin);

		Date date = new Date();

		String accNumber = "A" + rand.nextInt(100000);
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		Account acc = new Account(accNumber, customer.getCustomerId(), "B00009", 1000, dateFormat.format(date),
				"Saving", "Active");
		System.out.println(acc);
		String Tid = "T" + rand.nextInt(100000);
		Transaction trans=new Transaction(Tid, dateFormat.format(date), accNumber,"InitialDeposit", "Cash", "1000");
		int count2 = customerservice.saveAccount(acc);
		int count3=customerservice.saveTransaction(trans);
		if (count == 0 || count1 == 0 || count2 == 0 || count3 == 0) {
			throw new DatabaseException();
		}
		m.addAttribute("pin", pin);
		m.addAttribute("cusid", Customerid);
		return "registration_result";
	}

	@ExceptionHandler(DatabaseException.class)
	public String handleResourceNotFoundException() {

		return "error";
	}
}
/*
 * @RequestMapping(value = "/register", method = RequestMethod.POST) public
 * ModelAndView register(@RequestParam("customer id")String custId ,
 * 
 * @RequestParam("first name") String firstName,@RequestParam("middle name")
 * String middleName,
 * 
 * @RequestParam("last name")String lastName , @RequestParam("city")String
 * city,@RequestParam("number")String mobileNo,@RequestParam("occupation")String
 * occupation) { ModelAndView model= new ModelAndView("index");
 * model.addObject("message" , "registration successful!"); return model; }
 */
