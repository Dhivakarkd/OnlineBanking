package com.project.model;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
public class Customer {

	
	public String getLtname() {
		return ltname;
	}
	public void setLtname(String ltname) {
		this.ltname = ltname;
	}
	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	private String customerId;
	
	
	
	private String mname;
	private String ltname;
	@NotBlank( message = "Username cannot be Empty")
	private String fname;
	@NotBlank(message = "City cannot be null")
	private String city;
	
	@NotBlank(message = "Mobile number cannot be Empty")
	private String mobileno;
	
	@NotBlank(message = "Occupation cannot be Empty")
	private String occupation;
	
	@NotBlank(message = "Dob cannot be Empty")
	private String dob;

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fname=" + fname + ", mname=" + mname + ", ltname=" + ltname
				+ ", city=" + city + ", mobileno=" + mobileno + ", occupation=" + occupation + ", dob=" + dob + "]";
	}
	
	
	
}