<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.konantech.kframework.common.*" %>
<%@ page session="true" %>

<c:if test="${documentRow > 0}">
	<c:if test="${params.category eq 'DOCUMENT'}">
		<div class="title_sub">
					<h2><strong>문서</strong><em>${documentPageRange}건</em></h2>
		</div>
	</c:if>
	<section class="contents_df">
		<c:if test="${params.category eq 'TOTAL'}">
		<h3>문서</h3>	
		</c:if>
		<ul class="list_df cate_documents">
			<c:forEach var="result" items="${documentList}" varStatus="loop">
				<li>
					<dl>
					<dt>
						<a href="#none" target="_blank">${result.title}</a>
						<span>
							${result.writer} 
							<c:if test="${!empty result.writer && !empty result.regdate}">
							ㅣ 
							</c:if>
							<fmt:parseDate value="${result.regdate}" var="dateFmt" pattern="yyyyMMddHHmmss"/>
							<fmt:formatDate value="${dateFmt}" pattern="yyyy-MM-dd"/>
						</span>
					</dt>
					<dd class="contxt">${result.content}</dd>
					<c:if test="${not empty result.filename}">
						<dd class="file">
							<c:forTokens var="filename" items="${result.filename}" delims="|">
									<c:set var="FILENAMES" value="${result.filename}"/>
									<%
										String fileExt = CommonUtil.getAttachFileImage((String)pageContext.getAttribute("FILENAMES"));
									%>
									<a href="#none"><img src="images/<%=fileExt%>" width="14" height="14" >${result.filename}</a>
									<a href="#none" class="bt_preview">미리보기</a>
									<!-- 미리보기 -->
									<div class="preview_box">
										<span class="rowid" style="display:none;"></span>
										<h3>미리보기</h3>
										<div class="in_box">${result.filepath}</div>
										<a href="#none" class="download">다운로드</a>
										<div class="info">저작권 정보</div>
										<a href="#none" class="bt_close"><img src="images/bt_close_preview.gif" width="34" height="10" alt="닫기" /></a>
									</div>
									<!-- //미리보기 -->
				      		</c:forTokens>
													
						</dd>
					</c:if>
					</dl>
				</li>	
			</c:forEach>		
		</ul>
		<c:if test="${params.category eq 'TOTAL' && documentTotal > 3}">
		<div class="result_more list_bt"><a href="javascript:goCategory('DOCUMENT');">문서 더보기</a></div>
		</c:if>
		<c:if test="${params.category ne 'TOTAL'}">
		<script type=text/javascript>
			document.write(pageNav("gotoPage", '${params.pageNum}', 10, '${documentTotal}', 1));
		</script>
		</c:if>
	</section>
</c:if>