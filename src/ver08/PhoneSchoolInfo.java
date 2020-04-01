package ver08;

public class PhoneSchoolInfo extends PhoneInfo{

	String major;
	int grade;
	
	public PhoneSchoolInfo
		(String name, String phoneNumber, String major, int grade) {
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;	
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
	      return super.toString() + 
	    		  "\n전공 : " + major + "\n학년 : " + grade;
	   }
}
