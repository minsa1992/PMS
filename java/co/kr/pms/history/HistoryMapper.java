package co.kr.pms.history;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HistoryMapper {
	
	public void historyIns(@Param("change_code") int change_code, @Param("upStock") int upStock, @Param("product_id") int product_id, @Param("price") int price, @Param("brand") String brand,
			@Param("product_location") String product_location);

	public List<HistoryDTO> historyList();

	public int updClassify();

}
