package banking3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountManager3 {

	// 키보드 입력을 위한 인스턴스
	static Scanner scan = new Scanner(System.in);
	// 계좌정보 저장을 위한 인스턴스배열
	Account3[] accounts = new Account3[50];
	// 개설된 계좌정보 카운트용 변수
	int accCnt = 0;

	public static void showMenu() {
		System.out.println("-----MENU-----");
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.프로그램종료");
	}

	// 계좌개설을 위한 함수
	public void makeAccount() {
		System.out.print("계좌번호:");
		String a = AccountManager3.scan.nextLine();
		System.out.print("이름:");
		String n = AccountManager3.scan.nextLine();
		System.out.print("잔고:");
		int b = AccountManager3.scan.nextInt();

		int choice = 0;
		System.out.println("1. 보통예금계좌 2. 신용신뢰계좌");
		try {
			choice = AccountManager3.scan.nextInt();
			scan.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("계좌개설에서 오류났음");
		}
		if (choice == 1) {
			System.out.print("기본이자%(정수형태로입력):");
			int i = AccountManager3.scan.nextInt();

			NormalAccount3 norm = new NormalAccount3(a, n, b, i);
			accounts[accCnt++] = norm;
			System.out.println("계좌계설이 완료되었습니다.");
		} else if (choice == 2) {
			System.out.print("신용신뢰계좌:");
			System.out.print("기본이자%(정수형태로입력):");
			int inter = AccountManager3.scan.nextInt();
			AccountManager3.scan.nextLine();
			System.out.print("신용등급(A,B,C등급):");
			String c = AccountManager3.scan.nextLine();

			if (c.equalsIgnoreCase("a") || c.contentEquals("b") || c.equalsIgnoreCase("c")) {

				HighCreditAccount3 high = new HighCreditAccount3(a, n, b, inter, c);
				accounts[accCnt++] = high;
				System.out.println("계좌계설이 완료되었습니다.");
			} else {
				System.out.println("1번 아님 2번 누르세요.");
				return;
			}
		}
	}

	// 입금
	public void depositMoney() {
		System.out.print("찾을 계좌를 입력하세요:");
		// 찾을 계좌를 입력함
		String searchAccount = AccountManager3.scan.nextLine();
		// 계좌를 찾으면 if문이 실행된다
		for (int i = 0; i < accCnt; i++) {
			// length가 배열안에 있는
			// 가져온계좌번호랑 찾는 계좌번호를 비교해서 참이 나오면 if문안으로 들어가게된다.
			// 여기서 compareTo가 비교하는 함수이다.
			if (searchAccount.compareTo(accounts[i].getAccountNum()) == 0) {
				System.out.print("입금할 금액을 입력하세요:");
				int addBalance = AccountManager3.scan.nextInt();
				scan.nextLine();
				// scan버퍼에 enter입력을 지워주기 위해 scan.nextLine()를 사용한다.
				// 예외처리 부분 -> 음수는 입금불가를 뜻하는 코드
				// 조건식 : addBalance가 입금할 금액이고 %를 사용해서 나머지가 0이면 입금가능
				// addBalance -> 입금액
				if (addBalance < 0) {
					System.out.println("음수는입금할수없다.");
					// void지만 return이 생략되어있다. 메서드를 끝내기 위해서 return을 쓴다.
					return;
					// 입금액을 500으로 나눠서 나머지가 0이되면 입금이 가능하다.
				} else {
					if (addBalance % 500 == 0) {
						accounts[i].plusMoney(addBalance);
						return;
					} else {
						System.out.println("입금액은 500원단위로만 가능");
						return;
					}
				}

			}
		}
		System.out.println("찾을 계좌가 없습니다.");

	}

	// 출금
	public void withdrawMoney() {
		// 안내문구
		System.out.println("찾을 계좌 입력하기:");
		// 실제 입력을 받는다.
		String searchAccount = AccountManager3.scan.nextLine();
		// accCnt : 개설된 계좌정보 카운트용 변수
		for (int i = 0; i < accCnt; i++) {
			// accounts[i] : 배열안에 i번 인덱스에 있는 Account3
			// searchAccount : 찾을 계좌 , a.compareTo(b) : a와 b가 같은지 비교 , ==0 : 같으면 0을 반환
			if (searchAccount.compareTo(accounts[i].getAccountNum()) == 0) {
				System.out.print("출금할 금액을 입력하세요:");
				int money = AccountManager3.scan.nextInt();
				scan.nextLine();
				// money가 출금할 금액
				if (money < 0) {
					System.out.println("음수는출금할수없다.");
					return;
				} else {
					if (money % 1000 != 0) {
						System.out.println("출금액은 1000원단위로만 가능");
						return;
					}
				}
				// accounts[i]배열안에 있는 계좌에서 getBalance가져오기
				if (accounts[i].getBalance() < money) {
					System.out.println("잔고가부족합니다.금액전체를출금할까요?");
					System.out.println("YES:금액전체출금처리");
					System.out.println("NO:출금요청취소");
					String money1 = AccountManager3.scan.nextLine();
					// equals는 두 객체의 내용이 같은지 비교
					if (money1.equals("YES")) {
						System.out.println("YES : 금액 전체 출금처리");
						System.out.println(accounts[i].getBalance() + "원을 출금합니다.");
						accounts[i].setBalance(0);
					} else if (money1.equals("NO")) {
						System.out.println("NO : 출금요청이 취소되었습니다.");
					} else {
						System.out.println("잘못된 입력입니다. 출금요청이 취소되었습니다.");
					}
				}
				else {
					int newBalance = accounts[i].getBalance()-money;
					accounts[i].setBalance(newBalance);
					System.out.println(money + "원이 정상적으로 출력되었습니다.");
				}
			}
		}
	}

	// 전체계좌출력
	public void showAccInfo() {
		System.out.println("전체계좌출력:");
		/*
		 * if문이 for문 밖에 있어야한다. accCnt가 0인 상태이기 때문에 if문이 안쪽에 있으면 코드가 제대로 실행되지 않는다.
		 */
		if (accCnt == 0) {
			System.out.println("계좌가 없다.");
		}
		for (int i = 0; i < accCnt; i++) {
			// 방법 1번
//			System.out.println("계좌번호: "+accounts[i].getAccountNum());
//			System.out.println("계좌번호: "+accounts[i].getName());
//			System.out.println("계좌번호: "+accounts[i].getBalance());
			// 방법 2번
//			System.out.println(accounts[i]);
			// 방법 3번
			accounts[i].showInfo();
			// .을 쓴건 accountsp[i]에서 showInfo(메서드) 호출
		}
	}
}
