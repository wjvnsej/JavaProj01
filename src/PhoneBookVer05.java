import java.util.Scanner;

import ver05.MenuItem;
import ver05.PhoneBookManager;
import ver05.PhoneInfo;
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
public class PhoneBookVer05 {
	
	public static void menuShow() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램종료");
		System.out.print("선택 : ");
	}

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager(100); 
		
		while(true) {

			menuShow();

			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			
			switch (choice) {
			case MenuItem.INPUT: 
				manager.addBook();
				break;
			case MenuItem.SEARCH:
				manager.searchBook();
				break;
			case MenuItem.DELETE:
				manager.deleteBook();
				break;
			case MenuItem.PRINT:
				manager.showBook();
				break;
			case MenuItem.END:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}








