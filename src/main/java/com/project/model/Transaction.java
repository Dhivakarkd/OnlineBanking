package com.project.model;

public class Transaction {
	
	private String id;
	private String date;
	private String accNumber;
	private String type;
	private String mediumofTrans;
	private String amount;
	
	public Transaction() {
		
	}
	public Transaction(String Tid, String date, String accNumber, String type, String mediumofTrans, String amount) {
	
		this.id = Tid;
		this.date = date;
		this.accNumber = accNumber;
		this.type = type;
		this.mediumofTrans = mediumofTrans;
		this.amount = amount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMediumofTrans() {
		return mediumofTrans;
	}
	public void setMediumofTrans(String mediumofTrans) {
		this.mediumofTrans = mediumofTrans;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "transaction [id=" + id + ", date=" + date + ", type=" + type + ", mediumofTrans=" + mediumofTrans
				+ ", amount=" + amount + "]";
	}
	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	
	
}
