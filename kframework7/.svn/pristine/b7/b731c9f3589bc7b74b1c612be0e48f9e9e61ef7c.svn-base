<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<div class="in_header">
		<h1><a href="search">KONAN</a></h1>
		<div class="serch">
			<form name="topSearchForm" id="topSearchForm" onSubmit="return srchKwd(this);return false;" method="get" action="search_ksf" >
				<fieldset>
					<div class="in_txt">
						<input type="text" autocomplete="off" id="topKwd" name="kwd" value='${params.kwd}' title="검색어 입력">
						<a href="#none" id="top_arrow" class="auto_arr">자동완성 펼치기</a>
						<input type="image" src="images/bt_top_sch.gif" alt="검색">
					</div>
					<a href="#none" class="ctr_detail"><img src="images/tit_ctr_detail.gif" width="39" height="11" alt="상세검색"></a>					
				</fieldset>
				<input type="hidden" name="category" value="${params.category}" />												
			</form>
		</div>
		<!-- AKC Keyword : Start -->
		<div class="keyword" id="topKeywordLst">
			<ul>
				<li><a href="#none">검색어 자동완성을 사용중입니다.</a></li>
			</ul>
			<!-- choose_word -->
			<div class="choose_word">
				<div class="fl">
					<a href="#none" id="first_opt_top">첫단어 보기</a> | <a id="last_opt_top" href="#none">끝단어 보기</a>
				</div>
				<a href="#none" id="akc_able" class="fr bt_autokey_cl">끄기</a>
			</div>
			<!-- //choose_word -->						
		</div>
		<!-- AKC Keyword : End -->
	</div>