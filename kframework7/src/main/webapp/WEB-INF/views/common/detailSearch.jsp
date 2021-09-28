<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>	
	<div class="sch_setting">
		<form id="detailSearchForm" name="detailSearchForm">
		<h2>상세검색</h2>
		<!-- set_inner -->
		<div class="set_inner">
			<dl>
			<dt>키워드</dt>
			<dd>
				<input type="text" id="detailKwd" name="kwd" value='${params.kwd}' title="키워드">
			</dd>
			</dl>
			
			<dl>
			<dt>메뉴</dt>
			<dd id="detailCtgr">
			</dd>
			</dl>
			
			<dl>
			<dt>영역</dt>
			<dd id="detailSrchFd">
				<label for="setting2-1"><input type="radio" name="srchFd" value="all" id="setting2-1">전체</label>
				<label for="setting2-2"><input type="radio" name="srchFd" value="title" id="setting2-2">제목</label>
			</dd>
			</dl>
			
			<dl>
			<dt>기간</dt>
			<dd id="detailDate">
				<label for="setting3-1"><input type="radio" name="date" value="all" id="setting3-1">전체</label>
				<label for="setting3-2"><input type="radio" name="date" value="1" id="setting3-2">1일</label>
				<label for="setting3-3"><input type="radio" name="date" value="7" id="setting3-3">1주</label>
				<label for="setting3-4"><input type="radio" name="date" value="30" id="setting3-4">1달</label>
				<label for="setting3-5"><input type="radio" name="date" value="365" id="setting3-5">1년</label>
				<label for="setting3-6" style="margin-right:0px;"><input type="radio" name="date" value="user" id="setting3-6">직접입력</label>
				<span class="day_self">
					<input type="text" style="width:62px;" name="startDate" value="" title="시작날짜"> 
					<input type="text" style="width:62px;" name="endDate" value="" title="끝날짜">
				</span>
			</dd>
			</dl>
			
			<dl>
			<dt>정렬</dt>
			<dd id="detailSort">
				<label for="setting4-1"><input type="radio" name="sort" value="r" id="setting4-1">정확도</label>
				<label for="setting4-2"><input type="radio" name="sort" value="d" id="setting4-2">최신순</label>
			</dd>
			</dl>
			
			<dl class="last">
			<dt>첨부파일</dt>
			<dd id="detailFile">
				<label for="setting5-1"><input type="checkbox" value="all" id="setting5-1">전체</label>
				<label for="setting5-2"><input type="checkbox" value="hwp" id="setting5-2">아래한글</label>
				<label for="setting5-3"><input type="checkbox" value="doc" id="setting5-3">워드</label>
				<label for="setting5-4"><input type="checkbox" value="ppt" id="setting5-4">파워포인트</label>
				<label for="setting5-5"><input type="checkbox" value="xls" id="setting5-5">엑셀</label>
				<label for="setting5-6"><input type="checkbox" value="pdf" id="setting5-6">PDF</label>
				<label for="setting5-7"><input type="checkbox" value="txt"  id="setting5-7">텍스트파일</label>
			</dd>
			</dl>
		</div>
		<!-- //set_inner -->
		
		<div class="btn_area">
			<input type="image" src="images/bt_sch.gif" alt="검색">
			<a href="#none" class="reset">초기화</a>
		</div>
		
		<a href="#none" class="bt_sch_setting">
			<img src="images/bt_sch_setting_close.gif" width="9" height="9" alt="닫기">
		</a>
		<input type="hidden" id="detl_fileExt" name="fileExt" value=""/>
		<input type="hidden" id="detl_detailSearch" name="detailSearch" value="true"/>		
		</form>
	</div>