<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<c:if test="${total == 0 && params.category != 'HISTORY'}">
	<dl class="no_result">
		<dt><em>'${params.kwd}'</em> 와/과 일치하는 검색결과가 없습니다.</dt>
		<dd class="m_h">단어의 철자가 정확한지 확인해 보세요.</dd>
		<dd>검색어가 바르게 입력되었는지 확인해 보세요.</dd>
		<dd>비슷한 단어로 다시 검색해 보세요.</dd>
		<dd class="bt_area">
			<a href="javascript:history.back(-1)">이전페이지로 돌아가기</a>
			<a href="/kframework/search">초기화면으로 돌아가기</a>
		</dd>
	</dl>
</c:if>