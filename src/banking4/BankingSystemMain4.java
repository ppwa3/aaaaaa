package banking4;

import java.util.InputMismatchException;
import banking.ICustomDefine;
import banking3.MenuSelectException;

public class BankingSystemMain4 {
		
		public static void ShowMenu() {
			System.out.println("-----MENU-----");
			System.out.println("1.계좌계설");
			System.out.println("2.입금");
			System.out.println("3.출금");
			System.out.println("4.전체계좌정보출력");
			System.out.println("5.계좌정보삭제");
			System.out.println("6.프로그램종료");
		}
	public static void main(String[] args) {
		
		//AccountManager4 -> 타입 manager -> 인스턴스
		//클래스 타입으로 만든 변수를 인스턴스라 한다.
		AccountManager4 manager = new AccountManager4();
		//변수를 만드는 것
		//int : 변수타입 a : 변수이름 3 : 3을 a라는 변수안에 넣는다.
		int a = 3;
		while(true) {
			//메뉴출력
			ShowMenu();
			System.out.println("메뉴입력:");
			try {
			int key = AccountManager4.scan.nextInt();
			AccountManager4.scan.nextLine();//버퍼에 남은 엔터키 제거
			if(key <1 || 4 < key ) {
				throw new MenuSelectException();
			}
			
			switch (key) {
			case ICustomDefine.MAKE:
				//계좌개설
				System.out.println("계좌개설");
				//manager에서 makeAccount메서드를 실행시키겠다.
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
			case ICustomDefine.DELETE:
				//계좌정보출력
				System.out.println("계좌정보삭제");
				manager.showAccInfo();
				break;
			case ICustomDefine.EXIT:
				//프로그램 종료
				System.exit(0);
				break;
			
			}
		}
		catch (InputMismatchException e) {
			System.out.println("숫자만입력하세요.");
			AccountManager4.scan.nextLine();
			}
		catch (MenuSelectException e) {
			/* getMessage는 에러메세지를 반환한다.
			-> "숫자만입력하세요." 이부분이 에러메세지 */
			System.out.println(e.getMessage());
		}
		}
	}//main 끝
}//class끝