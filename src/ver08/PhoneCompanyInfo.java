package ver08;

public class PhoneCompanyInfo extends PhoneInfo {

	String c_name;
	
	public PhoneCompanyInfo
		(String name, String phoneNumber, String c_name) {
		super(name, phoneNumber);
		this.c_name = c_name;
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
	      return super.toString() + "\n회사명 : " + c_name;
	   }

}
