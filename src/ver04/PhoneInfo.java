package ver04;
/*
4단계[상속] 

[실행결과]
03Lecture\03.JAVA\Java소스\Ver1.0\LevelProject
java PhoneBookVer04
Process started >>>

선택하세요...
1. 데이터 입력
2. 데이터 검색
3. 데이터 삭제
4. 주소록 출력
5. 프로그램 종료
선택: 1

데이터 입력을 시작합니다..
1.일반, 2.동창, 3.회사
선택>> 1

이름: 홍길동
전화번호: 1111
데이터 입력이 완료되었습니다.
 
선택하세요...
1. 데이터 입력
2. 데이터 검색
3. 데이터 삭제
4. 주소록 출력
5. 프로그램 종료
선택: 1
데이터 입력을 시작합니다..
1.일반, 2.동창, 3.회사
선택>> 2

이름: 이순신
전화번호: 2222
전공: 거북선제조
학년: 100
데이터 입력이 완료되었습니다.
 
선택하세요...
1. 데이터 입력
2. 데이터 검색
3. 데이터 삭제
4. 주소록 출력
5. 프로그램 종료
선택: 1
데이터 입력을 시작합니다..
1.일반, 2.대학, 3.회사
선택>> 3

이름: 세종대왕
전화번호: 3333
회사: 집현전
데이터 입력이 완료되었습니다.
 
선택하세요...
1. 데이터 입력
2. 데이터 검색
3. 데이터 삭제
4. 주소록 출력
5. 프로그램 종료
선택: 5
프로그램을 종료합니다.
<<< Process finished. (Exit code 0)
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