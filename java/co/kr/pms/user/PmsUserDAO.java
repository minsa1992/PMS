package co.kr.pms.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PmsUserDAO {

	@Autowired
	SqlSession sqlSession;
	
	public int create(PmsUserDTO dto) {
		PmsUserMapper mapper = sqlSession.getMapper(PmsUserMapper.class);
		return mapper.create(dto);
	}
	
	public PmsUserDTO login(PmsUserDTO dto) {
		PmsUserMapper mapper = sqlSession.getMapper(PmsUserMapper.class);
		return mapper.login(dto);
	}
	
	public PmsUserDTO userInfo(String user_id) {
		PmsUserMapper mapper = sqlSession.getMapper(PmsUserMapper.class);
		return mapper.userInfo(user_id);
	}
		
	public int mypageUpdate(PmsUserDTO dto) {
		PmsUserMapper mapper = sqlSession.getMapper(PmsUserMapper.class);
		return mapper.mypageUpdate(dto);
	}
	
	public int idCheck(PmsUserDTO dto) {
		PmsUserMapper mapper = sqlSession.getMapper(PmsUserMapper.class);
		return mapper.check(dto);
	}
}
