package banking;

import java.util.Scanner;


import bank.schema.Account;
import bank.schema.ICustomDefine;

public class BankingSystemMain {

		//키보드 입력을 위한 인스턴스
		static Scanner scan = new Scanner(System.in);
		//계좌정보 저장을 위한 인스턴스배열
		static Account[] accountArray = new Account[50];
		//개설된 계좌정보 카운트용 변수
		static int count = 0;
		
		public static void ShowMenu() {
			System.out.println("1.계좌계설");
			System.out.println("2.입금");
			System.out.println("3.출금");
			System.out.println("4.전체계좌정보출력");
			System.out.println("5.프로그램종료");
		}
		
		// 계좌개설을 위한 함수
		public static void makeAccount() {
			System.out.print("계좌번호:");
			String accNum = scan.nextLine();
			System.out.print("이름:");
			String name = scan.nextLine();
			System.out.print("잔고:");
			int balance = scan.nextInt();
			
			//신규계좌 생성 및 추가
			Account newAccount = new Account(accNum, name, balance);
			accountArray[count] = newAccount;
			count++;
			System.out.println("신규계좌 개설 완료");
		} 
		
		
		//입금
		public static void depositMoney() {
			System.out.print("계좌번호:");
			//입력
			String searchAccNum = scan.nextLine();
			for(int i=0 ; i<count ; i++) {
				//accValidNum = 입력한 계좌번호 찾아서 계좌번호로 저장.
				if (accountArray[i].getAccNum().equals(searchAccNum) == true) {
					//찾은 계좌가 있을때 실행할 것들
					//내 계좌 잔액
					int balance = accountArray[i].getBalance();
					System.out.println("내 계좌 잔액: "+ balance);
					
					System.out.print("입금액:");
					int plusMoney = scan.nextInt();
					balance = balance + plusMoney;
					accountArray[i].setBalance(balance);
					
					System.out.println("내 계좌 잔액: "+ balance);
				} else {
					//찾은 계좌가 없을때 실행할 것들
					System.out.println("동수형 짱");
				}
				
			} 
		}

		//출금
		public static void withdrawMoney() {
			System.out.print("계좌번호:");
			String searchAccNum = scan.nextLine();
			for(int i=0 ; i<count ; i++) {
				if (accountArray[i].getAccNum().equals(searchAccNum) == true) {
					System.out.println("출금함");
					int balance = accountArray[i].getBalance();
					System.out.println("내 계좌 잔액: "+ balance);
					System.out.println("얼마출금?");
					int Money = scan.nextInt();
					balance = balance - Money;
					accountArray[i].setBalance(balance);
					
					System.out.println("출금후금액: "+ balance);
				}
			}
		} 
		//전체계좌정보출력
		public static void showAccInfo() {
			System.out.println("전체계좌정보출력:");
			for(int i=0 ; i<count ; i++) {
			//String accNum = accountArray[i].getAccNum();
				//toString을 오버라이딩 했으므로 인스턴스 그대로 출력
			System.out.println(accountArray[i]);
			System.out.println("**전체계좌정보가 출력됨**");
				}
		} 
	
	public static void main(String[] args) {
		
		while(true) {
			//메뉴출력
			ShowMenu();
			System.out.println("메뉴입력:");
			int key = scan.nextInt();
			scan.nextLine();//버퍼에 남은 엔터키 제거
			
			switch (key) {
			case ICustomDefine.MAKE:
				//계좌개설
				System.out.println("계좌개설");
				makeAccount();
				break;
			case ICustomDefine.DEPOSIT:
				//입금
				System.out.println("입금");
				depositMoney();
				break;
			case ICustomDefine.WITHDRAW:
				//출금
				System.out.println("출금");
				withdrawMoney();
				break;
			case ICustomDefine.INQUIRE:
				//계좌정보출력
				System.out.println("계좌정보출력");
				showAccInfo();
				break;
			case ICustomDefine.EXIT:
				//프로그램 종료
				System.exit(0);
				break;
			}//switch 끝
		}//while 끝
	}//main 끝
}//class끝