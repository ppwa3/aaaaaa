package banking2;

import java.util.InputMismatchException;
import java.util.Scanner;

import bank.schema.ICustomDefine;
import banking.Account;

public class AccountManager2 {
	
	//키보드 입력을 위한 인스턴스
	static Scanner scan = new Scanner(System.in);
	//계좌정보 저장을 위한 인스턴스배열
	Account2[] accounts = new Account2[50];
	//개설된 계좌정보 카운트용 변수
	int accCnt = 0;
	
	public static void showMenu() {
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.프로그램종료");
	}
	
	//계좌개설을 위한 함수
	public void makeAccount() {
		System.out.print("계좌번호:");
		String a = AccountManager2.scan.nextLine();
		System.out.print("이름:");
		String n = AccountManager2.scan.nextLine();
		System.out.print("잔고:");
		int b = AccountManager2.scan.nextInt();
		
		int choice = 0;
		System.out.println("1. 보통예금계좌 2. 신용신뢰계좌");
		try {
		choice = AccountManager2.scan.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println("계좌개설에서 오류났음");
		}
		if(choice==1) {
			System.out.print("기본이자%(정수형태로입력):");
			int i = AccountManager2.scan.nextInt();
			
			NormalAccount2 norm = new NormalAccount2(a, n, b, i);
			accounts[accCnt++] = norm;
			System.out.println("계좌계설이 완료되었습니다.");
		}
		else if(choice==2) {  
			System.out.print("신용신뢰계좌:"); 
			System.out.print("기본이자%(정수형태로입력):");
			int inter = AccountManager2.scan.nextInt();
			AccountManager2.scan.nextLine();
			System.out.print("신용등급(A,B,C등급):");
			String c = AccountManager2.scan.nextLine();
			
			if(c.equalsIgnoreCase("a") || c.contentEquals("b") || c.equalsIgnoreCase("c")) {
			
			HighCreditAccount2 high = new HighCreditAccount2(a, n, b, inter, c);
			accounts[accCnt++] = high;
			System.out.println("계좌계설이 완료되었습니다.");
		}
			else {
				System.out.println("1번 아님 2번 누르라고");
				return;
			}
		}
	}
	//입금
	public void depositMoney() {
		System.out.print("찾을 계좌를 입력하세요:");
		//찾을 계좌를 입력함
		String searchAccount = AccountManager2.scan.nextLine();
		//계좌를 찾으면 if문이 실행된다
		for(int i=0 ; i<accCnt ; i++) {
			//length가 배열안에 있는 
			//가져온계좌번호랑 찾는 계좌번호를 비교해서 참이 나오면 if문안으로 들어가게된다.
			//여기서 compareTo가 비교하는 함수이다.
			if(searchAccount.compareTo(accounts[i].getAccountNum())==0) {
				System.out.print("입금할 금액을 입력하세요:");
				int addBalance = AccountManager2.scan.nextInt();
				//scan버퍼에 enter입력을 지워주기 위해 scan.nextLine()를 사용한다.
				scan.nextLine();
				accounts[i].countMoney(addBalance);
				//void지만 return이 생략되어있다. 메서드를 끝내기 위해서 return을 쓴다.
				return;
			}
			
		}
		
		System.out.println("찾을 계좌가 없습니다.");
		
	}
	//출금
	public void withdrawMoney() {
		//안내문구
		System.out.println("찾을 계좌 입력하기:");
		//실제 입력을 받는다.
		String searchAccount = AccountManager2.scan.nextLine();
		//accCnt : 개설된 계좌정보 카운트용 변수
		for(int i=0 ; i<accCnt ; i++) {
			//accounts[i] : 배열안에 i번 인덱스에 있는 Account2
			//searchAccount : 찾을 계좌 , a.compareTo(b) : a와 b가 같은지 비교 , ==0 : 같으면 0을 반환
			if(searchAccount.compareTo(accounts[i].getAccountNum())==0) {
				System.out.print("출금할 금액을 입력하세요:");
				int money = AccountManager2.scan.nextInt();
				int balance = accounts[i].getBalance() - money;
				accounts[i].setBalance(balance);
			}
		}
	}
	//모든계좌출력
	public void showAccInfo() {
		System.out.println("전체계좌출력:");
		for(int i=0 ; i<accCnt ; i++) {
			if(accCnt == 0) {
				System.out.println("계좌가 없다.");
				
			}
			//방법 1번
//			System.out.println("계좌번호: "+accounts[i].getAccountNum());
//			System.out.println("계좌번호: "+accounts[i].getName());
//			System.out.println("계좌번호: "+accounts[i].getBalance());
			//방법 2번
//			System.out.println(accounts[i]);
			//방법 3번
			accounts[i].showInfo();
			//.을 쓴건 accountsp[i]에서 showInfo(메서드) 호출
		}
	}
	
	}//class 끝
