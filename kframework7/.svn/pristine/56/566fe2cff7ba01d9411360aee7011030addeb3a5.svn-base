<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE HTML>
<html class="no-js">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no' />
<title>코난테크놀로지 검색 프레임워크 v1.0</title>
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<link rel="stylesheet" href="./css/login.css" />
<script src="js/lib/modernizr-2.5.3.js"></script>
<script src="js/lib/jquery-1.7.1.min.js"></script>
<script src="js/lib/relateWord.js"></script>
<script src="js/lib/ua.js"></script>
<script src="js/lib/common.js"></script>

<script src="js/common.js"></script>
<script src="js/pagenav.js"></script>
<script src="js/searchedkwd.js"></script>
<script src="js/akc.js"></script>
<script src="js/init.js"></script>
<script src="js/search.js"></script>
<script>
$(window).on('load resize', function(){
	$('.searching_box').height($(this).height()-29);
})
</script>
</head>

<body class="type_abs">
<div class="searching_box">
	<div class="quick_m">
		<a href="#none">로그인</a> ㅣ 
		<a href="#none">도움말</a>
	</div>
	
	<div class="in_serach">
		<h1><img src="./images/customer/${userId}.png" width="196" height="39" alt="KONAN"></h1>
		
		<div class="serch">
			<form name="searchForm" id="searchForm" method="get" action="search" >
				<fieldset>
					<legend>검색 폼</legend>
					<div class="in_txt">
						<input type="text" id="topKwd" name="kwd" title="검색어 입력">
						<a href="#none" id="top_arrow" class="auto_arr">자동완성 펼치기</a>
						<input type="image" src="images/bt_top_sch2.gif" alt="검색">
					</div>
				</fieldset>
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
		
		<!-- box_relate_word -->		<!-- 디자인만 제공 프로젝트 별로 수정 요망 -->
		<div class="box_relate_word">
			<h2><img src="images/tit_prop_word.gif" width="47" height="23" alt="추천어"></h2>
			<div id="relate_word">
				<div class="box">
					<ul>
						<li><a href="#none">무한도전 결방</a></li>
						<li><a href="#none">코난테크놀로지</a></li>
						<li><a href="#none">뉴아이패드</a></li>
						<li><a href="#none">스티브잡스</a></li>
						<li><a href="#none">테스트</a></li>
						<li><a href="#none">코난</a></li>
					</ul>
				</div>
			</div>	
		</div>	
		<!-- //box_relate_word -->
	</div>
	
</div>

<footer>Copyright(c) 2018. Konan Technology Inc. All rights reserved.</footer>

</body>
</html>