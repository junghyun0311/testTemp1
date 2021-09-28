<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
		<c:if test="${boardRow > 0}">
			<c:if test="${params.category eq 'BOARD'}">
			<div class="title_sub">
				<h2><strong>게시판</strong><em>${boardPageRange} 건</em></h2>
			</div>
			</c:if>
			<section class="contents_df">
			<c:if test="${params.category eq 'TOTAL'}">
				<h3>게시판</h3>
			</c:if>
				<ul class="list_df cate_portal">
				<c:forEach var="result" items="${boardList}" varStatus="loop">
				<li>
					<dl>
					<dt>
						<a href="#none">${result.title}</a>
						<fmt:parseDate value="${result.regdate}" var="dateFmt" pattern="yyyyMMddHHmmss"/>
						<span>${result.writer}</span> | <span><fmt:formatDate value="${dateFmt}" pattern="yyyy-MM-dd"/></span>
					</dt>
					<dd class="contxt">${result.content}</dd>
					<dd class="info_etc">
						<span class="category"><a href="#none">${result.fullpath}</a></span>
					</dd>
					</dl>
				</li>
				</c:forEach>
				</ul>
				<c:if test="${params.category eq 'TOTAL' && boardTotal > 3}">
				<div class="result_more list_bt"><a href="javascript:goCategory('BOARD');">게시판 더보기</a></div>
				</c:if>
				<c:if test="${params.category ne 'TOTAL'}">
				<script type=text/javascript>
					document.write(pageNav("gotoPage", '${params.pageNum}', 10, '${boardTotal}', 1));
				</script>
				</c:if>
			</section>
		</c:if>