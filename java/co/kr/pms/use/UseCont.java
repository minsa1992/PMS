package co.kr.pms.use;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/admin/")
public class UseCont {
	
	@Autowired
	UseDAO dao;
	
	/**
	 * 물품 사용 신청 내역
	 */
	@RequestMapping(value="useList.do", method=RequestMethod.GET)
	public String useList(Model model) {
		List<UseDTO> useList = dao.useList(); 
		model.addAttribute("useList",useList);
		return "admin/userequest"; //userequest.jsp
	}
	
}
