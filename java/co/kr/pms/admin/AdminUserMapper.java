package co.kr.pms.admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.kr.pms.user.PmsUserDTO;

@Repository(value="AdminUserMapper")
public interface AdminUserMapper {
	// 회원관리 > 회원 리스트
	public List<PmsUserDTO> userList();
		
	// 회원관리 > 회원 정보 상세 조회
	public PmsUserDTO userDetail(String user_id);
		
	// 회원관리 > 회원수정
	public void userUpdate(PmsUserDTO dto);
		
	// 회원관리 > 회원삭제
	public void userDelete(String user_id);
}
