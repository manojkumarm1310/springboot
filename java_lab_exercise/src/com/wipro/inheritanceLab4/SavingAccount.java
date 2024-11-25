package com.wipro.inheritancelab4;

public class SavingAccount extends Account {
	private final double minimumBalance = 500;

    public SavingAccount(long accNum,double initialBalance, Person accHolder) {
        super(accNum,initialBalance, accHolder);
    }

    @Override
    public void withDraw(double amount) {
        if (amount > 0 && getBalance() - amount >= minimumBalance) {
            super.withDraw(amount);
        } else {
            System.out.println("Withdrawal denied. Minimum balance must be maintained.");
        }
    }
}