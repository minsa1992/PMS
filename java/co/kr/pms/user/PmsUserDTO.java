package co.kr.pms.user;

public class PmsUserDTO {
	private int user_no;			// 사용자 번호
	private String user_id;			// 사용자 아이디
	private String password;		// 사용자 비밀번호
	private String user_name;		// 사용자 이름
	private String email;			// 이메일
	private int division_code;		// 부서 (0:경영지원 1:SM사업부 SM1팀 2:SM사업부 SM2팀 3:SS사업부)
	private String position_name;	// 직급
	private String insert_date;		// 사용자 등록 일자
	private String update_date;		// 수정 일자
	private String use_yn;			// 사용 여부 (Y:사용 N:비사용)
	private String login_date;		// 마지막 로그인 시간
	
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDivision_code() {
		return division_code;
	}
	public void setDivision_code(int division_code) {
		this.division_code = division_code;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getuse_yn() {
		return use_yn;
	}
	public void setuse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public String getLogin_date() {
		return login_date;
	}
	public void setLogin_date(String login_date) {
		this.login_date = login_date;
	}
	
	@Override
	public String toString() {
		return "PmsUserDTO [user_no=" + user_no + ", user_id=" + user_id + ", password=" + password + ", user_name="
				+ user_name + ", email=" + email + ", division_code=" + division_code + ", position_name="
				+ position_name + ", insert_date=" + insert_date + ", update_date=" + update_date + ", use_yn="
				+ use_yn + ", login_date=" + login_date + "]";
	}
	
}
