package com.wipro.Lab4;

import com.wipro.inheritancelab4.CurrentAccount;
import com.wipro.inheritancelab4.Person;
import com.wipro.inheritancelab4.SavingAccount;

public class Lab4 {

	public static void main(String[] args) {
		Person smith = new Person("Smith", 30);
        Person kathy = new Person("Kathy", 25);
        
        SavingAccount smithAccount = new SavingAccount(12345678,2000, smith);
        CurrentAccount kathyAccount = new CurrentAccount(87654321,3000, kathy);
        smithAccount.deposit(2000.0);
        kathyAccount.withDraw(2000);
        
        System.out.println(smith.getName() + "'s updated balance: " + smithAccount.getBalance());
        System.out.println(kathy.getName() + "'s updated balance: " + kathyAccount.getBalance());

	}

}