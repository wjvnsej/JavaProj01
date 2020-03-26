package ver05;
/*
5단계[추상클래스] : PhoneBookVer05.java
기존 프로그램은 메뉴입력을 할 때 이름이 부여된 상수가 아닌 정수로 처리되고 있다.
때문에 Ver05 에서는 interface 기반의 상수표현에 의한 처리를 해보도록 한다. 
이를 통하여 코드는 보다 명확해 질 것이다.

1.데이터입력
2.데이터검색
3.데이터삭제
4.프로그램종료

1.일반
2.학교동창
3.회사동료
위의 메뉴를 interface를 통한 상수로 처리해본다.
 */

public class PhoneInfo {
	
	//멤버변수
	String name;
	String phoneNumber; 
		
	public PhoneInfo
		(String name, String phoneNumber) {
	
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	//정보출력용 메소드
	public void showPhoneInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
	}
}