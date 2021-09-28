package com.konantech.kframework.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.konantech.kframework.service.AddOnService;

/** 
 * AddOn Controller (ks5에서는 사용할 수 없음)
 * 
 * @author Jinhoo.Jang
 * @since 2013.08.09
 * @version 1.0
 * Copyright ⓒ Konan Technology. All Right Reserved
 * ==================================================
 */
@Controller
public class AddOnController {	
	private static final Logger logger = LoggerFactory.getLogger(AddOnController.class);
	@Value("#{kframework['ppk.maxResult']}") private int ppkMaxResult;
	@Value("#{kframework['ppk.domainNo']}") private int ppkDomainNo;
	@Value("#{kframework['kre.maxResult']}") private int kreMaxResult;
	@Value("#{kframework['kre.domainNo']}") private int kreDomainNo;
	@Value("#{kframework['akc.maxResult']}") private int akcMaxResult;
	@Value("#{kframework['akc.domainNo']}") private int akcDomainNo;
	
	@Autowired
	private AddOnService addOnService;
	
	@RequestMapping(value = "/addon/ppk", method = RequestMethod.GET)
	public String getPopularKwd(@RequestParam Map<String, String> map, Model model) throws Exception {
		List<HashMap<String, String>> ppkList = addOnService.getPopularKwd(ppkMaxResult, ppkDomainNo);
		
		model.addAttribute("ppkTotal", ppkList.size());
		model.addAttribute("ppkList", ppkList);
		
		return "addon/ppk";
	}
	
	@RequestMapping(value = "/addon/kre", method = RequestMethod.GET)
	public String getRecommandKwd(@RequestParam Map<String, String> map, Model model) throws Exception {
		if(StringUtils.isNotEmpty(map.get("kwd")) && map.get("kwd").length() > 0) {
			String kwd = map.get("kwd");
			
			logger.debug("kre keyword : " + kwd);
			
			String[] kreList = addOnService.getRecommandKwd(kwd, kreMaxResult, kreDomainNo);
	
			if(kreList != null) {
				
				model.addAttribute("kreTotal", kreList.length);
				model.addAttribute("kreList", kreList);	
			} else {
				model.addAttribute("kreTotal", 0);
			}
		} else {
			model.addAttribute("kreTotal", 0);
		}
		
		return "addon/kre";
	}
	
	@RequestMapping(value = "/addon/akc")
	public String getCompleteKwd(@RequestParam Map<String, String> map, Model model) throws Exception {
		if(StringUtils.isNotEmpty(map.get("kwd")) && map.get("kwd").length() > 0) {
			String kwd = map.get("kwd");
			int flag = Integer.parseInt(map.get("opt"));
			
			List<HashMap<String, String>> akcList = addOnService.getCompleteKwd(kwd, akcMaxResult, flag, akcDomainNo);
			
			if(akcList != null) {
				model.addAttribute("akcTotal", akcList.size());
				model.addAttribute("akcList", akcList);				
			}
		}
		return "jsonView";
	}
}
