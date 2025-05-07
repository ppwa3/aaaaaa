package banking;

import java.util.Scanner;

import bank.schema.ICustomDefine;

public class AccountManager {
	
	//키보드 입력을 위한 인스턴스
	static Scanner scan = new Scanner(System.in);
	//계좌정보 저장을 위한 인스턴스배열
	static Account[] accounts = new Account[50];
	//개설된 계좌정보 카운트용 변수
	static int accCnt = 0;
	
	public static void showMenu() {
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.프로그램종료");
	}
	
	//계좌개설을 위한 함수
	public static void makeAccount() {
		System.out.print("계좌번호:");
		String a = scan.nextLine();
		System.out.println("이름:");
		String n = scan.nextLine();
		System.out.println("잔고:");
		int b = scan.nextInt();
		
		//신규계좌 생성 및 추가
		Account ac = new Account(a, n, b);
		accounts[accCnt++] = ac;
		System.out.println("신규계좌 개설 완료");
	}
	//입금
	public static void depositMoney() {
		System.out.println("입금할 계좌번호를 입력하세요:");
		String acNum = BankingSystemMain.scan.nextLine();
		
//		for(int i=0 ; i<accCnt ; i++) {
//			if (accounts[i].setAccountNum().equals(acNum)) {
//			accounts[i].deposit(a);
//			System.out.println("입금완료");
//			found = true;
//			break;
//			}
	}
	public static void withdrawMoney() {
	}
	public static void showAccInfo() {
		for(int i=0 ; i<accCnt ; i++) {
			System.out.println(accounts[i]);
		}
		System.out.println("**전체계좌정보가 출력됨**");
	}
	
	public static void main(String[] args) {
		
		while(true) {
			//메뉴출력
			showMenu();
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
	}//class 끝
	// 계좌개설을 위한 함수
//		public static void main(String[] args) {
//			AccountInfoHandler handler = new AccountInfoHandler(50);
//			
//			while(true) {
//				showMenu();
//				int choice = scan.nextInt();
//				scan.nextLine();
//				switch(choice) {
//				case 1: 
//					handler.makeAccount(choice);
//					break;
//				case 2:
//					handler.depositMoney(choice);
//					break;
//				case 3:
//					handler.withdrawMoney(choice);
//					break;
//				case 4:
//					handler.showAccInfo(choice);
//					break;
//				case 5:
//					System.out.println("프로그램종료");
//					return;
//			}
//		}
//	}

