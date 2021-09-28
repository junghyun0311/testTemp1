package com.konantech.kframework.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.konantech.kframework.common.CommonUtil;
import com.konantech.kframework.service.RestService;
/**
 * @Class Name : ApiController.java
 * @Description : Search RESTFUL API , KSF RESTFUL API Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016.09.07  		         최초생성
 *
 * @author 코난테크놀로지 기술서비스팀 안호빈
 * @since 2016. 09.07
 * @version 1.0
 *
 *  Copyright (C) by KONANTECH All right reserved.
 */

@Controller
public class ApiController {
	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
	
	/** REST 서비스 */
	@Autowired
	private RestService restService;
	@Autowired
	private CommonUtil common;
	
	//검색엔진 restful API와 똑같이 구동
	@RequestMapping(value = "/searchJson", produces = "text/json; charset=utf8")
	@ResponseBody
	public String searchJson(@RequestParam Map<String, String> map,HttpServletRequest request,HttpServletResponse response,HttpSession session)  {
		// 파라미터 세팅
		String param = "";
		Enumeration params = request.getParameterNames();
		int i=0;
		while (params.hasMoreElements()){
			if(i==0){
				param+="?";
			}else{
				param+="&";
			}
		    String name = (String)params.nextElement();
		    String value = request.getParameter(name);
	    	try {
				value =  URLEncoder.encode(request.getParameter(name), "utf-8");
			} catch (UnsupportedEncodingException e) {
				logger.error("ERROR: "+logger.getName() +" UnsupportedEncodingException");
			}
		    param+=name+"="+value;
		    i++;
		}
		//httpclient 방식으로 호출
		String result = restService.getSearchApi_hc(param);
		//urlconnection 방식
		//String result = restService.getSearchApi(param);
		return result;
	}
	
	//검색엔진 restful API와 똑같이 구동
	@RequestMapping(value = "/searchJson_post", produces = "text/json; charset=utf8")
	@ResponseBody
	public String searchJson_hc_post(@RequestParam Map<String, String> map,HttpServletRequest request,HttpServletResponse response,HttpSession session)  {
		// 파라미터 세팅
		String param = "";
		Enumeration params = request.getParameterNames();
		int i=0;
		while (params.hasMoreElements()){
			if(i==0){
				param+="";
			}else{
				param+="&";
			}
		    String name = (String)params.nextElement();
		    String value = request.getParameter(name);
	    	try {
				value =  URLEncoder.encode(request.getParameter(name), "utf-8");
			} catch (UnsupportedEncodingException e) {
				logger.error("ERROR: "+logger.getName() +" UnsupportedEncodingException");
			}
		    param+=name+"="+value;
		    i++;
		}
		//httpclient 방식으로 호출
		String result = restService.getSearchApi_hc_post(param);
		return result;
	}
	
	//KSF restful API와 똑같이 구동(인기검색어)
	@RequestMapping(value = "/ksf/api/rankings", produces = "text/json; charset=utf8")
	@ResponseBody
	public String rankings(@RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)  {
		// 파라미터 세팅
		String param = "";
		Enumeration params = request.getParameterNames();
		int i=0;
		while (params.hasMoreElements()){
			if(i==0){
				param+="?";
			}else{
				param+="&";
			}
		    String name = (String)params.nextElement();
		    param+=name+"="+request.getParameter(name);
		    i++;
		}
		//httpclient 방식으로 호출
		String result = restService.getPopularKwdApi_hc(param);
		//urlconnection 방식
		//String result = restService.getPopularKwdApi(param);
		return result;
	}
	
	//KSF restful API와 똑같이 구동(자동완성,오타교정,추천어)
	@RequestMapping(value = "/ksf/api/suggest", produces = "text/json; charset=utf8")
	@ResponseBody
	public String suggest(@RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)  {
		// 파라미터 세팅
		String param = "";
		Enumeration params = request.getParameterNames();
		int i=0;
		while (params.hasMoreElements()){
			if(i==0){
				param+="?";
			}else{
				param+="&";
			}
		    String name = (String)params.nextElement();
		    String value = request.getParameter(name);
		    if("term".equals(name)){
		    	try {
					value =  URLEncoder.encode(request.getParameter(name), "utf-8");
				} catch (UnsupportedEncodingException e) {
					logger.error("ERROR: "+logger.getName() +" UnsupportedEncodingException");
				}
		    }
		    param+=name+"="+value;
		    i++;
		}
		//httpclient 방식으로 호출
		String result = restService.getSuggestApi_hc(param);
		//urlconnection 방식
		//String result = restService.getSuggestApi(param);
		return result;
	}
	
