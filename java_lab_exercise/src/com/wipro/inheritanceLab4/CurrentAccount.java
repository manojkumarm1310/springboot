package com.wipro.inheritancelab4;

public class CurrentAccount extends Account {

    private double overdraftLimit = 1000;



    public CurrentAccount(long accNum,double initialBalance, Person accHolder) {

        super(accNum,initialBalance, accHolder);

    }



    @Override

    public void withDraw(double amount) {

        if (amount > 0 && getBalance() - amount >= -overdraftLimit) {

            super.withDraw(amount);

        } else {

            System.out.println("Withdrawal denied. Overdraft limit exceeded.");

        }

    }

}