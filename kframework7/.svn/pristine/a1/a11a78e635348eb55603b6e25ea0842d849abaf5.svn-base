<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>


<!DOCTYPE HTML>
<html class="no-js">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no' />
<title>K-Framework</title>
<link rel="stylesheet" href="css/default.css" />
<link rel="stylesheet" media="screen and (min-width: 801px)" type="text/css" href="css/pc.css" />
<link rel="stylesheet" media="screen and (min-width: 481px) and (max-width: 800px)" type="text/css" href="css/tablet.css" />
<link rel="stylesheet" media="screen and (max-width: 480px)" type="text/css" href="css/phone.css" />
<link rel="stylesheet" id="IE8" href="" />
<!--[if IE 7]>
<link rel="stylesheet" href="css/pc.css" />
<![endif]-->
<!--[if lt IE 9]>
<script src="js/lib/html5.js"></script>
<![endif]-->
<script>
//initialize
var ctgr_cd = '${params.category}';
var ctgrCd = '${params.category}';
</script>
<script src="js/lib/modernizr-2.5.3.js"></script>
<script src="js/lib/jquery-1.7.1.min.js"></script>
<script src="js/lib/jquery.ui.core.js"></script>
<script src="js/lib/jquery.ui.widget.js"></script>
<script src="js/lib/jquery.ui.mouse.js"></script>
<script src="js/lib/jquery.ui.slider.js"></script>
<script src="js/lib/relateWord.js"></script>
<script src="js/lib/ua.js"></script>
<script src="js/lib/common.js"></script>
<script src="js/lib/calendar.js"></script>

<script src="js/common.js"></script>
<script src="js/handle.js"></script>
<script src="js/pagenav.js"></script>
<script src="js/searchedkwd.js"></script>
<script src="js/akc.js"></script>
<script src="js/init.js"></script>
<script src="js/search.js"></script>
<!--[if IE 8]>
<script>
var setRWD = function(){
	if($(this).width() < 481){ // if narrow
		$('#IE8').attr('href','css/phone.css')
	}else if($(this).width() > 480 && $(this).width() < 801){ // if midium
		$('#IE8').attr('href','css/tablet.css')
	}else{  //if wide
		$('#IE8').attr('href','css/pc.css')
	}
}
setRWD();
$().ready(function(){
	$(window).on('resize', function(){
		setRWD();
	});
});
</script>
<![endif]-->
</head>
<!--body 상세검색영역 타입변경시 type_abs 사용-->
<body class="type" >

<!-- History Form -->
<jsp:include flush="false" page="./common/historyForm.jsp"/>
<!-- //History Form -->
<!-- 자바스크립트 변수값을 담기 위한 hidden value [For IE,FF 뒤로가기 Cache Bug] -->
<input type="hidden" id="var_kwd" name="kwd" value="${params.kwd}"/>
<input type="hidden" id="var_date" name="date" value="${params.date}"/>
<input type="hidden" id="var_category" name="category" value="${params.category}"/>
<input type="hidden" id="var_subCategory" name="subCategory" value="${params.subCategory}"/>
<input type="hidden" id="var_pageNum" name="pageNum" value="${params.pageNum}"/>
<input type="hidden" id="var_reSrchFlag" name="reSrchFlag" value="${params.reSrchFlag}"/>
<input type="hidden" id="var_detailSearch" name="detailSearch" value="${params.detailSearch}"/>
<input type="hidden" id="tot_person" value="${personTotal}"/>
<input type="hidden" id="tot_site" value="${siteTotal}"/>
<input type="hidden" id="tot_document" value="${documentTotal}"/>
<input type="hidden" id="tot_board" value="${boardTotal}"/>

<!-- //자바스크립트 변수값을 담기 위한 hidden value [For IE,FF 뒤로가기 Cache Bug] -->

<!-- Skip nav -->
<ul id="skipnav">
<li><a href="#left">메뉴 바로가기</a></li>
<li><a href="#contents">컨텐츠 바로가기</a></li>
</ul>
<!-- //Skip nav -->

<!-- Header -->
<header id="top_h">
	<!-- Top Search -->
	<jsp:include flush="false" page="./common/topSearch.jsp"/>
	<!-- //Top Search -->
	
	<!-- AKC Keyword -->
	<jsp:include flush="false" page="./addon/akc.jsp"/>
	<!-- //AKC Keyword -->
	
	<!-- Detail Search : Start -->
	<jsp:include flush="false" page="./common/detailSearch.jsp"/>
	<!-- Detail Search : End -->
