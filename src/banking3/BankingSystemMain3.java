package banking3;

import java.util.InputMismatchException;
import bank.schema.ICustomDefine;

public class BankingSystemMain3 {

		//계좌정보 저장을 위한 인스턴스배열
		static Account3[] Account3s = new Account3[50];
		//개설된 계좌정보 카운트용 변수
		static int accCnt = 0;
		
		public static void ShowMenu() {
			System.out.println("-----MENU-----");
			System.out.println("1.계좌계설");
			System.out.println("2.입금");
			System.out.println("3.출금");
			System.out.println("4.전체계좌정보출력");
			System.out.println("5.프로그램종료");
		}
	public static void main(String[] args) {
		
		AccountManager3 manager = new AccountManager3();
		while(true) {
			//메뉴출력
			ShowMenu();
			System.out.println("메뉴입력:");
			try {
			int key = AccountManager3.scan.nextInt();
			AccountManager3.scan.nextLine();//버퍼에 남은 엔터키 제거
			if(key <1 || key > 5 ) {
				throw new MenuSelectException();
			}
			
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
				System.out.println("프로그램이종료되었습니다.");
				System.exit(0);
				break;
			
			}
		}
		catch (InputMismatchException e) {
			System.out.println("숫자만입력하세요.");
			AccountManager3.scan.nextLine();
			}
		catch (MenuSelectException e) {
			//getMessage는 에러메세지를 반환한다. -> "err"
			System.out.println(e.getMessage());
		}
		}
	}//main 끝
}//class끝