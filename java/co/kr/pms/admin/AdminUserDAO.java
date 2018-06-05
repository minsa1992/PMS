package co.kr.pms.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.kr.pms.user.PmsUserDTO;

@Repository
public class AdminUserDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	private AdminUserMapper mapper;
	
	public List<PmsUserDTO> userList(){
		mapper = sqlSession.getMapper(AdminUserMapper.class);
		return mapper.userList();
	}
	
	public PmsUserDTO userDetail(String user_id) {
		mapper = sqlSession.getMapper(AdminUserMapper.class);
		return mapper.userDetail(user_id);
	}
	
	public void userUpdate(PmsUserDTO dto) {
		mapper = sqlSession.getMapper(AdminUserMapper.class);
		mapper.userUpdate(dto);
	}
	
	public void userDelete(String user_id) {
		mapper = sqlSession.getMapper(AdminUserMapper.class);
		mapper.userDelete(user_id);
	}

}
