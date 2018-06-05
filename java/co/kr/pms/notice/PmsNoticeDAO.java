package co.kr.pms.notice;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class PmsNoticeDAO {

	@Autowired
	SqlSession sqlSession;
	
	public int create(PmsNoticeDTO dto) {
		PmsNoticeMapper mapper = sqlSession.getMapper(PmsNoticeMapper.class);
		return mapper.create(dto);
	}
	
	public ArrayList<PmsNoticeDTO> nlist() {
		PmsNoticeMapper mapper = sqlSession.getMapper(PmsNoticeMapper.class);
		return mapper.list();
	}
	
	public PmsNoticeDTO nread(int notice_id) {
		PmsNoticeMapper mapper = sqlSession.getMapper(PmsNoticeMapper.class);
		return mapper.read(notice_id);
	}
	
	public int nupdate(PmsNoticeDTO dto) {
		PmsNoticeMapper mapper = sqlSession.getMapper(PmsNoticeMapper.class);
		return mapper.update(dto);
	}
	
	public int ndelete(PmsNoticeDTO dto) {
		PmsNoticeMapper mapper = sqlSession.getMapper(PmsNoticeMapper.class);
		return mapper.delete(dto);
	}
	
	public PmsNoticeDTO lastest() {
		PmsNoticeMapper mapper = sqlSession.getMapper(PmsNoticeMapper.class);
		return mapper.lastest();
	}
}
