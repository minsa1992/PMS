package co.kr.pms.history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.kr.pms.list.PmsListDAO;
import co.kr.pms.list.PmsListDTO;


@Controller
@RequestMapping("/admin/")
public class HistoryCont {
	
	@Autowired
	HistoryDAO dao;

	@Autowired
	PmsListDAO pmsdao;
	
	/**
	 * 히스토리 목록 페이지
	 */
	@RequestMapping(value="history.do", method=RequestMethod.GET)
	public String historylist(Model model, PmsListDTO pmsdto, HistoryDTO dto) {
		
		List<HistoryDTO> historyList = dao.historyList();
		model.addAttribute("historyList",historyList);

		return "admin/history"; //history.jsp
	}
	
}