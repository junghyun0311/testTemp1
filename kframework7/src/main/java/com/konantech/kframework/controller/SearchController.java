package com.konantech.kframework.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.konantech.kframework.common.CommonUtil;
import com.konantech.kframework.common.SetParameter;
import com.konantech.kframework.data.ParameterVO;
import com.konantech.kframework.data.ResultListVO;
import com.konantech.kframework.service.BoardService;
import com.konantech.kframework.service.DocumentService;
import com.konantech.kframework.service.PersonService;
import com.konantech.kframework.service.RestService;
import com.konantech.kframework.service.SiteService;

/**
 * 검색 컨트롤러
 * 
 * @author 장진후(Jinhoo.Jang)
 * @team 기술지원팀(Technical Support)
 * @since 2013.06.20
 * @version 1.0
 */
@Controller
public class SearchController {	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Value("#{kframework['ppk.maxResult']}") private int ppkMaxResult;
	@Value("#{kframework['ppk.domainNo']}") private int ppkDomainNo;
	@Value("#{kframework['kre.maxResult']}") private int kreMaxResult;
	@Value("#{kframework['kre.domainNo']}") private int kreDomainNo;
	@Value("#{kframework['akc.maxResult']}") private int akcMaxResult;
	@Value("#{kframework['akc.domainNo']}") private int akcDomainNo;
	
	@Autowired
	private SetParameter setParameter;
	@Autowired
	private CommonUtil common;
	
	@Autowired
	private RestService restService;
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private PersonService personService;
	@Autowired
	private DocumentService documentService;
	@Autowired
	private SiteService siteService;
	
	/**
	 * 통합검색 페이지 처리 메소드
	 * 
	 * @throws Exception 
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam Map<String, String> map, Model model, HttpSession session) throws Exception {
		// Setting Parameter
		ParameterVO params = setParameter.setParameter(map);
						
		// Setting Model
		setCategoryModel(model,params);
			
		// Setting Filter
		//setFilterModel(model,params);
		
		model.addAttribute("params", params);		
		
		return "search";
	}
	
	/**
	 * 통합검색 페이지 처리 메소드
	 * 
	 * @throws Exception 
	 */
	@RequestMapping(value = "/search_ksf", method = RequestMethod.GET)
	public String search_ksf(@RequestParam Map<String, String> map, Model model, HttpSession session) throws Exception {
		// Setting Parameter
		ParameterVO params = setParameter.setParameter(map);
						
		// Setting Model
		setCategoryModel(model,params);
			
		// Setting Filter
		//setFilterModel(model,params);
		
		//인기검색어
		List<HashMap<String, String>> ppkList = restService.getPopularKwd_hc(ppkDomainNo, ppkMaxResult);
		model.addAttribute("ppkTotal", ppkList.size());
		model.addAttribute("ppkList", ppkList);	
		
		//추천어
		String[] kreList = restService.getKre_hc(kreDomainNo, kreMaxResult, params.getKwd());

		
		if(kreList != null) {
			model.addAttribute("kreTotal", kreList.length);
			model.addAttribute("kreList", kreList);	
		} else {
			model.addAttribute("kreTotal", 0);
		}
		
		model.addAttribute("params", params);		
		
		return "search_ksf";
	}
	
	/**
	 * Konan Open API 콘트롤러(JSON)
	 * 
	 * @param map
	 * @param model
	 * @return
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/openapi/search", method = RequestMethod.GET)
	public String api(@RequestParam Map<String, String> map, Model model) throws Exception {
		// Setting Parameter
		ParameterVO params = setParameter.setParameter(map);
		
		model.addAttribute("params", params);
		
		setCategoryModel(model,params);
		
		return "jsonView";
	}
	
	/**
	 * 모델 세팅 부분을 분리
	 * 
	 * @return Model
	 * 
	 * @throws Exception
	 */
	private Model setCategoryModel(Model model, ParameterVO params) throws Exception {
		ResultListVO result;
		int total = 0;
		
		// 카테고리 여부
		if(!params.getKwd().equals("")) {
			// 게시판
			if (common.easyChkEqual("TOTAL,BOARD", params.getCategory(), ",", false)) {
				result = boardService.search(params);
				total += result.getTotal();
				
				model.addAttribute("boardRow", result.getRows());
				model.addAttribute("boardList", result.getResult());
				model.addAttribute("boardTotal", result.getTotal());
				model.addAttribute("boardPageRange", 
						common.getPageRange(params.getPageNum(), params.getPageSize(), result.getTotal()));
			}
			// 인물
			if (common.easyChkEqual("TOTAL,PERSON", params.getCategory(), ",", false)) {
				result = personService.search(params);
				total += result.getTotal();
				
				model.addAttribute("personRow", result.getRows());
				model.addAttribute("personList", result.getResult());
				model.addAttribute("personTotal", result.getTotal());
				model.addAttribute("personPageRange", 
						common.getPageRange(params.getPageNum(), params.getPageSize(), result.getTotal()));
			}
			// 문서
			if (common.easyChkEqual("TOTAL,DOCUMENT", params.getCategory(), ",", false)) {
				result = documentService.search(params);
				total += result.getTotal();
				
				model.addAttribute("documentRow", result.getRows());
				model.addAttribute("documentList", result.getResult());
				model.addAttribute("documentTotal", result.getTotal());
				model.addAttribute("documentPageRange", 
						common.getPageRange(params.getPageNum(), params.getPageSize(), result.getTotal()));
			}
			// 사이트
			if (common.easyChkEqual("TOTAL,SITE", params.getCategory(), ",", false)) {
				result = siteService.search(params);
				total += result.getTotal();
				
				model.addAttribute("siteRow", result.getRows());
				model.addAttribute("siteList", result.getResult());
				model.addAttribute("siteTotal", result.getTotal());
				model.addAttribute("sitePageRange", 
						common.getPageRange(params.getPageNum(), params.getPageSize(), result.getTotal()));
			}
		}
		
		model.addAttribute("formatTotal", common.formatMoney(total));
		model.addAttribute("total", total);
		
		return model;
	}
	
	
}