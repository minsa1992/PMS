package co.kr.pms.notice;

import java.util.ArrayList;

public interface PmsNoticeMapper {

	public int create(PmsNoticeDTO dto);
	
	public ArrayList<PmsNoticeDTO> list();
	
	public PmsNoticeDTO read(int notice_id);
	
	public int update(PmsNoticeDTO dto);
	
	public int delete(PmsNoticeDTO dto);
	
	public PmsNoticeDTO lastest();
}
