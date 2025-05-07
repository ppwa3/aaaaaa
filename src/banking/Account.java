package banking;

import java.util.Scanner;

//계좌정보를 표현할 수 있는 Account라는 클래스 정의
public class Account {
	//계좌번호(String형), 이름(String형), 잔액(int형)
	private String accountNum;
	private String name;
	private int balance;
	//생성자 
	public Account(String accountNum, String name, int balance) {
		super();
		this.accountNum = accountNum;
		this.name = name;
		this.balance = balance;
	}
	//getter/setter
	/**
	 * @return the accountNum
	 */
	public String getAccNum() {
		return accountNum;
	}
	/**
	 * @param accountNum the accountNum to set
	 */
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [계좌번호=" + accountNum + ", 이름=" + name + ", 잔고=" + balance + "]";
	}
	public void deposit(Account[] accounts) {
	}
}                              