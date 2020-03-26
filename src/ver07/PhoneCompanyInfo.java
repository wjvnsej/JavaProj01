package ver07;

public class PhoneCompanyInfo extends PhoneInfo {

	String c_name;
	
	public PhoneCompanyInfo
		(String name, String phoneNumber, String c_name) {
		super(name, phoneNumber);
		this.c_name = c_name;
	}
	
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("회사명 : " + c_name);
	}

}
