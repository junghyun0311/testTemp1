package com.konantech.kframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.konantech.kframework.dao.BoardDao;
import com.konantech.kframework.data.ParameterVO;
import com.konantech.kframework.data.ResultListVO;

/**
 * 게시판 검색하기 위한 서비스  
 * 
 * @modifier 안호빈(hobin.ahn)
 * @desc 소스간소화를 위하여 인터페이스는 삭제(다형성설계 안됨.)
 * @since 2016.06.30
 */
@Service("boardService")
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	@Value("#{kframework['useRestFul']}") private boolean useRestFul;
	@Value("#{kframework['useBroker']}") private boolean useBroker;
	
	public ResultListVO search(ParameterVO paramVO) throws Exception {
		ResultListVO result;
		if( useRestFul == true) {
			result = boardDao.restSearch(paramVO);
			return result;
		} else if( useBroker == false) {
			result = boardDao.submitQuery(paramVO);
			return result;
		}else {
			result = boardDao.brokerQuery(paramVO);
			return result;
		}
		
	}
}
