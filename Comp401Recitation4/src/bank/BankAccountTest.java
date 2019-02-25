package bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankAccountTest {

	@Test
	void test() {
		BankAccount account = new BankAccount();
		assertEquals(0, account.currentBalance());
		assertEquals(false, account.isPinActive());
	}
//	@Test
//void test2() {
//		
//	}
	@Test
	void depositTest() {
		BankAccount account = new BankAccount();
		account.depositMoney(1000);
		assertEquals(1000, account.currentBalance());
		
	}
	@Test
	void withdrawTest() {
		BankAccount account = new BankAccount();
		account.depositMoney(1000);
		account.withdrawMoney(500);
	assertEquals(500, account.currentBalance());
	}
	@Test
	void negativeTest() {
		BankAccount account = new BankAccount();
		account.depositMoney(-100);
		assertFalse(account.depositMoney(-100));
	}
	@Test
	void negativeTest2() {
		BankAccount account = new BankAccount();
		account.withdrawMoney(-100);
		assertFalse(account.withdrawMoney(-100));
	}
	@Test
	void tooMuchTest() {
		BankAccount account = new BankAccount();
	account.depositMoney(100);
	account.withdrawMoney(200);
	assertFalse(account.withdrawMoney(200));
	}
	// this is as far as I got RIP
	@Test
	void pinlongTest() {
		BankAccount account = new BankAccount();
		account.setPin("12345");
		
		
	}
	void pinshortTest() {
		BankAccount account = new BankAccount();
		account.setPin("123");
		
		
	}
}
