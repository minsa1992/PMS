package co.kr.pms.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.kr.pms.user.PmsUserDTO;

@Controller
@RequestMapping("/admin/")
public class AdminUserCont {
	
	@Autowired
	AdminUserDAO dao;

	/**
	 * 회원관리 리스트 페이지
	 */
	@RequestMapping(value="list.do", method=RequestMethod.GET)
	public String userlist(Model model) {
		List<PmsUserDTO> userList = dao.userList(); 
		model.addAttribute("userList",userList);
		return "admin/member"; //member.jsp
	}
	
	/**
	 * 회원관리 회원 상세 정보 페이지
	 */
	@RequestMapping(value="userDetail.do", method=RequestMethod.GET)
	public String userDetail(String user_id, Model model) {
		model.addAttribute("dto",dao.userDetail(user_id));
		return "admin/member_detail";
	}
	
	/**
	 * 회원관리 회원정보 수정
	 */
	@RequestMapping(value="update.do", method=RequestMethod.POST)
	public String userUpdate(PmsUserDTO dto){
		System.out.println("넘어가냐?"+dto.getUser_id());
		dao.userUpdate(dto);
		return "redirect:/admin/list.do";
	}
		
	/**
	 * 회원관리 회원 삭제
	 */
	@RequestMapping(value="delete.do/{user_id}", method=RequestMethod.GET)
	@ResponseBody
	public void userDelete(@PathVariable("user_id") String user_id){
		System.out.println("aaa"+user_id);
		dao.userDelete(user_id);
	}
}
