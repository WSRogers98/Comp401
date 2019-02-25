//Name:		William Rogers		
//Onyen:			730149662
//Recitation Code: 63214	
// I can't read anything on this board so this code will be iffy
// I also don't know how to do any f this
package bank;

public class BankAccount {
	
	double myBalance;
	boolean isPinActive;
	String myPin;

	// You cannot have a negative balance
	// You cannot deposit or withdraw negative money
	// If you try to withdraw more than you have, it fails
	// A pin is set to off by default
	
	// Users can set an optional 4 letter pin, and if the amount
	//   they want to withdraw is over 500 dollars, they
	//   must enter that pin
	// You are able to change your pin
	// Each method will return true if it succeeds and false if it
	//   fails

	public BankAccount() {
		myBalance = 0;
		isPinActive = false;
	}

	// this method returns your current balance
	public double currentBalance() {
		return myBalance;
	}

	// this method deposits money into the bank account
	public boolean depositMoney(double moneyToAdd) {
		if(moneyToAdd > 0)
		myBalance = moneyToAdd;
		return true;
	}

	// this method withdraws money from your account
	public boolean withdrawMoney(double moneyToWithdraw) {
		//i zoned out so i did this differently
		if(moneyToWithdraw > 0 && moneyToWithdraw < this.currentBalance())
		myBalance = myBalance - moneyToWithdraw;
		return true;
	}
	
	
	// these following methods use a pin
	// this method turns on your pin
	public boolean setPin(String myPin) {
		this.myPin = myPin;
		return true;
	}

	// returns status of pin
	public boolean isPinActive() {
		return isPinActive;
	}

	// this method does same as deposit but requires pin
	public boolean withdrawMoney(double moneyToWithdraw, String enteredPin) {
		if (isPinActive()) {
			depositMoney(500);
		}
		return true;
	}
}
