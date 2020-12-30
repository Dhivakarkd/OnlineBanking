package com.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.project.model.*;
@Repository
@Component
public class OtpPinImpl implements Otp{
Customer customer = new Customer();

	@Autowired
	JdbcTemplate template;
	

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
		OtpPin otp;
	@Override
	public int saveOtp(String custid,String o) {
		// TODO Auto-generated method stub
		System.out.println("abc");
		String sql = "insert into otppin(custid,otppin) values('" + customer.getCustomerId() +"'," + otp.OTP() + "')";
		System.out.println(sql);
		return template.update(sql);
	}


}
