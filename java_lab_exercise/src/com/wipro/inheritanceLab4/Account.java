package com.wipro.inheritancelab4;

public class Account {
	private Long accNum;
	private Double balance;
	private Person accHolder;
	public Account(long accNum, double balance, Person accHolder) {
		super();
		this.accNum = accNum;
		this.balance = balance;
		this.accHolder = accHolder;
	}
	public Account() {
		
	}
	public Long getAccNum() {
		return accNum;
	}
	public void setAccNum(Long accNum) {
		this.accNum = accNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Person getAccHolder() {
		return accHolder;
	}
	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}
	
	public void deposit(Double depAmt) {
		if(depAmt>0) {
			this.balance+=depAmt;
	}
	}
	public void withDraw(double wdAmt) {
		if(wdAmt>0 && this.balance-wdAmt>=500) {
			this.balance-=wdAmt;
		}
	}
	
}