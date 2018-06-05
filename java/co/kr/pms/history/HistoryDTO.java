package co.kr.pms.history;

public class HistoryDTO {
	private String history_id;			// 히스토리 아이디
	private String dated;				// 일자
	private String product_name;		// 물품 명
	private int use_num;				// 수량
	private String classify;			// 구분 (입고, 사용, 삭제)
	private int product_id;				// 물품 아이디
	private String product_location;	// 물품 위치
	private String brand;				// 브랜드명
	private String remarks;				// 비고 또는 사용 사유
	private String user_id;				// 사용자 아이디
	private String user_name;			// 사용자 명
	private String return_date;			// 반납 일자
	private int stock;					// 물품 가격
	private int change_code;			// 물품 변경 코드
	
	public String getHistory_id() {
		return history_id;
	}
	public void setHistory_id(String history_id) {
		this.history_id = history_id;
	}
	public String getDated() {
		return dated;
	}
	public void setDated(String dated) {
		this.dated = dated;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getUse_num() {
		return use_num;
	}
	public void setUse_num(int use_num) {
		this.use_num = use_num;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_location() {
		return product_location;
	}
	public void setProduct_location(String product_location) {
		this.product_location = product_location;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getChange_code() {
		return change_code;
	}
	public void setChange_code(int change_code) {
		this.change_code = change_code;
	}
}
