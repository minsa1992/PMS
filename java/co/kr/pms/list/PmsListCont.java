package co.kr.pms.list;


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import co.kr.pms.history.HistoryDTO;
import co.kr.pms.notice.PmsNoticeDAO;
import co.kr.pms.notice.PmsNoticeDTO;
import co.kr.pms.use.UseDAO;
import net.utility.UploadSaveManager;

@Controller
public class PmsListCont {
	
	public PmsListCont() {
		System.out.println("PmsListCont() 물품 리스트 ----------");
	}
	
	@Autowired
	PmsListDAO dao;
	
	@Autowired
	PmsNoticeDAO noticedao;
	
	@Autowired
	UseDAO usedao;
	
	//관리자 페이지 물품 리스트
	@RequestMapping(value = "/list/list.do", method = RequestMethod.GET)
	public ModelAndView list(PmsListDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/list");
		ArrayList<PmsListDTO> list = dao.list();
		mav.addObject("list", list);
		return mav;
	}
	
	//사용자 페이지에서 물품 검색
	@RequestMapping(value = "/list/searchproduct.do", method = RequestMethod.POST)
	public ModelAndView searchproduct(String keyword) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/list");
		ArrayList<PmsListDTO> list = dao.searchlist(keyword);
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value = "/list/searchproductajax.do", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public ArrayList<PmsListDTO> searchproductajax(String keyword) {
		System.out.println(keyword);
		ArrayList<PmsListDTO> list = dao.searchlist(keyword);
		return list;
	}
	
	//사용자 페이지에서 카테고리로 물품 검색
	@RequestMapping(value = "/list/searchcategory.do", method = RequestMethod.GET)
	public ModelAndView searchcategory(String category) {
		ModelAndView mav = new ModelAndView();
		System.out.println(category);
		mav.setViewName("user/list");
		ArrayList<PmsListDTO> list = dao.searchcategory(category);
		PmsNoticeDTO notice = noticedao.lastest();
		mav.addObject("list", list);
		mav.addObject("notice", notice);
		return mav;
	}
	
