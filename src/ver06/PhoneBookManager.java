package ver06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneBookManager {

	String name, phoneNumber;
	private PhoneInfo[] phonebooks;
	private int infoNums;

	public PhoneBookManager(int num) {
		phonebooks = new PhoneInfo[num];
		infoNums = 0;
	}
	
	public void start() {
		
		while(true) {

			Scanner scan = new Scanner(System.in);
			
			menuShow();
			
			try {
				int choice = scan.nextInt();
				
				if(choice < 1 || choice > 5) {
					MenuSelectException notInt = 
							new MenuSelectException();
					throw notInt;						
				}
				
				switch (choice) {
					case MenuItem.INPUT: 
						addBook();
						break;
					case MenuItem.SEARCH:
						searchBook();
						break;
					case MenuItem.DELETE:
						deleteBook();
						break;
					case MenuItem.PRINT:
						showBook();
						break;
					case MenuItem.END:
						System.out.println("프로그램을 종료합니다.");
						return;	
				}
			}
			catch (MenuSelectException e) {
				System.out.println(e.getMessage());
			}
			catch (InputMismatchException  e) {
				System.out.println("문자말고 숫자를 입력해주세요.");
				scan.nextLine();
			}
			
		}
	}
	
	//메뉴출력
	public void menuShow() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램종료");
		System.out.print("선택 : ");
	}

	// 친구정보 저장
	public void addBook() {
		String name, phoneNumber, major, c_name;
		int select, grade;
		Scanner scan = new Scanner(System.in);

		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1.일반, 2.대학, 3.회사");
		System.out.println("선택 >> ");
		select = scan.nextInt();
		scan.nextLine();

		System.out.println("이름 : ");
		name = scan.nextLine();
		System.out.println("전화번호 : ");
		phoneNumber = scan.nextLine();

		switch (select) {
		
		case SubMenuItem.BASIC:
			PhoneInfo info = new PhoneInfo(name, phoneNumber);
			phonebooks[infoNums++] = info;
			break;
			
		case SubMenuItem.SCHOOL:
			System.out.println("전공 : ");
			major = scan.nextLine();
			System.out.println("학년 : ");
			grade = scan.nextInt();
			PhoneSchoolInfo s_Info = 
					new PhoneSchoolInfo(name, phoneNumber, major, grade);
			phonebooks[infoNums++] = s_Info;
			break;
			
		case SubMenuItem.COMPANY:
			System.out.println("회사 : ");
			c_name = scan.nextLine();
			PhoneCompanyInfo c_Info = 
					new PhoneCompanyInfo(name, phoneNumber, c_name);
			phonebooks[infoNums++] = c_Info;
			break;
		}
	}

	// 친구정보 검색
	public void searchBook() {
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다..");
		System.out.println("이름 : ");
		String searchName = scan.nextLine();

		for (int i = 0; i < infoNums; i++) {

			// 검색할 이름과 객체의 이름이 일치하는 경우 모든 정보를 출력함
			if (searchName.compareTo(phonebooks[i].name) == 0) {
				phonebooks[i].showPhoneInfo();
				System.out.println("데이터 검색이 완료되었습니다.");
				return;
			}
			else {
				System.out.println("검색결과가 없습니다.");
			}
		}
	}

	// 친구정보 삭제
	public void deleteBook() {
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다...");
		System.out.println("이름 : ");
		String deleteName = scan.nextLine();

		int deleteIndex = -1;

		for (int i = 0; i < infoNums; i++) {
			if (deleteName.compareTo(phonebooks[i].name) == 0) {
				phonebooks[i] = null;
				deleteIndex = i;
				infoNums--;
			}
		}
		if (deleteIndex == -1) {
			System.out.println("삭제 할 이름을 확인하고 다시 하세요.");
		} else {
			for (int i = deleteIndex; i < infoNums; i++) {
				phonebooks[i] = phonebooks[i + 1];
			}
			System.out.println("데이터 삭제가 완료되었습니다.");
		}
	}

	public void showBook() {
		System.out.println("주소록 출력을 시작합니다..");
		for (int i = 0; i < infoNums; i++) {
			phonebooks[i].showPhoneInfo();
		}
		System.out.println("주소록 출력이 완료되었습니다.");
	}
}
