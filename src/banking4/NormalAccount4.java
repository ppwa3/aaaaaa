package banking4;

import java.util.HashSet;
import java.util.Set;

public class NormalAccount4 extends Account4 {

	int interest;

	public NormalAccount4(String accountNum, String name, int balance, int interest) {
		super(accountNum, name, balance);// 부모클래스 초기화
		this.interest = interest;// 자식클래스 필드 초기화
	}

	@Override
	public void showInfo() {
		System.out.println("계좌번호: " + getAccountNum());
		//System.out.printf("계좌번호: %s",getAccountNum());
		System.out.println("고객이름: " + getName());
		System.out.println("잔액: " + getBalance());
		System.out.println("이자율: " + interest + "%");

	}
	
	Set<Account4> accountSet = new HashSet<>();
	Account4 acc2 = new NormalAccount4(getAccountNum(),
			getName(), getBalance(), interest());
	
	@Override
	public String toString() {
		return "NormalAccount4" + super.toString() + ", 이자=" + interest + "]";
	}

	private int interest() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void plusMoney(int money) {
		double totalBalance = getBalance() + (getBalance() * interest / 100) + money;
		System.out.println("일반계좌:" + totalBalance + "원");
		int newB = (int) totalBalance;
		setBalance(newB);
	}

}