	//KSF restful API와 똑같이 구동(금칙어)
	@RequestMapping(value = "/ksf/api/censored", produces = "text/json; charset=utf8")
	@ResponseBody
	public String censored(@RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)  {
		// 파라미터 세팅
		String param = "";
		Enumeration params = request.getParameterNames();
		int i=0;
		while (params.hasMoreElements()){
			if(i==0){
				param+="?";
			}else{
				param+="&";
			}
		    String name = (String)params.nextElement();
		    String value = request.getParameter(name);
		    if("term".equals(name)){
		    	try {
					value =  URLEncoder.encode(request.getParameter(name), "utf-8");
				} catch (UnsupportedEncodingException e) {
					logger.error("ERROR: "+logger.getName() +" UnsupportedEncodingException");
				}
		    }
		    param+=name+"="+value;
		    i++;
		}
		//httpclient 방식으로 호출
		String result = restService.getCensoredApi_hc(param);
		//urlconnection 방식
		//String result = restService.getCensoredApi(param);
		return result;
	}
	
	//KA API와 똑같이 구동(주요이슈어)
	@RequestMapping(value = "/ksm/tma/issueword", produces = "text/json; charset=utf8")
	@ResponseBody
	public String issueword(@RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)  {
		// 파라미터 세팅
		String param = "";
		Enumeration params = request.getParameterNames();
		int i=0;
		try {
		while (params.hasMoreElements()){
			if(i==0){
				param+="?";
			}else{
				param+="&";
			}
		    String name = (String)params.nextElement();
		    String value ="";
		    if("where".equals(name)){
		    	value=request.getParameter(name).replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&apos;", "'");
				value=URLEncoder.encode(value, "utf-8");
		    }
		    else if("issuewd".equals(name)){
		    	value=URLEncoder.encode(request.getParameter(name), "utf-8");
		    }else{
		    	value=request.getParameter(name);
		    }
		    param+=name+"="+value;
		    i++;
		}
		} catch (UnsupportedEncodingException e) {
			logger.error("ERROR: "+logger.getName() +" UnsupportedEncodingException");
		}
		String result="";
		//httpclient 방식으로 호출
		result = restService.getIssuewordApi_hc(param);
		//urlconnection 방식
		//String result = restService.getIssuewordApi(param);
		return result;
	}
	
	//KA restpul API와 똑같이 구동(주요연관어)
	@RequestMapping(value = "/ksm/tma/relatedword", produces = "text/json; charset=utf8")
	@ResponseBody
	public String relatedword(@RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)  {
		// 파라미터 세팅
		String param = "";
		Enumeration params = request.getParameterNames();
		int i=0;
		try {
		while (params.hasMoreElements()){
			if(i==0){
				param+="?";
			}else{
				param+="&";
			}
			String name = (String)params.nextElement();
		    String value ="";
		    if("where".equals(name)){
		    	value=request.getParameter(name).replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&apos;", "'");
				value=URLEncoder.encode(value, "utf-8");
		    }
		    else if("issuewd".equals(name)){
		    	value=URLEncoder.encode(request.getParameter(name), "utf-8");
		    }else{
		    	value=request.getParameter(name);
		    }
		    param+=name+"="+value;
		    i++;
		}
		} catch (UnsupportedEncodingException e) {
			logger.error("ERROR: "+logger.getName() +" UnsupportedEncodingException");
		}
		//httpclient 방식으로 호출
		String result = restService.getRelatedwordApi_hc(param);
		//urlconnection 방식
		//String result = restService.getRelatedwordApi(param);
		return result;
	}
	
}
