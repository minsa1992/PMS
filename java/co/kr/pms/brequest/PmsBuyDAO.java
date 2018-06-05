package co.kr.pms.brequest;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PmsBuyDAO {
	
	@Autowired
	SqlSession sqlSession;

		//물품 구매 요청 불러오기
		public ArrayList<PmsBuyDTO> list(){
			PmsBuyMapper mapper = sqlSession.getMapper(PmsBuyMapper.class);
			ArrayList<PmsBuyDTO> list = new ArrayList<PmsBuyDTO>();
			list = mapper.list();
			return list;
		
		}
		
		//물품 구매 요청 상세보기
		public PmsBuyDTO read(PmsBuyDTO dto) {
			PmsBuyMapper mapper = sqlSession.getMapper(PmsBuyMapper.class);
			return mapper.read(dto);
				
		}
		
		//물품 구매 요청 등록
		public int insert(PmsBuyDTO dto) {
			PmsBuyMapper mapper = sqlSession.getMapper(PmsBuyMapper.class);
			return mapper.insert(dto);
			
		}
		
		//물품 구매 요청 승인 여부 체크
		public int checkadmin(PmsBuyDTO dto) {
			PmsBuyMapper mapper = sqlSession.getMapper(PmsBuyMapper.class);
			return mapper.update(dto);
			
		}
		
		public List<PmsBuyDTO> userRequest(String user_id) {
			PmsBuyMapper mapper = sqlSession.getMapper(PmsBuyMapper.class);
			return mapper.userRequest(user_id);
		}
	
}
