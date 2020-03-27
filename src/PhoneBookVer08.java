import ver08.PhoneBookManager;
/*
8단계[IO] : PhoneBookVer08.java
컬렉션 기반으로 변경후 인스턴스를 저장하기 위해 IO(입출력)을 적용하자.
ObjectInputStream, ObjectOutputStream 클래스를 기반으로 제작한다.
파일의 저장은 프로그램을 종료하는 시점에 이루어져야 하고, 
프로그램 시작 직후 전체정보를 조회하면 기존에 입력된 정보들이 출력되어야 한다.
 */
public class PhoneBookVer08 {
	
	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager(); 
		manager.start();
		
	}
}	