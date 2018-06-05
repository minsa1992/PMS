package co.kr.pms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.kr.pms.user.PmsUserDTO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class PmsloginCont {
	
	@Autowired
	PmsAdminDAO dao;
	

	public PmsloginCont() {
		System.out.println("PmsloginCont()--------------------------");
	}
	
	
	@RequestMapping(value="/index/adminlogin.do", method=RequestMethod.POST)
	public ModelAndView adminlogin(PmsAdminDTO dto, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		PmsAdminDTO rs = dao.login(dto);
		if(rs == null) {
		mav.setViewName("redirect:/");
		}
		else {
		session.setAttribute("adminid", rs.getAdmin_id());
		//session.setAttribute("adminpassword", rs.getPassword());
		mav.setViewName("redirect:/list/list.do");
		}
		return mav;
	}
	
	@RequestMapping(value="/admin/adminaccount.do")
	public ModelAndView adminaccount(HttpSession session){
		ModelAndView mav = new ModelAndView();
		String admin_id=(String)session.getAttribute("adminid");
		PmsAdminDTO dto = dao.admin(admin_id);
		mav.setViewName("/admin/admin_detail");
		mav.addObject("dto", dto);
		return mav;
	}
	
	
	@RequestMapping(value = "/admin/adminupdate.do", method=RequestMethod.POST)
	public ModelAndView adminupdate(PmsAdminDTO dto) {
		ModelAndView mav = new ModelAndView();
		int rs = dao.adminupdate(dto);
		mav.setViewName("redirect:/list/list.do");
		return mav;
	}
	
	
	
	
	@RequestMapping(value = "/admin/adminlogout.do")
	public ModelAndView adminlogout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.removeAttribute("id");
		session.removeAttribute("password");
		mav.setViewName("redirect:../");
		return mav;

	}
}
