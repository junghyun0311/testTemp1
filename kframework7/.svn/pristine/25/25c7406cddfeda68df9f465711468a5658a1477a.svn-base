/*******************************************************
* 프로그램명 	 : common.js 
* 설명           : 통합검색용 공용함수
* 작성일         : 2012.04.12
* 작성자         : 장진후
* 수정내역     	 :
*******************************************************/

var cal_input_layer = null;

/**
* 입력받은 키워드로 Default 검색
*
* @ param kwd - 검색어   
*
* @ return	void
**/	
function dftSchKwd( kwd ){
	if(kwd == ""){
		alert("검색어를 입력해주세요.");
		return false;
	}else{		
		callKwdCookie(kwd);
		$('#topKwd').val(kwd);
		$('#topSearchForm').submit();
	}
}

/**
* 입력받은 키워드로 검색
*
* @ param frmObj - 폼오브젝트   
*
* @ return	boolean
**/	
function srchKwd( frmObj ){
	var kwd = frmObj.kwd.value;
	
	if(kwd == ""){
		alert("검색어를 입력해주세요.");
		return false;
	}else{
		callKwdCookie(kwd);
		frmObj.submit();
	}				
}

/**
* 입력받은 카테고리값 검색
* 
* @ param ctgr_cd - 카테고리 코드
*    
* @ return	void
**/	
function goCategory( ctgr_cd ){
		$('#hstr_pageNum').val('1');
		$('#hstr_category').val(ctgr_cd);
		$('#hstr_subCategory').val("ALL");
		$('#hstr_year').val('all');
		$('#hstr_fileExt').val('all');		
		$('#hstr_detailSearch').val('false');
		$('#historyForm').submit();
}

/**
* 입력받은 카테고리, 서브카테고리값 검색
* 
* @ param ctgr_cd - 카테고리 코드, sub_ctgr_cd - 서브카테고리 코드 
*    
* @ return	void
**/	
function goSubCategory( ctgr_cd, sub_ctgr_cd ){
	$('#hstr_pageNum').val('1');
	$('#hstr_category').val(ctgr_cd);
	$('#hstr_subCategory').val(sub_ctgr_cd);
	$('#hstr_year').val('all');
	$('#hstr_fileExt').val('all');
	$('#hstr_detailSearch').val('false');
	$('#historyForm').submit();
}

/**
* 카테고리 매칭 함수. 
* 카테고리명을 넘겨주면 코드를, 코드값을 넘겨주면 카테고리 명을 리턴
* 
* @ param ctgr - 카테고리값 
* @ param type - 타입(0 : 카테고리명, 1 : 카테고리코드 )  
*
* @ return str 			
**/	
function rtnCtgrVal( ctgr, type ){
	var rtn_val = "";
	if( type != 0 && type != 1 )
		return rtn_val;
	
	for(var i=0;i<ctgr_cnt;i++){
		if( ctgr_arr[i][type] == ctgr ){
			if( type == 0 ){
				rtn_val = ctgr_arr[i][1];
			}else{
				rtn_val = ctgr_arr[i][0];
			}
		}
	}
	
	return rtn_val;
}

/**
* 카테고리 매칭 함수(카운트). 
* 카테고리 코드값을 넘겨주면, total 값을 리턴한다.
* 
* @ param ctgr - 카테고리 코드
* 
* @ return str 			
**/
function rtnCtgrCnt( ctgr_cd, sub_ctgr_cd ){
	var rtn_val = 0;
	
	if(sub_ctgr_cd == "ALL"){
		for(var i=0;i<ctgr_cnt;i++){
			if(ctgr_arr[i][1] == ctgr_cd){
				rtn_val = ctgr_arr[i][6];
				return rtn_val;
			}
		}
	}else{
		for(var i=0;i<ctgr_cnt;i++){
			if(ctgr_arr[i][1] == ctgr_cd, ctgr_arr[i][3] == sub_ctgr_cd){
				rtn_val = ctgr_arr[i][6];
				return rtn_val;
			}
		}
	}
	
	return rtn_val;
}

