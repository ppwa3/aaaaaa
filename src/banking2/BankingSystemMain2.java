package banking2;

import java.util.Scanner;

import bank.schema.ICustomDefine;

public class BankingSystemMain2 {

		//계좌정보 저장을 위한 인스턴스배열
		static Account2[] Account2s = new Account2[50];
		//개설된 계좌정보 카운트용 변수
		static int accCnt = 0;
		
		public static void ShowMenu() {
			System.out.println("1.계좌계설");
			System.out.println("2.입금");
			System.out.println("3.출금");
			System.out.println("4.전체계좌정보출력");
			System.out.println("5.프로그램종료");
		}
	public static void main(String[] args) {
		
		AccountManager2 manager = new AccountManager2();
		while(true) {
			//메뉴출력
			ShowMenu();
			System.out.println("메뉴입력:");
			int key = AccountManager2.scan.nextInt();
			AccountManager2.scan.nextLine();//버퍼에 남은 엔터키 제거
			
			switch (key) {
			case ICustomDefine.MAKE:
				//계좌개설
				System.out.println("계좌개설");
				manager.makeAccount();
				break;
			case ICustomDefine.DEPOSIT:
				//입금
				System.out.println("입금");
				manager.depositMoney();
				break;
			case ICustomDefine.WITHDRAW:
				//출금
				System.out.println("출금");
				manager.withdrawMoney();
				break;
			case ICustomDefine.INQUIRE:
				//계좌정보출력
				System.out.println("계좌정보출력");
				manager.showAccInfo();
				break;
			case ICustomDefine.EXIT:
				//프로그램 종료
				System.exit(0);
				break;
			default :
				
				break;
			}//switch 끝
		}//while 끝
	}//main 끝
}//class끝