package co.kr.pms.list;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

public interface PmsListMapper {
	
	public ArrayList<PmsListDTO> list();

	public PmsListDTO read(PmsListDTO dto);
	
	public ArrayList<PmsListDTO> ulist();
	
	public int insert(PmsListDTO dto);
	
	public int update(PmsListDTO dto);
	
	public ArrayList<PmsListDTO> searchlist(String keyword);
	
	public ArrayList<PmsListDTO> searchcategory(String category);
		
	public int use1(@Param("product_id") int product_id, @Param("date") Date date, @Param("user_id") String user_id);
	
	public int use2(@Param("product_id") int product_id, @Param("use_num") int use_num, @Param("user_id") String user_id);

	public void useyn(@Param("product_id") int product_id);
	
	public int use_yn(PmsListDTO dto);

	public void productDel(PmsListDTO dto);

}