/**
* 카테고리 매칭 함수(필터). 
* 카테고리 명을 넘겨주면, 필터값을 리턴한다.
* 
* @ param ctgr - 카테고리명
* 
* @ return str
**/
function rtnCtgrFilter( ctgr_cd ){
	var rtn_val = 0;
	
	for(var i=0;i<ctgr_cnt;i++){
		if(ctgr_arr[i][1] == ctgr_cd){
			rtn_val = ctgr_arr[i][5];
			return rtn_val;
		}
	}
	
	return rtn_val;
}

/**
* 더보기 체크 함수
* 파람값을 넘겨주면, 더보기 여부를 체크한다.
* 
* @ param ctgr_cd - 카테고리코드, ctgr_cnt - 카테고리 카운트  
*
* @ return boolean 			
**/
function chkMoreBtn(ctgr_cd, ctgr_cnt, ctgr){
	if(ctgr == 'TOTAL'){	// 통합검색시
		if((ctgr_cd == 'DOCUMENT' || ctgr_cd == 'BOARD' || ctgr_cd == 'NNEWS') && ctgr_cnt > 3){
			return true;
		}else if(ctgr_cd == 'NIMAGE' && ctgr_cnt > 5){
			return true;
		}else if(ctgr_cd == 'SITE' && ctgr_cnt > 1){
			return true;
		}else if(ctgr_cd == 'PERSON' && ctgr_cnt > 2){
			return true;
		}
	}
	
	return false;
}

/**
* 페이징 체크 함수
* 파람값을 비교하여 페이징을 해야 하는지 여부를 리턴한다.(0이상이면 페이징이 가능)
* 
* @param ctgr_cd - 카테고리코드, ctgr_cnt - 카테고리 카운트, ctgr - 카테고리, sub_ctgr - 서브카테고리
* 
* @return pageSize 			
**/
function getPageSize(ctgr_cd, ctgr_cnt, ctgr, sub_ctgr){
	if(ctgr != "TOTAL"){
		if(ctgr_cd == "NIMAGE" || sub_ctgr == "CATEGORY"){
			return 20;
		}else{
			return 10;
		}
	}
	
	return 0;
}

/**
* gotoPage(페이징)
* 
* @param pageNum( 페이지 번호 )
* 
* @return void
**/
function gotoPage( pageNum ){
	$('#hstr_pageNum').val(pageNum);
	$('#hstr_detailSearch').val('false');
	$('#historyForm').submit();
}

/**
 * 정렬 검색 실행
 * 
 * @param val
 * 
 * @return
 */
function goSort( sort_val ){
	if(sort_val.trim() == "최신순"){
		$('#hstr_sort').val('d');	
	}else{
		$('#hstr_sort').val('r');	
	}
	
	$('#historyForm').submit();
}

/**
 * 영역 검색 실행
 * 
 * @param srchFd
 * 
 * @return
 */
function goSrchFd( srchFd ){
	if(srchFd.trim() == "제목"){
		$('#hstr_srchFd').val('title');	
	}else{
		$('#hstr_srchFd').val('all');	
	}
	
	$('#historyForm').submit();
}

/**
 * 날짜 검색 실행(radio box)
 * 
 * @param date
 * 
 * @return
 */
function goDate( date ){
	$('#hstr_date').val(date);
	$('#hstr_pageNum').val('1');
	$('#historyForm').submit();
}

/**
 * 좌,우,콘텐츠의 height를 비교해서
 * 가장 높은 height값을 style에 반영한다.
 * 
 * @param
 * 
 * @return
 */
function drawBotLine(){
	left_height = $('.nav_filter').height();
	cont_height = $('#contents').height();
	right_height = $('aside').height();
	
	if( cont_height < left_height || cont_height < right_height){
		if(left_height < right_height){
			$('#contents').attr('style','min-height:'+right_height+'px');
		}else if(right_height < left_height){
			$('#contents').attr('style','min-height:'+left_height+'px');
		}
	}
}

