package co.kr.pms.notice;

public class PmsNoticeDTO {

	private int notice_id;
	private String title;
	private String text;
	private String rdate;
	
	public int getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	
	@Override
	public String toString() {
		return "PmsNoticeDTO [notice_id=" + notice_id + ", title=" + title + ", text=" + text + ", rdate=" + rdate
				+ "]";
	}
	
}


