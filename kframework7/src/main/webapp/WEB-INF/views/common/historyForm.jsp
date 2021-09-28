<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.konantech.kframework.common.*" %>
<form name="historyForm" id="historyForm" method="get" action="search" >	
	<input type="hidden" id="hstr_kwd" name="kwd" value='${params.kwd}'/>
	<input type="hidden" id="hstr_category" name="category" value='${params.category}'/>
	<input type="hidden" id="hstr_subCategory" name="subCategory" value='${params.subCategory}'/>
	<input type="hidden" id="hstr_reSrchFlag" name="reSrchFlag" value='${params.reSrchFlag}'"/>
	<input type="hidden" id="hstr_pageNum" name="pageNum" value='${params.pageNum}'/>
	<input type="hidden" id="hstr_pageSize" name="pageSize" value='${params.pageSize}'/>
	<input type="hidden" id="hstr_fileExt" name="fileExt" value='${params.fileExt}'/>
	<input type="hidden" id="hstr_sort" name="sort" value='${params.sort}'/>
	<input type="hidden" id="hstr_date" name="date" value='${params.date}'/>	
	<input type="hidden" id="hstr_startDate" name="startDate" value='${params.startDate}' />
	<input type="hidden" id="hstr_endDate" name="endDate" value='${params.endDate}' />
	<input type="hidden" id="hstr_writer" name="writer" value='${params.writer}' />
	<input type="hidden" id="hstr_notWord" name="notWord" value='${params.exclusiveKwd}' />
	<input type="hidden" id="hstr_year" name="year" value='${params.year}' />
	<input type="hidden" id="hstr_srchFd" name="srchFd" value='${params.srchFd}'/>
	<input type="hidden" id="hstr_detailSearch" name="detailSearch" value='${params.detailSearch}'/>
	<input type="hidden" id="hstr_callLoc" name="callLoc" value='${params.callLoc}'/>
</form>