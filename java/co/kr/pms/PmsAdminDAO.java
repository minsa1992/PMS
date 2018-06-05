package co.kr.pms;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class PmsAdminDAO {

	@Autowired
	SqlSession sqlSession;
	
	public PmsAdminDTO login(PmsAdminDTO dto){

		PmsAdminMapper mapper = sqlSession.getMapper(PmsAdminMapper.class);
		return  mapper.login(dto);
		
	}
	
	public PmsAdminDTO admin(String admin_id){
		PmsAdminMapper mapper = sqlSession.getMapper(PmsAdminMapper.class);
		return  mapper.admin(admin_id);
	}
	
	public int adminupdate(PmsAdminDTO dto) {
		PmsAdminMapper mapper = sqlSession.getMapper(PmsAdminMapper.class);
		return  mapper.adminupdate(dto);
	}
}