	//관리자 페이지 물품 상세보기
	@RequestMapping(value="/list/read.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView read(PmsListDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/goodsinform");
		PmsListDTO rs = dao.read(dto);
		mav.addObject("rs", rs);
		return mav;
	}
	
	/*@RequestMapping(value="/list/read.do", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public PmsListDTO read(PmsListDTO dto) {
		PmsListDTO rs = dao.read(dto);
		return rs;
	}*/
	
	
	//관리자 페이지에서 물품 등록
	@RequestMapping(value = "/list/createproduct.do", method = RequestMethod.POST)
	public ModelAndView createproduct(PmsListDTO dto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		System.out.println(dto.toString());
		
		String basePath = req.getRealPath("/admin/storage");
		MultipartFile posterMF = dto.getPosterMF();
		String poster = UploadSaveManager.saveFileSpring30(posterMF, basePath);
		dto.setPoster(poster);	
		 
		int rs = dao.createproduct(dto);
		mav.setViewName("redirect:/list/list.do");
		return mav;
	}
	
	//관리자 페이지에서 물품 정보 수정
	@RequestMapping(value = "/list/updateproduct.do", method = RequestMethod.POST)
	public ModelAndView updateproduct(PmsListDTO dto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		PmsListDTO oldDTO = dao.read(dto);
		System.out.println(dto.getUse_yn());
		System.out.println(oldDTO.getUse_yn());
		String basePath = req.getRealPath("/admin/storage");
		
		int upStock = dto.getStock()-oldDTO.getStock();		//변경 수량
		int product_id = dto.getProduct_id();
		int price = dto.getPrice();
		String brand = dto.getBrand();
		String product_location = dto.getProduct_location();
		String use_yn = dto.getUse_yn();
		
		// 물품 정보 수정 정보, 코드 insert
		if(upStock>0){
			dao.historyIns(0, upStock, product_id, price, brand, product_location);
		}
		else if(upStock<0) {
			dao.historyIns(1, upStock, product_id, price, brand, product_location);
		}
		else {
			if(price!=oldDTO.getPrice()) {
				dao.historyIns(2, dto.getStock(), product_id, price, brand, product_location);				
			}
			else if(!brand.equals(oldDTO.getBrand())) {
				dao.historyIns(3, dto.getStock(), product_id, price, brand, product_location);				
			}
			else if(!product_location.equals(oldDTO.getProduct_location())) {
				dao.historyIns(4, dto.getStock(), product_id, price, brand, product_location);				
			}
			else if(!use_yn.equals(oldDTO.getUse_yn())) {
				if(dto.getConsumable().equals("n")) {
					int stock=dto.getStock()+1;
					dao.historyIns(6, stock, product_id, price, brand, product_location);	
				}
			}
		}
		
	/*	if(dto.getPosterMF() != null) {
		String basePath = req.getRealPath("/admin/storage");
		MultipartFile posterMF = dto.getPosterMF();
		String poster = UploadSaveManager.saveFileSpring30(posterMF, basePath);
		dto.setPoster(poster);
		int rs = dao.updateproduct(dto);
		
		}
		
		if(dto.getPosterMF() == null) {
		int rs = dao.updateproduct2(dto);
		}*/
		
		//1)
		
	    MultipartFile posterMF = dto.getPosterMF();
	    if(posterMF.getSize()>0){ 
	     
	      UploadSaveManager.deleteFile(basePath, oldDTO.getPoster());
	      
	      String poster = UploadSaveManager.saveFileSpring30(posterMF, basePath);
	      dto.setPoster(poster);
	    }
	    else {
	      dto.setPoster(oldDTO.getPoster());
	    }
	    
	    if(!oldDTO.getUse_yn().equals(dto.getUse_yn()) && dto.getUse_yn().equals("y")) {
	    	int rs = dao.use_yn(dto);
	    }
	    
		int res = dao.updateproduct(dto);
		
		
		mav.setViewName("redirect:/list/list.do");
		return mav;
	}
	
	//관리자 페이지에서 물품 정보 삭제
	@RequestMapping(value = "/list/delete.do", method = RequestMethod.GET)
	public ModelAndView delete(PmsListDTO dto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		System.out.println(dto.toString());
		PmsListDTO oldDTO = dao.read(dto);
		String basePath = req.getRealPath("/admin/storage");
		MultipartFile posterMF = dto.getPosterMF();
		UploadSaveManager.deleteFile(basePath, oldDTO.getPoster());
		
		dao.productDel(dto);
		
		dao.historyIns(5, oldDTO.getStock(), oldDTO.getProduct_id(), oldDTO.getPrice(), oldDTO.getBrand(), oldDTO.getProduct_location());
		
		mav.setViewName("redirect:/list/list.do");
		return mav;
	}
	
	//사용자 페이지에서 물품 리스트 출력
		@RequestMapping(value = "/list/ulist.do", method = RequestMethod.GET)
		public ModelAndView ulist() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("user/list");
			ArrayList<PmsListDTO> list = dao.ulist();
			PmsNoticeDTO notice = noticedao.lastest();
			mav.addObject("list", list);
			mav.addObject("notice", notice);
			return mav;
		}
		
	//사용자 페이지에서 비품 사용시 입력 정보
		@RequestMapping(value = "/list/useproduct1.do", method = RequestMethod.POST)
		public ModelAndView useproduct1(String cal1, String cal2, String product_id, String use_reason1, String user_id) {
			ModelAndView mav = new ModelAndView();
			int id = Integer.parseInt(product_id);
			String time = cal1+" "+cal2+":00";
			Date date = new Date();
			try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
			}catch(Exception e) {
				System.out.println("변환오류");
			}
			System.out.println(cal1+" "+cal2+":00");
			System.out.println(use_reason1);
			System.out.println(user_id);
			int rs = dao.use1(id, date, user_id);
			
			usedao.use1Insert(id, user_id, use_reason1, date);
			dao.useyn(id);
			
			mav.setViewName("redirect:/list/ulist.do");
			return mav;
			
		}
		
		//물품 등록 페이지로 이동시키기
		@RequestMapping(value = "/list/goregistration.do")
		public ModelAndView goregistration() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("admin/registration");
			return mav;
		}
		
		//사용자 페이지에서 소모품 사용시 입력 정보
		@RequestMapping(value = "/list/useproduct2.do", method = RequestMethod.POST)
		public ModelAndView useproduct2(String product_id, String use_num, String use_reason, String user_id, String update_date) throws ParseException {
			ModelAndView mav = new ModelAndView();
			int id = Integer.parseInt(product_id);
			int num = Integer.parseInt(use_num);
			int rs = dao.use2(id, num, user_id);
			
			System.out.println(product_id+", "+update_date+", "+use_num+", "+use_reason+", "+user_id);
			if(rs==1) {
				usedao.use2Insert(id, user_id, use_reason, num);
			}
			mav.setViewName("redirect:/list/ulist.do");
			return mav;
		}

}