</header>
<!-- //Header -->
<div class="top_line"></div>
<!-- Container -->
<div id="container">
	<!-- Relation Keyword -->
	<span id="kreView"></span>
	<!-- //Relation Keyword -->
	
	<!-- Middle Wrapper -->
	<div class="middle_wrapper">
		<!-- nav_filter -->
		<article class="nav_filter">
		
			<!-- Category Navigator -->
			<nav id="left">
				<h2 class="m_title"><a href="#none">통합검색<span></span></a></h2>
				<ul>
				<li class="first"><a href="#none">통합검색</a></li>
				<li><a href="#none">인물</a></li>
				<li><a href="#none">사이트</a></li>
				<li><a href="#none">게시판</a></li>
				<li><a href="#none">문서</a></li>
				<!-- <li class="nav_etc"><a href="#none">카테고리</a></li>
				<li class="nav_more"><a href="#none">더보기</a></li> -->
				</ul>
			</nav>
			<!-- //Category Navigator -->
			
			<!-- filter -->
			<jsp:include flush="true" page="./common/filterSearch.jsp" />
			<!-- //filter -->
			
		</article>
		<!-- //nav_filter -->
		
		<!-- Contents -->
		<article id="contents">
			<%-- 결과 있을 경우 --%>
			
			<!-- result_all -->
			<c:if test="${params.category eq 'TOTAL'}">
			<section class="result_all">
				<h2>'<strong>${params.kwd}</strong>'에 대한 검색결과  <em>총 ${formatTotal} 건</em></h2>
			</section>
			</c:if>
			<!-- //result_all -->
			
			<%-- 인물 --%>
			<jsp:include flush="true" page="./result/personResult.jsp" />
			<%-- //인물 --%>
			<%-- 사이트 --%>
			<jsp:include flush="true" page="./result/siteResult.jsp" />
			<%-- //사이트 --%>
			<%-- 게시판 --%>
			<jsp:include flush="true" page="./result/boardResult.jsp" />
			<%-- //게시판 --%>
			<%-- 문서 --%>
			<jsp:include flush="true" page="./result/documentResult.jsp" />
			<%-- //문서 --%>
			
			<%-- //결과 있을 경우 --%>
			
			<%-- 결과 없을 경우 --%>
			<!-- noresult -->
			<jsp:include flush="true" page="./result/noResult.jsp" />
			<!-- //noresult -->			
			<%-- //결과 없을 경우 --%>
		
		</article>
		<!-- //Contents -->
		
		<!-- Right -->
		<aside>
			<!-- Rank Keyword -->
			<span id="ppkView"></span>
			<!-- //Rank Keyword -->
			
			<!-- Searched Keyword -->
			<jsp:include flush="true" page="./addon/searchedKwd.jsp" />
			<!-- //Searched Keyword -->
			<a href="#none" class="bt_top">맨위로</a>
		</aside>
		<!-- //Right -->
	</div>
	<!-- //Middle Wrapper -->
</div>
<footer>	
	<div class="copy" >Copyright(c) 2018. Konan Technology Inc. All rights reserved.</div>
</footer>
<!-- calendar -->
<div class="calendar">
	<div class="in_box">
		<table>
		<caption>
			<img src="images/bt_calendar_l.gif" width="8" height="15" alt="이전월" />
			<span>
				<select title="기간선택">
				<option>2011 년</option>
				</select>
				<select title="기간선택">
				<option>3월</option>
				</select>
			</span>
			<img src="images/bt_calendar_r.gif" width="8" height="15" alt="다음월" />
		</caption>
		<thead>
		<tr>
		<th scope="col" class="sun">일</th>
		<th scope="col">월</th>
		<th scope="col">화</th>
		<th scope="col">수</th>
		<th scope="col">목</th>
		<th scope="col">금</th>
		<th scope="col" class="sat">토</th>
		</tr>
		</thead>
		<tbody>
		<tr>
		<td>&nbsp;</td>
		<td><a href="#none">1</a></td>
		<td><a href="#none">2</a></td>
		<td><a href="#none">3</a></td>
		<td><a href="#none">4</a></td>
		<td><a href="#none">5</a></td>
		<td><a href="#none">6</a></td>
		</tr>
		<tr>
		<td><a href="#none">7</a></td>
		<td><a href="#none">8</a></td>
		<td><a href="#none">9</a></td>
		<td><a href="#none">10</a></td>
		<td><a href="#none">11</a></td>
		<td><a href="#none">12</a></td>
		<td><a href="#none">13</a></td>
		</tr>
		<tr>
		<td><a href="#none">14</a></td>
		<td class="today"><a href="#none">15</a></td>
		<td><a href="#none">16</a></td>
		<td><a href="#none">17</a></td>
		<td><a href="#none">18</a></td>
		<td class="selected"><a href="#none">19</a></td>
		<td><a href="#none">20</a></td>
		</tr>
		<tr>
		<td><a href="#none">21</a></td>
		<td><a href="#none">22</a></td>
		<td><a href="#none">23</a></td>
		<td><a href="#none">24</a></td>
		<td><a href="#none">25</a></td>
		<td><a href="#none">26</a></td>
		<td><a href="#none">27</a></td>
		</tr>
		<tr>
		<td><a href="#none">28</a></td>
		<td><a href="#none">29</a></td>
		<td><a href="#none">30</a></td>
		<td><a href="#none">31</a></td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		</tr>
		</tbody>
		</table>
	</div>
	<div class="c_close"><img src="images/bt_c_close.gif" width="11" height="13" class="c_point" alt="닫기" /></div>
</div>
<!-- //calendar -->
</body>
</html>