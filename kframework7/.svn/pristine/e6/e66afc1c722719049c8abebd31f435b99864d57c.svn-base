// 페이지 이동 1,2, ... 하는 HTML 코드를 생성해서 돌려준다.
//	funcName : 실제 페이지 이동을 위한 함수이름 (예: gotoPage)
//	pageNum : 현재 페이지 번호
//	pageSize : 한 페이지당 결과 갯수
//	total : 전체 결과 갯수

function navAnchor( funcName, pageNo, anchorText )
{
    var font_class = "<a href=\"javascript:{" + funcName + "(" + pageNo + ")}\">" + anchorText + "</a>";    
	return font_class;
}

// 클래스 있는 버전
function navAnchorByCls( funcName, pageNo, anchorText, title )
{
    var font_class = "<a href=\"javascript:{" + funcName + "(" + pageNo + ")}\" class=\"pre\" title=\"" + title + "\" >" + anchorText + "</a>";    
	return font_class;
}

function pageNav( funcName, pageNum, pageSize, total, sizeStatus )
{
	if( total < 1 )
		return "";

	var ret = "";
	var PAGEBLOCK=10;
	
	if(sizeStatus == 0)
		PAGEBLOCK = 1;
	
	var totalPages = Math.floor((total-1)/pageSize) + 1;

	var firstPage = Math.floor((pageNum-1)/PAGEBLOCK) * PAGEBLOCK + 1;
	if( firstPage <= 0 ) // ?
		firstPage = 1;

	var lastPage = firstPage-1 + PAGEBLOCK;
	if( lastPage > totalPages )
		lastPage = totalPages;
	
	ret += "<div class=\"paging\">";
	
	if(sizeStatus > 0){
		if( firstPage > PAGEBLOCK )
		{
	        ret += navAnchorByCls(funcName, 1, "<img src='./images/btn_pre_02.gif' alt='처음으로가기' width='22' height='22'>", "첫 페이지로 이동") + " ";
			ret += navAnchorByCls(funcName, firstPage-1, "<img src='./images/btn_pre_01.gif' alt='앞으로가기' width='22' height='22'>", "이전 " + PAGEBLOCK + "페이지로 이동") + " ";
		}else{
			ret += "<a href=\"#none\" class=\"pre\"><img src='./images/btn_pre_02_off.gif' alt='처음으로가기' width='22' height='22'></a>" + " ";
			ret += "<a href=\"#none\" class=\"pre\"><img src='./images/btn_pre_01_off.gif' alt='앞으로가기' width='22' height='22'></a>" + " ";
		}
	
		for( var i=firstPage; i<=lastPage; i++ )
		{
			if( pageNum == i )
				ret += "<strong>" + i + "</strong>" + " ";
			else
				ret += navAnchor(funcName, i, i) + " ";
		}
	
		if( lastPage < totalPages )
		{
			ret += navAnchorByCls(funcName, lastPage+1, "<img src='./images/btn_next_01.gif' alt='뒤로가기' width='22' height='22'>", "다음 " + PAGEBLOCK + "페이지로 이동") + " ";
			ret += navAnchorByCls(funcName, totalPages, "<img src='./images/btn_next_02.gif' alt='마지막으로가기' width='22' height='22'>", "마지막 페이지로 이동") + "\n";
		}else{
			ret += "<a href=\"#none\" class=\"pre\"><img src='./images/btn_next_01_off.gif' alt='뒤로가기' width='22' height='22'></a>" + " ";
			ret += "<a href=\"#none\" class=\"pre\"><img src='./images/btn_next_02_off.gif' alt='마지막으로가기' width='22' height='22'></a>" + "\n";
		}
	}else{	// narrow 사이즈일 경우
		if(firstPage > 1){
			ret += navAnchorByCls(funcName, firstPage-1, "<img src='./images/btn_pre_01.gif' alt='앞으로가기' width='22' height='22'>", "이전 " + PAGEBLOCK + "페이지로 이동") + " ";
		}else{
			ret += "<a href=\"#none\" class=\"pre\"><img src='./images/btn_pre_01_off.gif' alt='앞으로가기' width='22' height='22'></a>" + " ";
		}
		
		ret += "" + firstPage + "/" + totalPages + "" + " ";
		
		if( lastPage < totalPages ){
			ret += navAnchorByCls(funcName, lastPage+1, "<img src='./images/btn_next_01.gif' alt='뒤로가기' width='22' height='22'>", "다음 " + PAGEBLOCK + "페이지로 이동") + " ";
		}else{
			ret += "<a href=\"#none\" class=\"pre\"><img src='./images/btn_next_01_off.gif' alt='뒤로가기' width='22' height='22'></a>" + " ";
		}
	}
	
	ret += "</div>";
	
	return ret;
}
