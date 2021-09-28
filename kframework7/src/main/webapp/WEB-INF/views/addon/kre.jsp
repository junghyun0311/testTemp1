<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<c:if test="${kreTotal > 0}">
	<div class="box_relate_word">
		<h2><img src="images/tit_relate_word.gif" width="47" height="23" alt="관련어"></h2>
		<div id="relate_word">
			<div class="box">
				<ul>
					<c:forEach var="kreList" items="${kreList}" varStatus="loop">
						<li><a href="search?kwd=${kreList}">${kreList}</a></li>				
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</c:if>