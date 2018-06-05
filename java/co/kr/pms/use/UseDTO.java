package co.kr.pms.use;

public class UseDTO {
	private int use_id;				// 사용신청서 아이디
	private int product_id;			// 물품 아이디
	private String user_id;			// 사용자 아이디
	private String user_name;		// 사용자 명
	private String use_date;		// 사용 일자
	private String return_date;		// 반납 일자
	private int use_num;			// 사용 물품 수량
	private String use_reason;		// 사유
	private String product_name;	// 물품 명
	
	public int getUse_id() {
		return use_id;
	}
	public void setUse_id(int use_id) {
		this.use_id = use_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUse_date() {
		return use_date;
	}
	public void setUse_date(String use_date) {
		this.use_date = use_date;
	}
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	public int getUse_num() {
		return use_num;
	}
	public void setUse_num(int use_num) {
		this.use_num = use_num;
	}
	public String getUse_reason() {
		return use_reason;
	}
	public void setUse_reason(String use_reason) {
		this.use_reason = use_reason;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	
}
