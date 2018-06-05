package co.kr.pms.user;

public interface PmsUserMapper {
	
	public int create(PmsUserDTO dto);
	
	public PmsUserDTO login(PmsUserDTO dto);
	
	// 마이페이지 > 정보보기
	public PmsUserDTO userInfo(String user_id);
	
	// 마이페이지 > 정보변경
	public int mypageUpdate(PmsUserDTO dto);
	
	public int check(PmsUserDTO dto);
}