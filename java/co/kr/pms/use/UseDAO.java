package co.kr.pms.use;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository 
public class UseDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	private UseMapper mapper;
	
	// 물품 사용 신청 내역
	public List<UseDTO> useList(){
		mapper = sqlSession.getMapper(UseMapper.class);
		return mapper.useList();
	}

	// 비품 사용 입력
	public void use1Insert(int product_id, String user_id, String use_reason, Date time) {
		mapper = sqlSession.getMapper(UseMapper.class);
		mapper.use1Insert(product_id, user_id, use_reason, time);
	}

	// 소모품 사용 입력
	public void use2Insert(int product_id, String user_id, String use_reason, int use_num) {
		mapper = sqlSession.getMapper(UseMapper.class);
		mapper.use2Insert(product_id, user_id, use_reason, use_num);
		//mapper.useApply();
	}

	// 마이페이지 물품 사용 내역
	public List<UseDTO> userUseList(String user_id){
		mapper = sqlSession.getMapper(UseMapper.class);
		return mapper.userUseList(user_id);
	}
	
}
