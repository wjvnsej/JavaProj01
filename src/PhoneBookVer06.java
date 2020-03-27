import ver06.PhoneBookManager;
/*
6단계[예외처리] : PhoneBookVer06.java
-예외처리1 : 메뉴를 입력할 때 1~5이외의 정수를 입력했을경우 
MenuSelectException(개발자정의) 예외를 발생시키고 이를 적절히 처리해보자.
-예외처리2 : 메뉴를 선택할 때 정수대신 문자열을 입력하면
 InputMismatchException 예외가 발생될것이다. 이를 적절히 예외처리 해보자.
-예외처리3 : 이클립스에서는 검색결과가 없을때 NullPointerException이 발생한다. 
이를 적절히 처리해보자.(테스트시 발생여부가 확인되지 않는다면 그냥 넘어간다)

조건
- 메뉴입력은 nextInt(); 를 사용한다.
- 예외가 발생할 경우 메시지를 띄워주고 메뉴를 재선택 하도록 처리한다. 
즉 프로그램이 종료되지 않도록 한다.
 */
public class PhoneBookVer06 {
	
	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager(100); 
		manager.start();
		
	}
}