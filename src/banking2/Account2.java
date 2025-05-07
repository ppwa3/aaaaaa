package banking2;

import java.util.Scanner;

//계좌정보를 표현할 수 있는 Account라는 클래스 정의
public class Account2 {
	
	 Account2[] account;
	 int numOfaccount;
	
	//계좌번호(String형), 이름(String형), 잔액(int형)
	 private String accountNum;
	 private String name;
	 private int balance;
	//생성자 
	public Account2(String accountNum, String name, int balance) {
		
		this.accountNum = accountNum;
		this.name = name;
		this.balance = balance;
		
	}
	@Override
	public String toString() {
		return "[계좌번호=" + accountNum + ", 이름=" 
					+ name + ", 잔고=" + balance;
	}
	
	public void showInfo() {
		
	}
	
	public int countMoney(int money) {
		return balance;
	}
	
	public int deposit() {
		return balance;
	}
	
	public String getAccountNum() {
		return accountNum;
	}
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

}                              