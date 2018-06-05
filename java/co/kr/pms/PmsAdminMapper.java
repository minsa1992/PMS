package co.kr.pms;

public interface PmsAdminMapper {

	public PmsAdminDTO login(PmsAdminDTO dto);
	
	public PmsAdminDTO admin(String admin_id);
	
	public int adminupdate(PmsAdminDTO dto);
}
