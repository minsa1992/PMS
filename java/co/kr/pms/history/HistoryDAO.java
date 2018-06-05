package co.kr.pms.history;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HistoryDAO {
	@Autowired
	SqlSession sqlSession;
	
	private HistoryMapper mapper;
	
	public List<HistoryDTO> historyList(){
		mapper = sqlSession.getMapper(HistoryMapper.class);
		return mapper.historyList();
	}

	public int updClassify() {
		mapper = sqlSession.getMapper(HistoryMapper.class);
		return mapper.updClassify();
	}
}
