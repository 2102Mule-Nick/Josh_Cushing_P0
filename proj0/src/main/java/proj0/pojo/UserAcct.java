package proj0.pojo;

public class UserAcct {
	private String userId; 
	private String userName;
	private String passWord; 
	private double checkingBal;
	
	//---------------------------
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public double getCheckingBal() {
		return checkingBal;
	}
	public void setCheckingBal(double checkingBal) {
		this.checkingBal = checkingBal;
	}
//----------------------------------------------------

	//no-args constructor
	public UserAcct() {
	}
	
	// args constructor
	public UserAcct(String userId, String userName, String passWord) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.checkingBal = 0;
	}	
}