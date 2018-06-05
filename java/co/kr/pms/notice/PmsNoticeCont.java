package co.kr.pms.notice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PmsNoticeCont {
	
	public PmsNoticeCont() {
		System.out.println("PmsNoticeCont()--------------");
	}
	
	@Autowired
	PmsNoticeDAO dao;
	
	//공지 사항 등록
	@RequestMapping(value = "/notice/create.do", method = RequestMethod.POST)
	public ModelAndView create(PmsNoticeDTO dto) {
		ModelAndView mav = new ModelAndView();
		int rs = dao.create(dto);
		mav.setViewName("redirect:./nlist.do");
		return mav;
	}
	
	//공지 사항 리스트 출력
	@RequestMapping(value = "/notice/nlist.do", method = RequestMethod.GET)
	public ModelAndView nlist() {
		ModelAndView mav = new ModelAndView();
		ArrayList<PmsNoticeDTO> list = dao.nlist();
		mav.setViewName("admin/notice");
		mav.addObject("list", list);
		return mav;
	}
	
	//공지 사항 내용 상세 보기
	/*@RequestMapping(value = "/notice/nread.do", method = RequestMethod.GET)
	public ModelAndView nread(int notice_id) {
		ModelAndView mav = new ModelAndView();
		ArrayList<PmsNoticeDTO> list = dao.nlist();
		PmsNoticeDTO rs = dao.nread(notice_id);
		mav.setViewName("admin/notice");
		mav.addObject("list", list);
		mav.addObject("rs", rs);
		return mav;
	}*/
	
	@RequestMapping(value = "/notice/nread.do", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public PmsNoticeDTO nread(String notice_id) {
		int noticeid = Integer.parseInt(notice_id);
		PmsNoticeDTO rs = dao.nread(noticeid);
		return rs;
	}
	
	
	
	//공지 사항 내용 변경
	@RequestMapping(value = "/notice/nupdate.do", method = RequestMethod.POST)
	public ModelAndView nupdate(PmsNoticeDTO dto) {
		ModelAndView mav = new ModelAndView();
		int rs = dao.nupdate(dto);
		mav.setViewName("redirect:./nlist.do");
		return mav;
	}
	
	//공지 사항 내용 삭제
	@RequestMapping(value = "/notice/delete.do", method = RequestMethod.POST)
	public ModelAndView ndelete(PmsNoticeDTO dto) {
		ModelAndView mav = new ModelAndView();
		int rs = dao.ndelete(dto);
		mav.setViewName("redirect:./nlist.do");
		return mav;
	}
	
	

}
