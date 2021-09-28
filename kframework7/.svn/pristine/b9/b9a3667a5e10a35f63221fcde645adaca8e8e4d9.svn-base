<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
		<c:if test="${siteRow > 0}">
			<c:if test="${params.category eq 'SITE'}">
			<div class="title_sub">
				<h2><strong>사이트</strong><em>${sitePageRange} 건</em></h2>
			</div>
			</c:if>
			<section class="contents_df">
			<c:if test="${params.category eq 'TOTAL'}">
				<h3>사이트</h3>
			</c:if>
				<ul class="list_df cate_portal">
				<c:forEach var="result" items="${siteList}" varStatus="loop">
				<li>
						<dl>
						<dt><a href="${result.site_hompy}">${result.site_nm}</a></dt>
						<dd class="contxt">${result.site_desc}</dd>
						<dd class="info_etc">
							<span class="category">${result.site_ctgr}</span>
						</dd>
						</dl>
					</li>
				</c:forEach>
				</ul>
				<c:if test="${params.category eq 'TOTAL' && siteTotal > 3}">
				<div class="result_more list_bt"><a href="javascript:goCategory('SITE');">사이트 더보기</a></div>
				</c:if>
				<c:if test="${params.category ne 'TOTAL'}">
				<script type=text/javascript>
					document.write(pageNav("gotoPage", '${params.pageNum}', 10, '${siteTotal}', 1));
				</script>
				</c:if>
			</section>
		</c:if>