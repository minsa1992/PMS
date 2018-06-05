package co.kr.pms.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.kr.pms.brequest.PmsBuyDAO;
import co.kr.pms.notice.PmsNoticeDAO;
import co.kr.pms.use.UseDAO;


@Controller
@RequestMapping("/user/")
public class PmsUserCont {

	
	public PmsUserCont() {
		System.out.println("PmsUserCont()");
	}
	
	@Autowired
	PmsUserDAO dao;
	
	@Autowired
	UseDAO usedao;
	
	@Autowired
	PmsBuyDAO buydao;
	
	@Autowired
	PmsNoticeDAO noticedao;
	
	@RequestMapping(value = "userlogin.do", method = RequestMethod.POST)
	public ModelAndView userlogin(PmsUserDTO dto, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		PmsUserDTO rs = dao.login(dto);
		if(rs == null) {
		mav.setViewName("redirect:/");
		}
		else {
		session.setAttribute("id", rs.getUser_id());
		session.setAttribute("password", rs.getPassword());
		mav.setViewName("redirect:/list/ulist.do");
		}
		return mav;
	}
	
	@RequestMapping(value = "goform.do")
	public ModelAndView goform() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/forms");
		return mav;
	}
	
	@RequestMapping(value = "userlogout.do")
	public ModelAndView userlogout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.removeAttribute("id");
		session.removeAttribute("password");
		mav.setViewName("redirect:../");
		return mav;
	}
	
	@RequestMapping(value = "createuser.do", method = RequestMethod.POST)
	public ModelAndView usercreate(PmsUserDTO dto) {
		ModelAndView mav = new ModelAndView();
		System.out.println(dto.toString());
		int rs = dao.create(dto);
		System.out.println(rs);
		mav.setViewName("redirect:./goform.do");
		return mav;
	}
	
	/**
	 * 마이페이지 정보 출력
	 */
	@RequestMapping(value="mypage.do")
	public String userInfo(Model model, PmsUserDTO dto, HttpSession session){
		String user_id=(String)session.getAttribute("id");
		
		model.addAttribute("dto",dao.userInfo(user_id));
		model.addAttribute("userUseList",usedao.userUseList(user_id));
		model.addAttribute("userRequest",buydao.userRequest(user_id));
		model.addAttribute("notice",noticedao.lastest());	
		
		return "user/mypage"; //mypage.jsp
	}
	
	/**
	 * 마이페이지 정보 수정
	 */
	@RequestMapping(value="update.do", method=RequestMethod.POST)
	public String userUpdate(PmsUserDTO dto, Model model, HttpSession session){

		String user_id=(String)session.getAttribute("id");
		dto.setUser_id(user_id);
		dao.mypageUpdate(dto);
		
		session.removeAttribute("id");
		return "redirect:/";
	}
	
	@RequestMapping(value = "checkId.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public int idCheck(PmsUserDTO dto) {
		System.out.println(dto.toString());
		int rs =  dao.idCheck(dto);
		return rs;
	}
}
