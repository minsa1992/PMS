package co.kr.pms.brequest;

import java.util.ArrayList;
import java.util.List;


public interface PmsBuyMapper {
	
	public ArrayList<PmsBuyDTO> list();
	
	public PmsBuyDTO read(PmsBuyDTO dto);
	
	public int insert(PmsBuyDTO dto);
	
	public int update(PmsBuyDTO dto);

	public List<PmsBuyDTO> userRequest(String user_id);
}
