package com.konantech.kframework.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konantech.kframework.common.CommonUtil;
import com.konantech.kframework.common.DCUtil;
import com.konantech.kframework.module.RestModule;
import com.konantech.kframework.module.RestModuleExtend;



/**
 * restful API를 호출하기 위한 클래스
 * 
 * @author jinhoo.jang
 * @since 2016.04.08
 * @modify 2018.06.07
 * @modifier 안호빈(hobin.ahn)
 * @desc 소스간소화를 위하여 인터페이스는 삭제(다형성 설계 하지않음.)
 */
@Service("restService")
public class RestService {
	
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private DCUtil dcUtil;
	
	/** REST 모듈  (HTTPCLIENT 호출방식 포함)*/
	@Autowired
	private RestModuleExtend restModuleExtend;
	/**
	 * REST 방식으로 엔진 검색 호출(파라미터 전달 방식)
	 * @version 1.1
	 * @modify 2018.06.07
	 * @modifier 안호빈(hobin.ahn)
	 * @return JSON
	 * @throws Exception 
	 */
	public String getSearchApi(String param) {
		return restModuleExtend.getSearchApi(param);
	}
	
	/**
	 * REST 방식으로 엔진 검색 호출(파라미터 전달 방식) GET (HTTPCLIENT 호출방식)
	 * @version 1.1
	 * @modify 2018.06.07
	 * @modifier 안호빈(hobin.ahn)
	 * @return JSON
	 * @throws Exception 
	 */
	public String getSearchApi_hc(String param) {
		return restModuleExtend.getSearchApi_hc(param);
	}
	
	/**
	 * REST 방식으로 엔진 검색 호출(파라미터 전달 방식) POST (HTTPCLIENT 호출방식)
	 * @version 1.1
	 * @modify 2018.06.07
	 * @modifier 안호빈(hobin.ahn)
	 * @return JSON
	 * @throws Exception 
	 */
	public String getSearchApi_hc_post(String param) {
		return restModuleExtend.getSearchApi_hc_post(param);
	}
	
	/**
	 * KSF 방식으로 인기검색어를 가져온다.(리턴값 map)
	 *  
	 * @return map
	 */
	public List<HashMap<String, String>> getPopularKwd(int domainNo, int maxResult) {
		return restModuleExtend.getPopularKwd(domainNo,maxResult);
	}
	
	/**
	 * KSF 방식으로 인기검색어를 가져온다.(리턴값 map) (HTTPCLIENT 호출방식)
	 *  
	 * @return map
	 */
	public List<HashMap<String, String>> getPopularKwd_hc(int domainNo, int maxResult) {
		return restModuleExtend.getPopularKwd_hc(domainNo,maxResult);
	}
	
	/**
	 * KSF 방식으로 인기검색어를 가져온다.(리턴값  JSON)
	 *  
	 * @return json
	 */
	public String getPopularKwdApi(String param) {
		return restModuleExtend.getPopularKwdApi(param); 
	}
	
	/**
	 * KSF 방식으로 인기검색어를 가져온다.(리턴값  JSON) (HTTPCLIENT 호출방식)
	 *  
	 * @return json
	 */
	public String getPopularKwdApi_hc(String param) {
		return restModuleExtend.getPopularKwdApi_hc(param); 
	}
	
	
	/**
	 * KSF 방식으로 자동완성검색어 (리턴값 배열)
	 * suggest?target=complete
	 *  
	 * @return String[]
	 */
	public String[]  getAutocomplete(int domainNo, int maxResult, String kwd, String mode) {
		return restModuleExtend.getAutocomplete(domainNo,maxResult,kwd,mode);
	}
	
	/**
	 * KSF 방식으로 자동완성검색어 (리턴값 배열) (HTTPCLIENT 호출방식)
	 * suggest?target=complete
	 *  
	 * @return String[]
	 */
	public String[]  getAutocomplete_hc(int domainNo, int maxResult, String kwd, String mode) {
		return restModuleExtend.getAutocomplete_hc(domainNo,maxResult,kwd,mode);
	}
	
	
	/**
	 * KSF 방식으로 추천어 (리턴값 배열)
	 * suggest?target=related
	 *  
	 * @return String[]
	 */
	public String[]  getKre(int domainNo, int maxResult, String kwd) {
		return restModuleExtend.getKre(domainNo, maxResult, kwd);
	}
	
	/**
	 * KSF 방식으로 추천어 (리턴값 배열)(HTTPCLIENT 호출방식)
	 * suggest?target=related
	 *  
	 * @return String[]
	 */
	public String[]  getKre_hc(int domainNo, int maxResult, String kwd) {
		return restModuleExtend.getKre_hc(domainNo, maxResult, kwd);
	}
	
	
	/**
	 * KSF 방식으로 자동완성, 추천어, 오타교정 (리턴값  JSON) 
	 * suggest?target=complete
	 *  
	 * @return json
	 */
	public String getSuggestApi(String param) {
		return restModuleExtend.getSuggestApi(param);
	}
	
	/**
	 * KSF 방식으로 자동완성, 추천어, 오타교정 (리턴값  JSON) (HTTPCLIENT 호출방식)
	 * suggest?target=complete
	 *  
	 * @return json
	 */
	public String getSuggestApi_hc(String param) {
		return restModuleExtend.getSuggestApi_hc(param);
	}
	
	/**
	 * KSF 방식으로 금칙어를 가져온다.(리턴값  JSON)
	 *  
	 * @return json
	 */
	public String getCensoredApi(String param) {
		return restModuleExtend.getCensoredApi(param);
	}
	
	/**
	 * KSF 방식으로 금칙어를 가져온다.(리턴값  JSON) (HTTPCLIENT 호출방식)
	 *  
	 * @return json
	 */
	public String getCensoredApi_hc(String param) {
		return restModuleExtend.getCensoredApi_hc(param);
	}
	
	
	/**
	 * KA 주요 이슈어
	 * /ksm/tma/issueword?from=news.seoul&issuefd=issue_kwd&where=created_ymd>%3D20161001+and+created_ymd<%3d20161031
	 *  
	 * @return json
	 */
	public String getIssuewordApi(String param) {
		return restModuleExtend.getIssuewordApi(param);
	}
	
	/**
	 * KA 주요 이슈어 (HTTPCLIENT 호출방식)
	 * /ksm/tma/issueword?from=news.seoul&issuefd=issue_kwd&where=created_ymd>%3D20161001+and+created_ymd<%3d20161031
	 *  
	 * @return json
	 */
	public String getIssuewordApi_hc(String param) {
		return restModuleExtend.getIssuewordApi_hc(param);
	}
	
	/**
	 * KA 주요 연관어
	 * /ksm/tma/relatedword?from=news.seoul&issuefd=issue_kwd&issuewd=서울
	 *  
	 * @return json
	 */
	public String getRelatedwordApi(String param) {
		return restModuleExtend.getRelatedwordApi(param);
	}
	
	/**
	 * KA 주요 연관어 (HTTPCLIENT 호출방식)
	 * /ksm/tma/relatedword?from=news.seoul&issuefd=issue_kwd&issuewd=서울
	 *  
	 * @return json
	 */
	public String getRelatedwordApi_hc(String param) {
		return restModuleExtend.getRelatedwordApi_hc(param);
	}
	
}