function getPageRange( ctgr_total ){
	var pageNum = 0;
	var pageSize = 0;
	var firstPage = 0;
	var lastPage = 0;
	var pageStr = "";
	
	pageNum = $('#hstr_pageNum').val();
	pageSize = $('#hstr_pageSize').val();
	
	lastPage = parseInt(pageNum) * parseInt(pageSize);
	firstPage = parseInt(lastPage-(parseInt(pageSize)-1));
	
	if(lastPage > ctgr_total)
		lastPage = ctgr_total;
	
	pageStr = firstPage + "-" + lastPage;
	
	return pageStr;
}

/**
 * 이미지 뷰어로 이동시키는 펑션
 * 
 * @param viewCnt
 * 
 * @return void
 */
function goImageViewer(viewCnt){
	$('#hstr_callLoc').val('viewer');
	$('#hstr_imageRowNo').val(viewCnt);
	$('#historyForm').attr('action','imageViewer.jsp');
	$('#historyForm').submit();
}

/**
 * 슬라이브 value를 계산하여, date달력에 넣는다.
 * 
 * @param 
 * 
 * @return void
 */
function translateSlideValue( value ){
	var dateValue = value / 10;
	
	if(dateValue == 0){
		$('#hstr_date').val('1');
	}else if(dateValue == 1){
		$('#hstr_date').val('7');
	}else if(dateValue == 2){
		$('#hstr_date').val('30');
	}else if(dateValue == 3){
		$('#hstr_date').val('365');
	}else{
		$('#hstr_date').val('all');
	}
	$('#hstr_pageNum').val('1');
}

/**
 * 날짜값이 제대로 되어 있는지 체크한다.
 * @param startDate
 * @param endDate
 */
function chkValidDate( date ){
	var valid = false;
	var year = 0;
	var month = 0;
	var day = 0;
	
	if(date.length == 8){ // YYYYMMDD 형식일 경우
		year = date.substring(0,4);
		month = date.substring(4,6);
		day = date.substring(6,8);
		
		if(year > 0 && month >= 1 && month <= 12 && day >= 1 && day <= 31)
			valid = true;
	}else if(date.length == 10){ // YYYY MM DD 형식일 경우
		year = date.substring(0,4);
		month = date.substring(5,7);
		day = date.substring(8,10);
		
		if(year > 0 && month >= 1 && month <= 12 && day >= 1 && day <= 31)
			valid = true;
	}
	
	return valid;
}

/**
 * 트리 데이터 검색
 * 
 * @param
 * 
 * @return
 */
function searchTreeData(){
	$('.treeData').bind('click',function(){
		dftSchKwd($(this).text());
	});
}

/**
 * 연도 데이터 체크시 반응
 * 
 * @param
 * 
 * @return
 */
function chkYearData(){
	$('.s_year > li > input').bind('click',function(){
		
		if(this.checked){
			if($(this).val() != 'all'){
				$('#s_year1').attr('checked',false);
			}else{
				$('.s_year > li > input').each(function(){
					if($(this).val() != "all"){
						$(this).attr('checked',false);
					}
				});
			}
		}
	});
}

/**
 * 달력 호출 펑션
 * callback method
 */
callCalender = function(){
	cal_input_layer = $(this),
						$cal = $('.calendar'),
						bt_posX = cal_input_layer.offset().left,
						bt_posY = cal_input_layer.offset().top,
						cal_X = bt_posX-73,
						cal_Y = bt_posY+17;
	
	cal_input_layer.parent().prev().children('input').attr('checked',true);		// 상세검색일 땐 user에 check 한다.
	
	var input_date = cal_input_layer.prev().val();
	
	if (input_date.length == 8){
		y 	= parseInt(input_date.substring(0, 4));
		m	= parseInt(input_date.substring(4, 6));
		d	= parseInt(input_date.substring(6, 8));
	}else{
		var tmp_date = new Date(); //오늘
		y	= tmp_date.getFullYear();
		m	= tmp_date.getMonth() + 1;
		d	= tmp_date.getDate();
	}
	
	calendar.drawCal(y,m,d);	// 달력 그려주기
	
	$cal.show().css({
		'top':cal_Y+'px',
		'left':cal_X+'px'
	});
},


/**
 * 토글 필터시 actions 
 * callback method
 * Jinhoo Jang Modified the Sinhyun's function
 */
