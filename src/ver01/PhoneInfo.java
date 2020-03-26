package ver01;
/*
멤버1 : 이름 String name
멤버2 : 전화번호 String phoneNumber 
멤버3 : 생년월일 String birthday

인스턴스를 생성할 때 이름과 전화번호는 필수입력이고 생년월일은 선택사항이다.
그러므로 생년월일은 없어도 인스턴스 생성이 되야한다.(생성자 메소드 오버로딩)
인스턴스 생성이 되었다면 해당정보를 출력할수 있는 showPhoneInfo()라는 메소드도 정의한다. 인스턴스 생성은 코드상에서 바로 한다.

실행결과>
Process started >>>
이름:성낙현
전화번호:010-7906-3600
생년월일:751130

이름:류상미
전화번호:010-7669-4120
생년월일:입력되지않음

 */
public class PhoneInfo {
	
	//멤버변수
	String name;
	String phoneNumber; 
	String birthday;
	
	//생성자
	public PhoneInfo
		(String name, String phoneNumber, String birthday) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	//생년월일은 필수사항 아니므로 인자가 없는 경우 null로 초기화
	public PhoneInfo
		(String name, String phoneNumber) {
	
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = null;
	}
	
	//정보출력용 메소드
	public void showPhoneInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		
		if(birthday == null) {
			System.out.println("생년월일 입력되지 않음");
		}
		else {
			System.out.println("생년월일 : " + birthday);
		}
	}
}