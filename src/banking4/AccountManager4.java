package banking4;

import java.awt.Choice;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class AccountManager4 {

	// 키보드 입력을 위한 인스턴스
	static Scanner scan = new Scanner(System.in);
	// accounts는 Set<Account4> 타입이다.
	HashSet<Account4> accounts = new HashSet<Account4>();

	public static void showMenu() {
		System.out.println("-----MENU-----");
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.계좌정보삭제");
		System.out.println("6.프로그램종료");
	}

	// 계좌개설을 위한 함수
	public void makeAccount() {
		System.out.print("계좌번호:");
		String a = scan.nextLine();
		System.out.print("이름:");
		String n = scan.nextLine();
		System.out.print("잔고:");
		int b = scan.nextInt();
		scan.nextLine();

		int choice = 0;
		System.out.println("1. 보통예금계좌 2. 신용신뢰계좌");
		try {
			choice = AccountManager4.scan.nextInt();
			scan.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("계좌개설에서 오류났음");
		}
		// Account4 클래스가 부모클래스이고 null을 사용해서 일단 빈값으로 만들어줌(계좌가 안만들어져서)
		Account4 acc = null;

		if (choice == 1) {
			System.out.print("기본이자%(정수형태로입력):");
			int i = AccountManager4.scan.nextInt();

			acc = new NormalAccount4(a, n, b, i);
			// accounts[accCnt++] = norm;
			// Hash Set은 중복된 값을 넣을 수 없어서 여기서 fall랑 true
		}
		if (choice == 2) {
			System.out.print("신용신뢰계좌:");
			System.out.print("기본이자%(정수형태로입력):");
			int inter = AccountManager4.scan.nextInt();
			AccountManager4.scan.nextLine();
			System.out.print("신용등급(A,B,C등급):");
			String c = AccountManager4.scan.nextLine();

			if (c.equalsIgnoreCase("a") || c.contentEquals("b") || c.equalsIgnoreCase("c")) {

				acc = new HighCreditAccount4(a, n, b, inter, c);
			} else {
				System.out.println("1번 아님 2번 누르라고");
				return;
			}
		}
		if (accounts.add(acc)) {
			System.out.println("계좌개설이 완료되었습니다.");
			return;
		}
		// void는 반환값이 없다. 근데 return은 쓴다.
		/*
		 * return이 없으면 메서드를 호출한 곳으로 돌아가지 못하기 때문에 프로그램이 진행되지 않는다. 따라서 반드시 모든 메서드는 return을
		 * 한다. void는 return 을 생략할 수 있다.
		 */
		else {
			System.out.println("중복계좌발견됨. 덮어쓸까요?(y or n)");
			// y나 n을 입력받는부분
			String select = AccountManager4.scan.nextLine();
			if (select.equals("y")) {
				System.out.println("덮어쓰자");
				// 삭제해주는 메서드 remove
				accounts.remove(acc);
				// 새로만든계좌를 추가
				accounts.add(acc);
				return;
			} else if (select.equals("n")) {
				System.out.println("덮어쓰지말자");
				return;
			}
		}

	}

	// 입금
	public void depositMoney() {
		System.out.print("찾을 계좌를 입력하세요:");
		// 찾을 계좌를 입력함
		String searchAccount = AccountManager4.scan.nextLine();
		// 계좌를 찾으면 if문이 실행된다
		// for (int i = 0; i < accCnt; i++) {
		for (Account4 acc : accounts) {
			// length가 배열안에 있는
			// 가져온계좌번호랑 찾는 계좌번호를 비교해서 참이 나오면 if문안으로 들어가게된다.
			// 여기서 compareTo가 비교하는 함수이다.
			if (acc.getAccountNum().equals(searchAccount)) {
				System.out.print("입금할 금액을 입력하세요:");
				int addBalance = AccountManager4.scan.nextInt();
				// scan버퍼에 enter입력을 지워주기 위해 scan.nextLine()를 사용한다.
				scan.nextLine();
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
		System.out.println("찾을 계좌 입력하기:");
		String searchAccount = AccountManager4.scan.nextLine();
		for (Account4 acc : accounts) {
			if (acc.getAccountNum().equals(searchAccount)) {
				System.out.print("출금할 금액을 입력하세요:");
				int money = AccountManager4.scan.nextInt();
				scan.nextLine();
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
				if (acc.getBalance() < money) {
					System.out.println("잔고가부족합니다.금액전체를출금할까요?");
					System.out.println("YES:금액전체출금처리 / NO:출금요청취소");
					String money1 = AccountManager4.scan.nextLine();
					// equals는 두 객체의 내용이 같은지 비교
					if (money1.equals("YES")) {
						System.out.println("YES : 금액 전체 출금처리");
						System.out.println(acc.getBalance() + "원을 출금합니다.");
						acc.setBalance(0);
					} else if (money1.equals("NO")) {
						System.out.println("NO : 출금요청이 취소되었습니다.");
					} else {
						System.out.println("잘못된 입력입니다. 출금요청이 취소되었습니다.");
					}
				} else {
					acc.setBalance(acc.getBalance() - money);
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
		// null은 비어있다 라는걸 뜻함
		if (accounts == null) {
			System.out.println("계좌가 없다.");
		}
		for (Account4 acc : accounts) {
			// 방법 1번
//			System.out.println("계좌번호: "+accounts[i].getAccountNum());
//			System.out.println("계좌번호: "+accounts[i].getName());
//			System.out.println("계좌번호: "+accounts[i].getBalance());
			// 방법 2번
//			System.out.println(accounts[i]);
			// 방법 3번
			acc.showInfo();
			// .을 쓴건 accounts[i]에서 showInfo(메서드) 호출
		}
	}

	public void delete() {
		// 스캔전에 println문써서 무엇을 입력받을건지 안내해준다.
		System.out.println("삭제할 계좌번호를 입력하세요.");
		String deleacc = scan.nextLine();
		for (Account4 acc : accounts) {
			if (acc.getAccountNum().equals(deleacc)) {
				//HashSet에서 remove메서드는 삭제하는 메서드
				accounts.remove(acc);
			}

				System.out.println("계좌가 삭제되었습니다.");
		}
	}

}