filterChg = function(){
	var $this = $(this);
	var filter_nm = $(this).parent().parent().prev().text();
	if(filter_nm.trim() == "정렬"){
		goSort($this.text());
	}else if(filter_nm.trim() == "영역"){
		goSrchFd($this.text());
	}
};

/**
 * 조직도 minus <-> plus toggle actions 
 * callback method
 */
ctrFolder = function(e){
	var $this = $(this)
	var	$show = $this.siblings('ul');
						
	$this.toggleClass('active');
	if($this.hasClass('active')){
		$this.attr('src','images/ico_plus.gif').attr('alt','접기');
	}else{
		$this.attr('src','images/ico_minus.gif').attr('alt','펼치기');
		
	}
	
	$show.toggle();
	e.preventDefault();
};


/**
 * AJAX를 호출하기 위한 params을 리턴시켜주는 functions
 * 
 * @author Jinhoo Jang
 *  
 * @since 2012.04.26
 */
var AjaxParam = {
		
		/**
		 * 연도 필터 결과 가져오기.
		 * 
		 * @param
		 * 
		 * @return string(url)
		 */
		getYear : function(){
			var params = "";
			
			params += "kwd=" + $('#hstr_kwd').val();
			params += "&category=" + ctgr_cd;
			params += "&reSrchFlag=" + $('#hstr_reSrchFlag').val();
			params += "&pageNum=1";
			params += "&pageSize=1000";
			params += "&detailSearch=" + $('#hstr_detailSearch').val();
			params += "&srchFd=" + $('#hstr_srchFd').val();
			params += "&date=" + $('#hstr_date').val();
			params += "&startDate=" + $('#hstr_startDate').val();
			params += "&endDate=" + $('#hstr_endDate').val();
			params += "&fileExt=" + $('#hstr_fileExt').val();
			params += "&year=" + $('#hstr_year').val();
			
			$('#historyForm').children('input[name=\"preKwd\"]').each(function(){
				params += "&preKwd=" + $(this).val();
			});
			
			params += "&callLoc=filter";
			
			return params;
		},
		
		/**
		 * 조직 구조 가져오기
		 * 
		 * @param
		 * 
		 * @return string(url)
		 */
		getPersonTree : function(){
			var params = "";
			
			params += "kwd=" + encodeURIComponent($('#hstr_kwd').val());
			params += "&category=" + ctgr_cd;
			params += "&reSrchFlag=" + $('#hstr_reSrchFlag').val();
			params += "&pageNum=1";
			params += "&pageSize=1000";
			params += "&detailSearch=" + $('#hstr_detailSearch').val();
			params += "&srchFd=" + $('#hstr_srchFd').val();
			params += "&date=" + $('#hstr_date').val();
			params += "&startDate=" + $('#hstr_startDate').val();
			params += "&endDate=" + $('#hstr_endDate').val();
			
			$('#historyForm').children('input[name=\"preKwd\"]').each(function(){
				params += "&preKwd=" + $(this).val();
			});
			
			params += "&callLoc=filter";
			
			return params;
		},
		
		/**
		 * 첨부파일 내용 가져오기
		 * 
		 * @param
		 * 
		 * @return string(url)
		 */
		getFileCont : function( rowid ){
			var url = "./ajax/getFileCont.jsp?";
			
			var params = "";
			params += "rowid=" + rowid;
			params += "&kwd=" + encodeURIComponent($('#hstr_kwd').val());
			params += "&callLoc=preview";
			params = url + params;
			
			return params;
		}
		
};

/**
 * 통합검색 3 전용 Draw Util
 * 
 * @author Jinhoo Jang
 *  
 * @since 2012.04.26
 */
