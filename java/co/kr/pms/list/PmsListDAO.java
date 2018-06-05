package co.kr.pms.list;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.kr.pms.history.HistoryMapper;


@Component
public class PmsListDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	//물품 전체를 리스트로 출력
	public ArrayList<PmsListDTO> list(){
		PmsListMapper mapper = sqlSession.getMapper(PmsListMapper.class);
		ArrayList<PmsListDTO> list = new ArrayList<PmsListDTO>();
		list = mapper.list();
		return list;
	}
	
	//물품 검색어로 찾기
	public ArrayList<PmsListDTO> searchlist(String keyword){
		PmsListMapper mapper = sqlSession.getMapper(PmsListMapper.class);
		ArrayList<PmsListDTO> list = new ArrayList<PmsListDTO>();
		list = mapper.searchlist(keyword);
		return list;
	}
	
	//물품 카테고리 검색으로 찾기
	public ArrayList<PmsListDTO> searchcategory(String category){
		PmsListMapper mapper = sqlSession.getMapper(PmsListMapper.class);
		ArrayList<PmsListDTO> list = new ArrayList<PmsListDTO>();
		list = mapper.searchcategory(category);
		return list;
	}
	
	//물품 상세보기
	public PmsListDTO read(PmsListDTO dto) {
		PmsListMapper mapper = sqlSession.getMapper(PmsListMapper.class);
		PmsListDTO rs = mapper.read(dto);
		return rs;
	}
	
	//사용자 물품 리스트 출력
	public ArrayList<PmsListDTO> ulist(){
		PmsListMapper mapper = sqlSession.getMapper(PmsListMapper.class);
		ArrayList<PmsListDTO> list = new ArrayList<PmsListDTO>();
		list = mapper.ulist();
		return list;
	}
	
	public int use_yn(PmsListDTO dto) {
		PmsListMapper mapper = sqlSession.getMapper(PmsListMapper.class);
		return mapper.use_yn(dto);
	}
	
	//물품 등록
	public int createproduct(PmsListDTO dto) {
		PmsListMapper mapper = sqlSession.getMapper(PmsListMapper.class);
		return mapper.insert(dto);
	}
	
	//물품 정보 수정
	public int updateproduct(PmsListDTO dto) {
		PmsListMapper mapper = sqlSession.getMapper(PmsListMapper.class);
		return mapper.update(dto);
	}
	
	//비품 사용시 입력 정보
	public int use1(int product_id, Date date, String user_id) {
		PmsListMapper mapper = sqlSession.getMapper(PmsListMapper.class);
		return mapper.use1(product_id, date, user_id);
	}
	
	//소모품 사용시 입력 정보
	public int use2(int product_id, int use_num, String user_id) {
		PmsListMapper mapper = sqlSession.getMapper(PmsListMapper.class);
		return mapper.use2(product_id, use_num, user_id);
	}

	// 물품 사용 여부 변경
	public void useyn(int product_id) {
		PmsListMapper mapper= sqlSession.getMapper(PmsListMapper.class);
		mapper.useyn(product_id);
	}

	// 물품 변경 이력 추가
	public void historyIns(int change_code, int upStock, int product_id, int price, String brand, String product_location) {
		HistoryMapper mapper= sqlSession.getMapper(HistoryMapper.class);
		mapper.historyIns(change_code, upStock, product_id, price, brand, product_location); 
	}

	// 물품 삭제
	public void productDel(PmsListDTO dto) {
		PmsListMapper mapper = sqlSession.getMapper(PmsListMapper.class);
		mapper.productDel(dto);
	}


}
