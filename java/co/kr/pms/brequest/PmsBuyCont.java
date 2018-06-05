package co.kr.pms.brequest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.kr.pms.notice.PmsNoticeDAO;
import co.kr.pms.notice.PmsNoticeDTO;


@Controller
public class PmsBuyCont {
	
	@Autowired
	PmsBuyDAO dao;
	
	@Autowired
	PmsNoticeDAO noticedao;
	
	
	public PmsBuyCont() {
		System.out.println("PmsBuyCont() ��ü ����--------------");
	}
	
	//물품 구매 요청 리스트 불러오기
	@RequestMapping(value="/brequest/buyrequest.do", method=RequestMethod.GET)
	public ModelAndView buylist() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/buyrequest");
		ArrayList<PmsBuyDTO> list = dao.list();
		mav.addObject("list", list);
		return mav;
	}
	
	//물품 구매 요청정보 상세 보기 
	/*@RequestMapping(value="/brequest/buyread.do", method=RequestMethod.GET)
	public ModelAndView buyread(PmsBuyDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/buyrequest");
		ArrayList<PmsBuyDTO> list = dao.list();
		PmsBuyDTO rs = dao.read(dto);
		mav.addObject("list", list);
		mav.addObject("rs", rs);
		return mav;
	}*/
	
	//물품 구매 요청정보 상세 보기 
		@RequestMapping(value="/brequest/buyread.do", method= {RequestMethod.GET, RequestMethod.POST})
		@ResponseBody
		public PmsBuyDTO buyread(PmsBuyDTO dto) {
			PmsBuyDTO rs = dao.read(dto);
			return rs;
		}
	
	
	
	
	
	//물품 구매 요청 등록
	@RequestMapping(value="/brequest/buyenroll.do", method=RequestMethod.POST)
	public ModelAndView buyenroll(PmsBuyDTO dto) {
		ModelAndView mav = new ModelAndView();
		int rs = dao.insert(dto);
		if(rs == 1) {
			mav.setViewName("redirect:../list/ulist.do");
		}else {
			mav.setViewName("request");
		}
		return mav;
	}
	
	//물품 구매 승인 여부 체크
	@RequestMapping(value="/brequest/checkadmin.do", method=RequestMethod.POST)
	public ModelAndView checkadmin(PmsBuyDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/buyrequest");
		System.out.println(dto.getProduct_result());
		int res = dao.checkadmin(dto);
		ArrayList<PmsBuyDTO> list = dao.list();
		PmsBuyDTO rs = dao.read(dto);
		mav.addObject("list", list);
		mav.addObject("rs", rs);
		return mav;
	}
	
	//물품 요청 페이지로 이동
	@RequestMapping(value="/brequest/brequest.do")
	public ModelAndView brequest() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/request");
		PmsNoticeDTO notice = noticedao.lastest();
		mav.addObject("notice", notice);
		return mav;
	}
	
}
