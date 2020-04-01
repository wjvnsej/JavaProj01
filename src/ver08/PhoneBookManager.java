package ver08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager {	   
	HashSet<Object> set;
	public PhoneBookManager() {
		try {
			
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream("src/ver08/PhoneBook.obj"));
			
			set = (HashSet<Object>) in.readObject();
			
		} 
		catch (Exception e) {
			set = new HashSet<Object>();
		}
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
						savePhoneBook();
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
	
	//중복검사
	public void checkName(String name) {
		
		Scanner scan = new Scanner(System.in);
		boolean checkFlag = false;
		int checkSelect;
	      
		Iterator<Object> itr = set.iterator();
		while(itr.hasNext()) {
			PhoneInfo phoneInfo = (PhoneInfo) itr.next();
			if(name.equals(phoneInfo.name)) {
				checkFlag = true;
	         }
		}
		if(checkFlag == true) {
			System.out.println("중복된 이름이 있습니다. 내용을 덮어쓸까요?");
			System.out.println("1.덮어쓰기, 2. 돌아가기");
			checkSelect = scan.nextInt();
			
			if(checkSelect == 1) {
				itr.remove();
				return;
			}
			else if(checkSelect == 2) {
				start();
			}
		}
		else {
			return;
		}
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
		
		//중복처리를 위해 checkName호출
		checkName(name);
		
		System.out.println("전화번호 : ");
		phoneNumber = scan.nextLine();
		
		switch (select) {
			case SubMenuItem.BASIC:
				set.add(new PhoneInfo(name, phoneNumber));
				System.out.println("[ 저장 후 연락처 수 ] : " + set.size());
				break;
				
			case SubMenuItem.SCHOOL:
				System.out.println("전공 : ");
				major = scan.nextLine();
				System.out.println("학년 : ");
				grade = scan.nextInt();
				
				set.add(new PhoneSchoolInfo
						(name, phoneNumber, major, grade));
				System.out.println("[ 저장 후 연락처 수 ] : " + set.size());
				break;
				
			case SubMenuItem.COMPANY:
				System.out.println("회사 : ");
				c_name = scan.nextLine();
				
				set.add(new PhoneCompanyInfo
						(name, phoneNumber, c_name));
				System.out.println("[ 저장 후 연락처 수 ] : " + set.size());
			break;
		}
	}

	// 친구정보 검색
	public void searchBook() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다..");
		System.out.println("이름 : ");
		String searchName = scan.nextLine();
		
		boolean searchFlag = false;
	      
		Iterator<Object> itr = set.iterator();
		while(itr.hasNext()) {
			PhoneInfo phoneInfo = (PhoneInfo) itr.next();
			if(searchName.equals(phoneInfo.name)) {
				searchFlag = true;
				System.out.println(phoneInfo.toString());
	         }
		}
		if(searchFlag == true) {
			System.out.println("요청하신 정보를 찾았습니다.");
		}
		else {
			System.out.println("검색결과가 없습니다.");
		}
	}
		

	// 친구정보 삭제
	public void deleteBook() {
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다...");
		System.out.println("이름 : ");
		String deleteName = scan.nextLine();

		boolean deleteFlag = false;
	      
		Iterator<Object> itr = set.iterator();
		while(itr.hasNext()) {
			PhoneInfo phoneInfo = (PhoneInfo) itr.next();
			if(deleteName.equals(phoneInfo.name)) {
				deleteFlag = true;
				itr.remove();
	         }
		}
		if(deleteFlag == true) {
			System.out.println("데이터를 삭제했습니다.");
			System.out.println("[삭제 후 연락처 수 ] : " + set.size());
		}
		else {
			System.out.println("검색결과가 없습니다.");
		}
	}

	public void showBook() {
		System.out.println("주소록 출력을 시작합니다..");
		
		for(Object phoneInfo : set)
	      {
	         System.out.println(phoneInfo.toString());         
	      }
		System.out.println("주소록 출력이 완료되었습니다.");
	}
	
	public void savePhoneBook() {		
		try {
			ObjectOutputStream out = 
					new ObjectOutputStream(
							new FileOutputStream
								("src/ver08/PhoneBook.obj")
					);
					
				out.writeObject(set);
			
		}
		catch (IOException e) {
			System.out.println("파일이 저장되지 않았습니다.");
			e.printStackTrace();
		}
	}
	
}