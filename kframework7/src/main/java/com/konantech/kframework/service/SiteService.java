package com.konantech.kframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.konantech.kframework.dao.SiteDao;
import com.konantech.kframework.data.ParameterVO;
import com.konantech.kframework.data.ResultListVO;

/**
 * 사이트 검색하기 위한 서비스  
 * 
 * @modifier 안호빈(hobin.ahn)
 * @desc 소스간소화를 위하여 인터페이스는 삭제(다형성설계 안됨.)
 * @since 2016.06.30
 */
@Service("siteService")
public class SiteService {
	
	@Autowired
	private SiteDao siteDao;
	
	@Value("#{kframework['useRestFul']}") private boolean useRestFul;
	@Value("#{kframework['useBroker']}") private boolean useBroker;
	
	public ResultListVO search(ParameterVO paramVO) throws Exception {
		ResultListVO result;
		if( useRestFul == true) {
			result = siteDao.restSearch(paramVO);
			return result;
		} else if( useBroker == false) {
			result = siteDao.submitQuery(paramVO);
			return result;
		}else {
			result = siteDao.brokerQuery(paramVO);
			return result;
		}
		
	}
}
