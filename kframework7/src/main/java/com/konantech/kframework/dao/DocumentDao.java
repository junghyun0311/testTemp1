package com.konantech.kframework.dao;

import java.net.URLEncoder;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.konantech.kframework.common.CommonUtil;
import com.konantech.kframework.common.DCUtil;
import com.konantech.kframework.data.ResultListVO;
import com.konantech.kframework.data.SearchVO;
import com.konantech.kframework.data.ParameterVO;
import com.konantech.kframework.data.ResultListVO;
import com.konantech.kframework.module.RestModule;
import com.konantech.kframework.module.RestModuleExtend;
import com.konantech.kframework.module.SearchModule;
import com.konantech.klbrk.KlbrkModBrkSearch;

/**
 * DAO(Data Access Object)
 * 
 * @author 장진후(Jinhoo.Jang)
 * @team 기술지원팀(Technical Support)
 * @since 2013.08.27
 * @version 1.0
 * @modify 2018.06.07
 * @version 1.1
 * @modifier 안호빈(hobin.ahn)
 */
@Repository
public class DocumentDao {
	private static final Logger logger = LoggerFactory.getLogger(DocumentDao.class);
	
	
	@Autowired
	private SearchModule searchModule;	
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private DCUtil dcUtil;
	/** REST 모듈  (HTTPCLIENT 호출방식)*/
	@Autowired
	private RestModuleExtend restModuleExtend;
	
	@Value("#{kframework['engine.charsetType']}") private String charsetType;
	
	@Value("#{kframework['engine.url']}") private String engineUrl;
	
	@Value("#{kframework['documentHilight']}") private String documentHilight;
	
	
	/**
	 *  검색 RESTFUL DAO
	 * 
	 * @param kwd
	 * @throws IOException 
	 */
	public ResultListVO restSearch(ParameterVO param) throws Exception {
		ParameterVO paramVO = new ParameterVO();
		//param을  특정 카테고리에서만 set할 수 있기때문에 카피
		BeanUtils.copyProperties(param,paramVO);
		SearchVO searchVO = new SearchVO();
		
		String fileds = "*"; //검색 대상 필드
		String from = "document.document"; //검색 대상 볼륨,테이블
		
		// 쿼리 생성
		StringBuffer query = new StringBuffer();
		StringBuffer sbLog = new StringBuffer();
		String orderNm = "정확도순";	
		String orderBy = "";
		
		String strNmFd = "all".equals(paramVO.getSrchFd())? "text_idx": paramVO.getSrchFd();

		// 쿼리 부분
		query = dcUtil.makeQuery( strNmFd , paramVO.getKwd(), "allword", query, "AND");	
		//결과내재검색
		if( paramVO.getReSrchFlag() ){
			int preCnt = paramVO.getPreviousQueries().length;
			query.append(" AND  ")
					.append(dcUtil.makePreQuery(strNmFd , paramVO.getKwd(), paramVO.getPreviousQueries(), preCnt ,"allword") );		        
		}


		// 작성자 검색
		if (!"".equals(paramVO.getWriter())) {
			query.append(" AND writer = '");
			query.append(paramVO.getWriter());
			query.append("'");
		}
		
		// 파일 검색(필터)
		if (!"".equals(paramVO.getFileExt()) && !"all".equals(paramVO.getFileExt())) {
			String ext[] = paramVO.getFileExt().split("_");
			
			query.append(" AND  fileext in {");
			for (int i = 0; i < ext.length; i++) {
				if (i > 0)
					query.append(",");
				
				query.append("'" + ext[i] + "'");	
			}
			query.append("}");
		}
		/**
		 * 날짜검색기간 조회
		 * 기간/일/월/년도, 구간검색으로 조회시 자바스크립트에서 시작날짜와 종료날짜 조회하여 전달함.
		 */
		if (!paramVO.getStartDate().isEmpty() && !paramVO.getEndDate().isEmpty()){
			query = dcUtil.makeRangeQuery("regdate", paramVO.getStartDate().replace(".", "")+"000000", paramVO.getEndDate().replace(".", "")+"999999", query) ;
		}
		
		//정렬조건	
		if ("d".equals(paramVO.getSort())){
			query.append(" order by regdate desc");
		}else {
			query.append(" order by $relevance desc");
		}
		
		//로그기록 
		//SITE@인물+$|첫검색|1|정확도순^코난	
		sbLog.append(  dcUtil.getLogInfo(commonUtil.null2Str(paramVO.getSiteNm(),"SITE"),
				paramVO.getCategory() ,
				commonUtil.null2Str( paramVO.getUserId(),""), 
				paramVO.getKwd(),
				paramVO.getPageNum(),
				false,
				orderNm,
				commonUtil.null2Str(paramVO.getRecKwd(),"")));
	
		searchVO.setUrl(engineUrl);
		searchVO.setCharset(charsetType);
		searchVO.setFields_rest(fileds);
		searchVO.setFrom(from);
		searchVO.setHilightFileds(URLEncoder.encode(documentHilight, "UTF-8"));
		searchVO.setHilightTxt(URLEncoder.encode(paramVO.getHilightKwd(), "UTF-8"));
		searchVO.setQuery(URLEncoder.encode(query.toString(), "UTF-8"));
		searchVO.setLogInfo(URLEncoder.encode(sbLog.toString(), "UTF-8"));
		//동의어 설정시 수행
		//searchVO.setSynDomainNo("0");
		//default-hilight 설정시 
		//searchVO.setDefaultHilight("off");
		
		// restful URL 생성
		String restUrl = dcUtil.getRestURL(paramVO, searchVO);
		
		logger.debug(logger.getName()+" , "+"RESTURL : " + restUrl);
		
		ResultListVO restVO = new ResultListVO();
		boolean success = restModuleExtend.restSearch_hc(restUrl, restVO);
		
		//초기화
		query.charAt(0);
		sbLog.charAt(0);
		
		if(!success) 
			return null;
				
		return restVO;		
	}
	
