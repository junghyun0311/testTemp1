<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.konantech.kframework.common.CommonUtil" %>
<%@ page session="true" %>
		<c:if test="${personRow > 0}">
			<c:if test="${params.category eq 'PERSON'}">
			<div class="title_sub">
				<h2><strong>인물</strong><em>${personPageRange} 건</em></h2>
			</div>
			</c:if>
			<section class="contents_df">
			<c:if test="${params.category eq 'TOTAL'}">
				<h3>인물</h3>
			</c:if>
				<ul class="cate_person">
				<c:forEach var="result" items="${personList}" varStatus="loop">
				<li>
					<dl>
					<dt><a href="#none">${result.prs_nm_ko}</a> <span class="info_etc">(${result.prs_nm_en})</span></dt>
					<dd class="sum"><a href="#none"><img src="images/${result.picture}" width="88" height="108" alt=""></a></dd>
					<dd>
						<span class="tit">본부</span>
						<span class="con">${result.head_nm}</span>
					</dd>
					<dd>
						<span class="tit">부서</span>
						<span class="con">${result.dept_nm}</span>
					</dd>
					<dd>
						<span class="tit">전화번호</span>
						<span class="con">${result.phone_no}</span>
					</dd>
					<dd>
						<span class="tit">휴대폰</span>
						<span class="con">${result.mobile_no}</span>
					</dd>
					<dd>
						<span class="tit">이메일</span>
						<span class="con"><a href="#none">${result.email}</a></span>
					</dd>
					</dl>
				</li>
				</c:forEach>
				</ul>
				<c:if test="${params.category eq 'TOTAL' && personTotal > 2}">
				<div class="result_more list_bt"><a href="javascript:goCategory('PERSON');">인물 더보기</a></div>
				</c:if>
				<c:if test="${params.category ne 'TOTAL'}">
				<script type=text/javascript>
					document.write(pageNav("gotoPage", '${params.pageNum}', 10, '${personTotal}', 1));
				</script>
				</c:if>
			</section>
		</c:if>
	