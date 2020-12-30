package com.project.model;

public class Account {
	
	private String accountNumber;
	private String customerId;
	private String branchId;
	private int openingBal;
	private String activationDate;
	private String accountType;
	private String accountStatus;
	
	
	public Account(String accountNumber, String customerId, String branchId, int openingBal, String activationDate,
			String accountType, String accountStatus) {
	
		this.accountNumber = accountNumber;
		this.customerId = customerId;
		this.branchId = branchId;
		this.openingBal = openingBal;
		this.activationDate = activationDate;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
	}
	
	public Account() {
		
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public int getOpeningBal() {
		return openingBal;
	}
	public void setOpeningBal(int openingBal) {
		this.openingBal = openingBal;
	}
	public String getActivationDate() {
		return activationDate;
	}
	public void setActivationDate(String activationDate) {
		this.activationDate = activationDate;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customerId=" + customerId + ", branchId=" + branchId
				+ ", openingBal=" + openingBal + ", activationDate=" + activationDate + ", accountType=" + accountType
				+ ", accountStatus=" + accountStatus + "]";
	}
	
	
	
}
