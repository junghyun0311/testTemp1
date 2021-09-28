<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
			<div class="filter">
				<a href="#none" class="bt_filter"></a>
				<%-- 기간 --%>
				<c:if test="${filterDate ne null}">
					<dl class="l_none">
					<dt>기간</dt>
					<dd>					
						<!-- Search Date By Slide -->
						<div class="slide_filter">
							<input type="radio" id="range1" value="1" name="date"><label for="range1">1일</label>
							<input type="radio" id="range2" value="7" name="date"><label for="range2">1주</label>
							<input type="radio" id="range3" value="30" name="date"><label for="range3">1달</label>
							<input type="radio" id="range4" value="365" name="date"><label for="range4">1년</label>
							<input type="radio" id="range5" value="all" name="date"><label for="range5">전체</label>
							<div id="slider-range-min"></div>
							<a href="#none" class="bt_self_input"><img src="images/bt_view_calender.gif" width="48" height="18" alt="직접입력"></a>						
						</div>
						<!-- //Search Date By Slide -->
						
						<div class="user_sch">
							<ul>
								<li>
									<input type="text" name="startDate" value="${params.startDate}" title="날짜입력" class="in_txt" /> 
									
									<span>부터</span>
								</li>
								<li>
									<input type="text" name="endDate" value="${params.endDate}" title="날짜입력" class="in_txt" /> 
									<span>까지</span>
								</li>
								<li id="dateBtn" class="ta_r" style="padding:4px 11px 0 0;">
									<input type="image" src="images/bt_day_sch.gif" alt="검색" />
									<!-- 
									<a href="#none" class="bt_slider"><img src="images/bt_close.gif" width="30" height="18" alt="닫기" /></a>
									 -->
								</li>
							</ul>
						</div>
					</dd>
					</dl>				
				</c:if>
				<%-- //기간 --%>
				<%-- 연도 --%>
				<c:if test="${filterYear ne null}">	
					<dl id="yearFilter" class="exception">
						<dt>연도</dt>
						<dd>
							<ul class="s_year">
							</ul>
							<input type="image" src="images/bt_sch2.gif" alt="검색" class="bt_filter_sch" />
						</dd>
					</dl>				
				</c:if>
				<%-- //연도 --%>
				<%-- 작성자 --%>
				<c:if test="${filterWriter ne null}">
					<dl id="writerFilter" class="exception">
						<dt>작성자 (ID포함)</dt>
						<dd>
							<div>
								<ul>
									<li>
										&nbsp;&nbsp;<input type="text" name="writer" id="filterWriter" value="${params.writer}" title="작성자입력" class="in_txt" />
									</li>
									<li id="writerBtn" class="ta_r" style="padding:4px 11px 0 0;">
										<input type="image" src="images/bt_sch2.gif" alt="검색" />									
									</li>
								</ul>							
							</div>
						</dd>
					</dl>
				</c:if>
				<%-- //작성자 --%>
				<%-- 제외어 --%>
				<c:if test="${filterNotWord ne null}">
					<dl id="notWordFilter" class="exception">
						<dt>제외어</dt>
						<dd>
							<div>
								<ul>
									<li>
										&nbsp;&nbsp;<input type="text" name="notWord" value="${params.exclusiveKwd}" title="제외어입력" class="in_txt" />
									</li>
									<li id="notWordBtn" class="ta_r" style="padding:4px 11px 0 0;">
										<input type="image" src="images/bt_sch2.gif" alt="검색" />									
									</li>
								</ul>							
							</div>
						</dd>
					</dl>
				</c:if>
				<%-- //제외어 --%>
				<%-- 첨부문서 --%>
				<c:if test="${filterAttachFile ne null}">
					<dl id="extFilter" class="exception">
						<dt>첨부문서</dt>
						<dd>
							<ul class="file_type">
							<li><input type="checkbox" id="filechk1" value="all" class="all_chk" /><label for="filechk1">전체</label></li>
							<li><input type="checkbox" id="filechk2" value="pdf" /><label for="filechk2"><img src="images/ico_pdf.gif" width="14" height="14" alt="pdf" />pdf</label></li>
							<li><input type="checkbox" id="filechk3" value="xls" /><label for="filechk3"><img src="images/ico_xls.gif" width="14" height="14" alt="xls" />xls</label></li>
							<li><input type="checkbox" id="filechk4" value="doc" /><label for="filechk4"><img src="images/ico_doc.gif" width="14" height="14" alt="doc" />doc</label></li>
							<li><input type="checkbox" id="filechk5" value="ppt" /><label for="filechk5"><img src="images/ico_ppt.gif" width="14" height="14" alt="ppt" />ppt</label></li>
							<li><input type="checkbox" id="filechk6" value="hwp" /><label for="filechk6"><img src="images/ico_hwp.gif" width="14" height="14" alt="hwp" />hwp</label></li>
							<!-- 
							<li><input type="checkbox" id="filechk7" value="gul" /><label for="filechk7"><img src="images/ico_gul.gif" width="14" height="14" alt="gul" />gul</label></li>
							 -->
							<li><input type="checkbox" id="filechk7" value="txt" /><label for="filechk8"><img src="images/ico_txt.gif" width="14" height="14" alt="txt" />txt</label></li>
							<li><input type="checkbox" id="filechk8" value="dwg" /><label for="filechk9"><img src="images/ico_etc.gif" width="14" height="14" alt="dwg" />dwg</label></li>
							</ul>
							<input type="image" src="images/bt_sch2.gif" alt="검색" class="bt_filter_sch" />
						</dd>
					</dl>
				</c:if>
				<%-- //첨부문서 --%>
				<%-- 조직 --%>
				<c:if test="${filterGroup ne null}">
					<dl id="treeData" class="exception">
						<dt>조직</dt>
						
						<dd class="org_m">
							<ul id="org_m">
								<li>IT기획팀(IT Planning Team)(38)</li>
								<li>IT기획팀(IT Planning Team)(38)</li>
								<li>IT기획팀(IT Planning Team)(38)</li>
								<li>IT기획팀(IT Planning Team)(38)</li>								
							</ul>
						</dd>
					</dl>
				</c:if>
				<%-- 조직 --%>				
			</div>
			<!-- 
			<div class="bt_reset"><a href="#none"><img src="images/bt_reset.gif" width="140" height="26" alt="전체초기화"></a></div>
			 -->