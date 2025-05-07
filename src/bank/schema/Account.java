package bank.schema;

public class Account {
	//계좌번호(String형), 이름(String형), 잔액(int형)
	private String accNum;
	private String name;
	private int balance;
	//생성자
	
	public Account(String accNum, String name, int balance) {
		super();
		this.accNum = accNum;
		this.name = name;
		this.balance = balance;
	}
	
	/**
	 * @return the accNum
	 */
	public String getAccNum() {
		return accNum;
	}
	/**
	 * @param accNum the accNum to set
	 */
	public void setAccNum(String accNum) {
		this.accNum = accNum;
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
	//toString 오버라이딩

	@Override
	public String toString() {
		return "Account [계좌번호=" + accNum + ", 이름=" + name + ", 잔고=" + balance + "]";
	}

	
	
}