var DrawUtil = {
		/**
		 * 조직 구조 그리기
		 * 
		 * @param
		 * 
		 * @return
		 */
		drawFilterTree : function( data ){
			var tempArr = null;
			var depth = ["","",""];
			var FilterHtml = "";
			var cnt = 1;
			var short_flag = false;		 // 줄임말 사용여부
			var short_len = 5;			 // 줄임말 사용시 길이
			
			if(data.length > 0){
				FilterHtml += "<li>";
				FilterHtml += "<img src=\"images/ico_plus.gif\" width=\"9\" height=\"9\" class=\"hd_bt active\" alt=\"접기\" />";
				FilterHtml += "<label for=\"org1\">전체</label>";
				FilterHtml += "<ul>";
				
				for(var i=0; i<data.length; i++){
					tempArr = data[i].organization.split("^");
					
					if(short_flag == true && tempArr[1].length > short_len){
						tempArr[1] = tempArr[1].substring(0,short_len) + "...";
					}
					
					if(tempArr.length > 0){
						if(tempArr[0]!=depth[0]){		// 본부가 틀릴 경우
							if(i!=0){
								FilterHtml += "</ul>";
								FilterHtml += "</li>";
							}
							depth[0] = tempArr[0];
							FilterHtml += "<li>";
							FilterHtml += "<img src=\"images/ico_plus.gif\" width=\"9\" height=\"9\" class=\"hd_bt active\" alt=\"접기\" />";
							FilterHtml += "<label class=\"treeData\" for=\"org1-" + i+1 + "\">" + tempArr[0] + "</label>";
							FilterHtml += "<ul>";
							FilterHtml += "<li><label class=\"treeData\" for=\"org1-1-" + cnt +  "\">" + tempArr[1] + " </label></li>";
							
						}else{	// 본부가 같다면...
							FilterHtml += "<li><label class=\"treeData\" for=\"org1-1-" + cnt +  "\">" + tempArr[1] + " </label></li>";
						}
						cnt++;
					}
					
					tempArr = null;
				}
				
				FilterHtml += "</ul>";
				FilterHtml += "</li>";
				
				$('#org_m').html(FilterHtml);
			}
		},
		
		/**
		 * 연도 그리기
		 * 
		 * @param
		 * 
		 * @return
		 */
		drawFilterYear : function( data, $this ){
			var FilterHtml = "";
			var cnt = 1;
			
			if(data.length > 0){
				FilterHtml = "<li class=\"first\"><input type=\"checkbox\" id=\"s_year1\" value=\"all\" class=\"all_chk\" /><label for=\"s_year1\">전체</label></li>";
					
				for(var i=0; i<data.length; i++){
					if(data[i].year!=""){
						cnt++;
						FilterHtml += "<li><input type=\"checkbox\" id=\"s_year" + cnt + "\" value=\"" + data[i].year + "\" /><label for=\"s_year" + cnt + "\">"+ data[i].year +"년</label></li>";
					}
				}
				
				$('.s_year').html(FilterHtml);
			}else{
				$this.hide();
			}
		}		
};

/**
 * 리사이징시 show, hide 처리
 * 
 * @author Jinhoo Jang
 * 
 * @since 2012.06.11
 */
var ResizingDraw = {
		/**
		 * filter 처리
		 * 
		 * @param (size : 
		 * 
		 * @return
		 */
		drawFilter : function( sizeStatus ){
			var ctgr_cd = $('#var_category').val();
			if(sizeStatus < 2){	// wide 모드가 아닐 경우				
				if(ctgr_cd == 'PERSON' || ctgr_cd == 'NIMAGE'){	// 필터가 보이지 말아야 될 경우					
					$('.filter').hide();
					$('#contents').addClass('pos_ab');					
				}else if(ctgr_cd == 'SITE' || ctgr_cd == 'NNEWS'){ // 필터 더보기를 없애야 될 경우					
					$('.filter .bt_filter').hide();					
				}else if(ctgr_cd == 'DOCUMENT' || ctgr_cd == 'BOARD'){ // 체크 박스를 제거해야 되는 경우					
					$('#yearFilter').hide();
					$('#extFilter').hide();					
				}
			}else{	// wide 모드 일 경우
				if(ctgr_cd == 'PERSON'){
					$('.filter').show();
				}else if(ctgr_cd == 'DOCUMENT'){
					$('#yearFilter').show();
					$('#extFilter').show();
				}else if(ctgr_cd == 'BOARD'){
					$('#yearFilter').show();
				}
			}
		}
};

