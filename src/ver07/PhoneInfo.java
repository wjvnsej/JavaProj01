package ver07;
/*
7단계[컬렉션] : PhoneBookVer07.java
동명이인이 있다고 가정했을때 3단계에서 진행한 배열을 이용해서는 
구조적으로 중복을 막을수 없다. 이번에는 중복 저장을 허용하지 않는 
HashSet<E> 클래스를 대상으로 저장이 되도록 해보자. 
“이름이 같으면 다른 정보가 달라도 동일한 객체(인스턴스)로 간주한다”
즉 동일한 이름을 입력하는 경우라면 덮어쓸지 여부를 물어본후 처리한다.
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
















