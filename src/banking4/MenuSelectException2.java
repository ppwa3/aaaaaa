package banking4;

public class MenuSelectException2 extends Exception{
//Exception은 자바 안에 있는 class이다. MenuSelectException가 상속을받는다.
//MenuSelectException - 자식class    Exception - 부모class
	
	public MenuSelectException2() {
		super("다시입력바람");//에러
	}
}
	
