package com.konantech.kframework.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konantech.kframework.module.AddOnModule;
import com.konantech.kframework.module.KonanException;

@Service("addOnService")
public class AddOnService {
	@Autowired
	private AddOnModule addOnModule;	

	/**
	 * 인기검색어 Service
	 * 
	 * @param maxResultCount
	 * @param domainNo
	 * @return
	 * @throws IOException
	 * @throws KonanException
	 * @throws Exception
	 */
	public List<HashMap<String, String>>getPopularKwd(int maxResultCount, int domainNo) throws IOException, KonanException, Exception {
		String[][] arrResult = addOnModule.getPopularKwd(maxResultCount, domainNo);
		
		List<HashMap<String, String>> ppkList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map;
		String ladderMark = "";
		String ladderCssClass = "";
		String tag = "";
		
		// Convert Array to ArrayList<HashMap<String, String>>
        for(int i=0; i<arrResult[0].length; i++) {
        	map = new HashMap<String, String>();
        	map.put("keyword", arrResult[0][i]);
        	tag = arrResult[1][i];
        	        	
        	// 진입, 유지 로직을 적는다.
        	if(arrResult[1][i].equalsIgnoreCase("new")) {
				ladderMark = "진입";
				ladderCssClass = "new";				
			}
			else if(arrResult[1][i].equalsIgnoreCase("0")) {
				ladderMark = "유지";
				ladderCssClass = "df";
			}
			else {
				//태그값 데이터 타입 체크 (정수형)
			    try {
			        Integer.parseInt(arrResult[1][i]);
			    } catch (NumberFormatException e) {
			    	tag = "0";
			    }
				
				if(Integer.parseInt(arrResult[1][i])>0) {
					ladderMark = "상승";
					ladderCssClass = "up";
				}else{
					ladderMark = "하락";
					ladderCssClass = "down";
				}
			}
        	
        	map.put("ladderMark", ladderMark);
        	map.put("ladderCssClass", ladderCssClass);
        	map.put("tag", tag);
        	
        	ppkList.add(map);
        	map = null;
        }
		
		return ppkList;
	}	
	
	/**
	 * 추천검색어
	 * @param inputWord
	 * @param maxResultCount
	 * @param domainNo
	 * @return String[]
	 * @throws IOException
	 * @throws KonanException
	 * @throws Exception
	 */
	public String[] getRecommandKwd(String inputWord, int maxResultCount, int domainNo) throws IOException, KonanException, Exception {
		return addOnModule.getRecommandKwd(inputWord, maxResultCount, domainNo);		
	}
	
	/**
	 * 자동완성
	 * @param seed
	 * @param maxResultCount
	 * @param flag
	 * @param domainNo
	 * @return List<HashMap<String, String>>
	 * @throws IOException
	 * @throws Exception
	 * @throws KonanException
	 */
	public List<HashMap<String, String>> getCompleteKwd(String seed, int maxResultCount, int flag, int domainNo)
			throws IOException, Exception, KonanException {
		String[][] arrResult = addOnModule.getCompleteKwd(seed, maxResultCount, flag, domainNo);
		List<HashMap<String, String>> akcList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map;
		
		if(arrResult != null) {
			 for(int i=0; i<arrResult[0].length; i++) {
		        	map = new HashMap<String, String>();
		        	map.put("KEYWORD", arrResult[0][i]);
		        	akcList.add(map);
			 }
		}
		 
		return akcList;
	}
}
