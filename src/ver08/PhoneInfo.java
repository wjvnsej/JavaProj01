package ver08;

import java.io.Serializable;

/*
8단계[IO] : PhoneBookVer08.java
컬렉션 기반으로 변경후 인스턴스를 저장하기 위해 IO(입출력)을 적용하자.
ObjectInputStream, ObjectOutputStream 클래스를 기반으로 제작한다.
파일의 저장은 프로그램을 종료하는 시점에 이루어져야 하고, 
프로그램 시작 직후 전체정보를 조회하면 기존에 입력된 정보들이 출력되어야 한다.
 */
public class PhoneInfo implements Serializable{
	
	//멤버변수
	String name;
	String phoneNumber; 
		
	public PhoneInfo
		(String name, String phoneNumber) {
	
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public int hashCode() {
		
		int hc1 = name.hashCode();
		int hc2 = phoneNumber.hashCode();
		int result = hc1 + hc2;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		PhoneInfo phoneInfo = (PhoneInfo)obj;
		if(phoneInfo.name.equals(this.name)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	   public String toString() {
	      return "이름 : " + name + "\n전화번호 : " + phoneNumber;
	   }
	
}
















