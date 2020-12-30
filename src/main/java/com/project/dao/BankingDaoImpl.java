package com.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import org.springframework.stereotype.Repository;

import com.project.model.Account;
import com.project.model.Customer;
import com.project.model.Transaction;


@Repository

public class BankingDaoImpl implements BankingDao{
    @Autowired
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Customer customer) {
		String sqlQuery ="INSERT INTO `store`.`customer`\r\n" + 
				"(`custid`,"+
				"`fname`,\r\n" + 
				"`mname`,\r\n" + 
				"`ltname`,\r\n" + 
				"`city`,\r\n" +
				"`mobileNo`,\r\n" + 
				"`occupation`,\r\n" + 
				"`dob`)\r\n" + 
				"VALUES('"+
				customer.getCustomerId()+"','" +
				customer.getFname()+"','"+
				customer.getMname() +"','"+
				customer.getLtname() +"','"+
				customer.getCity() +"','"+
				customer.getMobileno() +"','"+
				customer.getOccupation() +"','"+
				customer.getDob()+"')";
		
		return template.update(sqlQuery);		
				
	}

	
	

	@Override
	public List<Customer> getAllCustomers() {
		return template.query("select * from store.customer", new ResultSetExtractor<List<Customer>>() {

			public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Customer> list = new ArrayList<Customer>();
				while (rs.next()) {
					Customer c = new Customer();
					c.setCustomerId(rs.getString(1));
					c.setFname(rs.getString(2));
					c.setMname(rs.getString(3));
					c.setLtname(rs.getString(4));
					c.setCity(rs.getString(5));
					c.setMobileno(rs.getString(6));
					c.setOccupation(rs.getString(7));
					SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
					String a =f.format(rs.getDate(8));
					c.setDob(a);
					list.add(c);
				}
				return list;
	}
		});
	}

	@Override
	public Customer findCustomerbyId(String id) {
		// TODO Auto-generated method stub
		List<Customer> cus=template.query("select * from store.customer where `custid` = '"+id+"'", new ResultSetExtractor<List<Customer>>() {

			public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Customer> list = new ArrayList<Customer>();
				while (rs.next()) {
					Customer c = new Customer();
					c.setCustomerId(rs.getString(1));
					c.setFname(rs.getString(2));
					c.setMname(rs.getString(3));
					c.setLtname(rs.getString(4));
					c.setCity(rs.getString(5));
					c.setMobileno(rs.getString(6));
					c.setOccupation(rs.getString(7));
					SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
					String a =f.format(rs.getDate(8));
					c.setDob(a);
					list.add(c);
				}
				return list;
	}
		});
		
		return (Customer) cus.get(0);

	}

	@Override
	public int savepin(String customerid, String pin) {
		// TODO Auto-generated method stub
		
		String sqlQuery="INSERT INTO `store`.`pinlog`\r\n" + 
				"(`id`,\r\n" + 
				"`pin`)\r\n" + 
				"VALUES\r\n" + 
				"('"+customerid+"',"+ pin+");";
				
		return template.update(sqlQuery);
	}

	@Override
	public String getpin(String customerid) {
		// TODO Auto-generated method stub
	List<String> rpin=template.query("Select pin from store.pinlog where id = '"+customerid+"'",new ResultSetExtractor<List<String>>() {

		@Override
		public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			List<String> list=new ArrayList<>();
			while(rs.next()) {
				String pin=rs.getString("pin");
				list.add(pin);
			}
			return list;
		}
	});
		return rpin.get(0);
	}

	@Override
	public List<Account> getCustomerAccounts(String customerId) {
		// TODO Auto-generated method stub
		List<Account> accounts =template.query("SELECT * FROM store.account where custid = '"+customerId+"';",new ResultSetExtractor<List<Account>>() {

			@Override
			public List<Account> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<Account> acc=new ArrayList<>();
				while(rs.next()) {
					Account temp=new Account();
					temp.setAccountNumber(rs.getString("acnumber"));
					temp.setCustomerId(rs.getString("custid"));
					temp.setBranchId(rs.getString("bid"));
					temp.setOpeningBal(Integer.valueOf(rs.getString("opening_balance")));
					temp.setAccountStatus(rs.getString("astatus"));
					temp.setAccountType(rs.getString("atype"));
					temp.setActivationDate(rs.getString("aod"));
					acc.add(temp);
				}
				return acc;
			}
			
		});
		return accounts;
	}

	@Override
	public List<Transaction> getTransaction(String accountNumber) {
		// TODO Auto-generated method stub
		List<Transaction> transaction=template.query("SELECT * FROM store.trandetails where acnumber ='"+accountNumber+"';",
				new ResultSetExtractor<List<Transaction>>() {

					@Override
					public List<Transaction> extractData(ResultSet rs) throws SQLException, DataAccessException {
						// TODO Auto-generated method stub
						List<Transaction> trans=new ArrayList<>();
						
						while(rs.next()) {
							Transaction temp =new Transaction();
							temp.setAmount(rs.getString("transaction_amount"));
							temp.setId(rs.getString("tnumber"));
							temp.setDate(rs.getString("dot"));
							temp.setMediumofTrans(rs.getString("medium_of_transaction"));
							temp.setType(rs.getString("transaction_type"));
							trans.add(temp);
						}
						return trans;
					}
			
		});
		
		return transaction;
	}

	@Override
	public int saveAccount(Account account) {
		// TODO Auto-generated method stub
		String sqlQuery ="INSERT INTO `store`.`account`\r\n" + 
				"(`acnumber`,\r\n" + 
				"`custid`,\r\n" + 
				"`bid`,\r\n" + 
				"`opening_balance`,\r\n" + 
				"`aod`,\r\n" + 
				"`atype`,\r\n" + 
				"`astatus`)\r\n" + 
				"VALUES\r\n" + 
				"('"+account.getAccountNumber()+
				"',\r\n'" + account.getCustomerId()+
				"','" + account.getBranchId() +
				"',\r\n" + account.getOpeningBal()+
				",'\r\n" + account.getActivationDate()+
				"','\r\n" + account.getAccountType()+
				"','\r\n" + account.getAccountStatus()+
				"');";
		return template.update(sqlQuery);
	}

	@Override
	public int saveTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		String sqlQuery ="INSERT INTO `store`.`trandetails`\r\n" + 
				"(`tnumber`,\r\n" + 
				"`acnumber`,\r\n" + 
				"`dot`,\r\n" + 
				"`medium_of_transaction`,\r\n" + 
				"`transaction_type`,\r\n" + 
				"`transaction_amount`)\r\n" + 
				"VALUES\r\n" + 
				"('"+transaction.getId()
				+ "',\r\n'" + transaction.getAccNumber()+
				"','\r\n" + transaction.getDate()+
				"','\r\n" + transaction.getMediumofTrans()+
				"','\r\n" + transaction.getType()+
				"',\r\n" + transaction.getAmount()+
				");";
		return template.update(sqlQuery);
	}

	@Override
	public int getAccountBalance(String type, String accnumber) {
		// TODO Auto-generated method stub
		String sqlQuery="";
		if(type.equals("D")) {
		sqlQuery = "SELECT sum(transaction_amount)as Total from trandetails"
				+ " where `transaction_type` = 'Deposit'and `acnumber` = '"+accnumber+"';";
		}else {
		 sqlQuery = "SELECT sum(transaction_amount)as Total from trandetails"
					+ " where `transaction_type` = 'Withdrawal'and `acnumber` = '"+accnumber+"';";
		}
		
		Integer balance = template.query(sqlQuery,new ResultSetExtractor<Integer>(){

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Integer bal = 0;
				while(rs.next()) {
					bal=rs.getInt("Total");
				}
				return bal;
			}
			
		});
		
		return balance;
	}
	}
