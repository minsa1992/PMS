package co.kr.pms.use;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository(value="UseMapper")
public interface UseMapper {
	
	//물품 사용 신청서 작성 
	//public void useApply();

	//물품 사용 리스트
	public List<UseDTO> useList();
	
	// 비품 사용
	public void use1Insert(@Param("product_id") int product_id, @Param("user_id") String user_id, @Param("use_reason") String use_reason, @Param("time") Date time);
	
	// 소모품 사용
	public void use2Insert(@Param("product_id") int product_id, @Param("user_id") String user_id, @Param("use_reason") String use_reason, 
			@Param("use_num") int use_num);
	
	public void useInsert(@Param("product_id") int product_id, @Param("user_id") String user_id, @Param("use_reason") String use_reason, 
			@Param("use_num") int use_num);

	public List<UseDTO> userUseList(String user_id);
	
}
