package banking4;

import java.util.Scanner;

//계좌정보를 표현할 수 있는 Account라는 클래스 정의
public abstract class Account4 {
	//계좌번호(String형), 이름(String형), 잔액(int형)
	 private String accountNum;
	 private String name;
	 int balance;
	//생성자 
	public Account4(String accountNum, String name, int balance) {
		//초기화 
		this.accountNum = accountNum;
		this.name = name;
		this.balance = balance;
	}
		
	@Override	
	public String toString() {
		return "[계좌번호=" + accountNum + ", 이름=" 
					+ name + ", 잔고=" + balance;
	}
	
	public abstract void showInfo();
		
	
	
	public abstract void plusMoney(int money);
	
	// Getter & Setter
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
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Account4 account = (Account4) obj;
	    return this.getAccountNum().equals(account.getAccountNum());
	}

	@Override
	public int hashCode() {
	    return this.getAccountNum().hashCode();
	}
}