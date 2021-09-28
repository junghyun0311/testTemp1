<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<c:if test="${ppkTotal > 0}">
	<div class="a_section word_rank">
		<h3><a href="#none">인기검색어</a></h3>
		<div class="aside_wrapper">
			<ol  class="first">
				<c:forEach var="ppkList" items="${ppkList}" varStatus="loop">
					<li class="s${loop.count}">
						<a href="javascript:dftSchKwd('${ppkList.keyword}');">${ppkList.keyword}</a>
						<span class="${ppkList.ladderCssClass}">
							<em>${ppkList.ladderMark}</em>${ppkList.tag}
						</span>
					</li>
				</c:forEach>
			</ol>
		</div>
	</div>
</c:if>