	/**
	 * 게시판 검색 시나리오방식 DAO
	 * 
	 * @param params
	 * 
	 * @return ResultListVO
	 * @throws Exception
	 */
	public ResultListVO submitQuery(ParameterVO param) throws Exception {
		ParameterVO paramVO = new ParameterVO();
		//param을  특정 카테고리에서만 set할 수 있기때문에 카피
		BeanUtils.copyProperties(param,paramVO);
		SearchVO search = new SearchVO();
		// 쿼리 생성
		StringBuffer query = new StringBuffer();
		StringBuffer sbLog = new StringBuffer();
		String orderNm = "정확도순";	
		String orderBy = "";
		
		String strNmFd = "all".equals(paramVO.getSrchFd())? "text_idx": paramVO.getSrchFd();

		// 쿼리 부분
		query = dcUtil.makeQuery( strNmFd , paramVO.getKwd(), "allword", query, "AND");	
		//결과내재검색
		if( paramVO.getReSrchFlag() ){
			int preCnt = paramVO.getPreviousQueries().length;
			query.append(" AND  ")
					.append(dcUtil.makePreQuery(strNmFd , paramVO.getKwd(), paramVO.getPreviousQueries(), preCnt ,"allword") );		        
		}
		// 작성자 검색
		if (!"".equals(paramVO.getWriter())) {
			query.append(" AND writer = '");
			query.append(paramVO.getWriter());
			query.append("'");
		}
		
		// 파일 검색(필터)
		if (!"".equals(paramVO.getFileExt()) && !"all".equals(paramVO.getFileExt())) {
			String ext[] = paramVO.getFileExt().split("_");
			
			query.append(" AND  fileext in {");
			for (int i = 0; i < ext.length; i++) {
				if (i > 0)
					query.append(",");
				
				query.append("'" + ext[i] + "'");	
			}
			query.append("}");
		}
		/**
		 * 날짜검색기간 조회
		 * 기간/일/월/년도, 구간검색으로 조회시 자바스크립트에서 시작날짜와 종료날짜 조회하여 전달함.
		 */
		if (!paramVO.getStartDate().isEmpty() && !paramVO.getEndDate().isEmpty()){
			query = dcUtil.makeRangeQuery("regdate", paramVO.getStartDate().replace(".", "")+"000000", paramVO.getEndDate().replace(".", "")+"999999", query) ;
		}
		
		//정렬조건	
		if ("d".equals(paramVO.getSort())){
			orderNm = "날짜순";
			orderBy = "order by regdate desc";
		}else {
			orderBy = "order by $relevance desc";
		}
		
		//로그기록 
		//SITE@인물+$|첫검색|1|정확도순^코난	
		sbLog.append(  dcUtil.getLogInfo(commonUtil.null2Str(paramVO.getSiteNm(),"SITE"),
				paramVO.getCategory() ,
				commonUtil.null2Str( paramVO.getUserId(),""), 
				paramVO.getKwd(),
				paramVO.getPageNum(),
				false,
				orderNm,
				commonUtil.null2Str(paramVO.getRecKwd(),"")));
		
			
		search.setOrderBy(orderBy);		
		search.setLogInfo(sbLog.toString());
		search.setHilightTxt(paramVO.getHilightKwd());
		search.setQuery(query.toString());
		search.setScenario("document");
		
		logger.debug(logger.getName()+" , "+" QUERY : " + search.getQuery() + " " + search.getOrderBy());
		
		return searchModule.dcSubmitQuery(paramVO, search);
	}
	
	
	/**
	 * 게시판(브로커-시나리오방식) 검색 DAO
	 * 
	 * @param params
	 * 
	 * @return KlbrkModBrkSearch
	 * @throws Exception
	 */
	public ResultListVO brokerQuery(ParameterVO param) throws Exception {
		ParameterVO paramVO = new ParameterVO();
		//param을  특정 카테고리에서만 set할 수 있기때문에 카피
		BeanUtils.copyProperties(param,paramVO);
		SearchVO search = new SearchVO();
		// 쿼리 생성
		StringBuffer query = new StringBuffer();
		StringBuffer sbLog = new StringBuffer();
		
		String orderNm = "정확도순";	
		String orderBy = "";
		
		String strNmFd = "all".equals(paramVO.getSrchFd())? "text_idx": paramVO.getSrchFd();

		// 쿼리 부분
		query = dcUtil.makeQuery( strNmFd , paramVO.getKwd(), "allword", query, "AND");	
		//결과내재검색
		if( paramVO.getReSrchFlag() ){
			int preCnt = paramVO.getPreviousQueries().length;
			query.append(" AND  ")
					.append(dcUtil.makePreQuery(strNmFd , paramVO.getKwd(), paramVO.getPreviousQueries(), preCnt ,"allword") );		        
		}
		
		// 작성자 검색
		if (!"".equals(paramVO.getWriter())) {
			query.append(" AND writer = '");
			query.append(paramVO.getWriter());
			query.append("'");
		}
		
		// 파일 검색(필터)
		if (!"".equals(paramVO.getFileExt()) && !"all".equals(paramVO.getFileExt())) {
			String ext[] = paramVO.getFileExt().split("_");
			
			query.append(" AND  fileext in {");
			for (int i = 0; i < ext.length; i++) {
				if (i > 0)
					query.append(",");
				
				query.append("'" + ext[i] + "'");	
			}
			query.append("}");
		}
		/**
		 * 날짜검색기간 조회
		 * 기간/일/월/년도, 구간검색으로 조회시 자바스크립트에서 시작날짜와 종료날짜 조회하여 전달함.
		 */
		if (!paramVO.getStartDate().isEmpty() && !paramVO.getEndDate().isEmpty()){
			query = dcUtil.makeRangeQuery("regdate", paramVO.getStartDate().replace(".", "")+"000000", paramVO.getEndDate().replace(".", "")+"999999", query) ;
		}
		
		//정렬조건	
		if ("d".equals(paramVO.getSort())){
			orderNm = "날짜순";
			orderBy = "order by regdate desc";
		}else {
			orderBy = "order by $relevance desc";
		}
		
		//로그기록 
		//SITE@인물+$|첫검색|1|정확도순^코난	
		sbLog.append(  dcUtil.getLogInfo(commonUtil.null2Str(paramVO.getSiteNm(),"SITE"),
				paramVO.getCategory() ,
				commonUtil.null2Str( paramVO.getUserId(),""), 
				paramVO.getKwd(),
				paramVO.getPageNum(),
				false,
				orderNm,
				commonUtil.null2Str(paramVO.getRecKwd(),"")));
		
		search.setOrderBy(orderBy);		
		search.setLogInfo(sbLog.toString());
		search.setHilightTxt(paramVO.getHilightKwd());
		search.setQuery(query.toString());
		search.setScenario("document1:document");
		
		logger.debug(logger.getName()+" , "+" QUERY : " + search.getQuery() + " " + search.getOrderBy());
		return searchModule.dcBrokerQuery(paramVO, search);		
	}
}
