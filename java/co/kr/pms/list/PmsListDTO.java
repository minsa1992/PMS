package co.kr.pms.list;

import org.springframework.web.multipart.MultipartFile;

public class PmsListDTO {
	
	private int product_id;
	private String product_name;
	private int stock;
	private int price;
	private String consumable;
	private String insert_date;
	private String update_date;
	private String user_id;
	private String brand;
	private String poster;
	private String product_location;
	private int usecount;
	private String category;
	private String return_date;
	private String use_yn;
	private long filesize;
	private int upStock;
	private String delete_yn;
	
	private MultipartFile posterMF; 
	
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getUsecount() {
		return usecount;
	}
	public void setUsecount(int usecount) {
		this.usecount = usecount;
	}
	public MultipartFile getPosterMF() {
		return posterMF;
	}
	public void setPosterMF(MultipartFile posterMF) {
		this.posterMF = posterMF;
	}
	
	public String getProduct_location() {
		return product_location;
	}
	public void setProduct_location(String product_location) {
		this.product_location = product_location;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getConsumable() {
		return consumable;
	}
	public void setConsumable(String consumable) {
		this.consumable = consumable;
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public int getUpStock() {
		return upStock;
	}
	public void setUpStock(int upStock) {
		this.upStock = upStock;
	}		
	public String getDelete_yn() {
		return delete_yn;
	}
	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
	}
	
	@Override
	public String toString() {
		return "PmsListDTO [product_id=" + product_id + ", product_name=" + product_name + ", stock=" + stock
				+ ", price=" + price + ", consumable=" + consumable + ", insert_date=" + insert_date + ", update_date="
				+ update_date + ", user_id=" + user_id + ", brand=" + brand + ", poster=" + poster
				+ ", product_location=" + product_location + "]";
	}
	
}
