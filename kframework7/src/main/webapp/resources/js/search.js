/*******************************************************
* 프로그램명 	 : search.js 
* 설명           : 표준화 3차 통합검색 전용 액션 스크립트
* 작성일         : 2012.04.12
* 작성자         : 장진후
* 수정내역     	 :
  *****************************************************/

/**
* onload시 실행되는 functions
*/
$(document).ready(function(){
	ctgrAction();		// 카테고리 액션
	filterAction();		// 필터 액션
	detailAction();		// 상세검색 액션
	previewAction();	// 미리보기 액션
	
	

	//페이지 액션
	// 페이지 더보기 클릭시
	$('.result_more').bind('click',function(){
		var ctgr_nm = $(this).parent().children('h3').text();
		var ctgr_cd = rtnCtgrVal(ctgr_nm, 0);
		goCategory(ctgr_cd);
	});
	
	// 슬라이드 액션	
	$( "#slider-range-min" ).slider({
		slide: function( event, ui ) {
			translateSlideValue(ui.value);			
		}
	});	
	
	// 슬라이드 라디오 액션
	$('.slide_filter input:radio').on('click', clickSlider);
	
	// 이전페이지로 돌아가기
	$('.bt_area a').first().bind('click',function(){
		history.back();
		return false;	// chrome, safari 대응
	});
	
	// 달력 액션
	$('.bt_cal').on('click',callCalender);
	
	// 위로가기버튼
	$('.bt_top').on('click', function(e){
		$(window).scrollTop(0);
		e.preventDefault();
	});
	
	//$('body.wide .a_section h3 a').live('click', relateCtrollWide);
	
	$('.bt_self_input').on('click', function(e){
		calender_flag = true;
		$('.slide_filter').hide();
		$('.user_sch').show();
		e.preventDefault();
	});
	
	// 기간입력방식 선택
	$('.bt_slider').on('click', function(e){
		$('.user_sch').hide();
		$('.slide_filter').show();
		e.preventDefault();
	});	
	
	
	// 재검색
	$('.re_sch').on('click',function(){
		if(navigator.appVersion.indexOf('MSIE 7.0') != -1 || navigator.appVersion.indexOf('MSIE 8.0') != -1){this.click()}
	});
	
});

/**
 * 카테고리 관련 actions
 */
function ctgrAction(){
	
	/*
	 * 카테고리 네비게이션 클릭 시
	 */
	$('#left > ul > li').bind('click', function(){
		if(!$(this).hasClass('nav_more')){
			var ctgr_nm = $(this).text();	
			var ctgr_cd = rtnCtgrVal(ctgr_nm, 0);
			goCategory(ctgr_cd);
		}
	});
	
	/*
	 * 카테고리 더보기 클릭 시
	 */
	$('.nav_more a').on('click', function(e){
		var $this = $(this);
		$this.toggleClass('active');
		$('nav li.nav_etc').slideToggle();
		
		if($this.hasClass('active')){			
			$this.text('접기');
		}else{
			$this.text('더보기');
		}
		e.preventDefault();
	});
}

/**
 * 필터 관련 actions
 */
function filterAction(){ 
	// 날짜값 검색
	$('.slide_filter input').next().bind('click',function(){		
		goDate($(this).prev().val());
	});
	
	//필터 컨트롤
	$('.filter_tab li').on('click', filterChg);
	$('#bt_view_sum button').on('click', viewType);
	$('.filter .bt_filter').on('click', ctrFilter);
	
	// 첨부문서 클릭시 액션
	$('.file_type > li > input').bind('click',function(){		
		if(this.checked){
			if($(this).val() != 'all'){
				$('#filechk1').attr('checked',false);
			}else{
				$('.file_type > li > input').each(function(){
					if($(this).val() != "all"){
						$(this).attr('checked',false);
					}
				});
			}
		}
	});
	
	// 검색 버튼 액션
	$('.bt_filter_sch').bind('click',function(){
		var tempStr = "";
		
		// 파일확장자
		if($('.file_type').parent('dd').parent('dl').css('display') == 'block'){
			tempStr = "";
			$('.file_type > li > input').each(function(){
				if(this.checked)
					tempStr += $(this).val() + "_";				
			});
			
			if(tempStr.length > 0)
				tempStr = tempStr.substring(0, tempStr.length-1);
			$('#hstr_fileExt').val(tempStr);
		}
		$('#hstr_pageNum').val('1');
		$('#historyForm').submit();
	});
	
	// 날짜 검색 버튼 액션
	$('.ta_r input').bind('click',function(){		
		var startDate = $('.user_sch ul li input').eq(0).val();
		var endDate = $('.user_sch ul li input').eq(1).val();
		
		if((startDate.length == 8 || startDate.length == 10) && (endDate.length == 8 || endDate.length == 10)){
			if(chkValidDate(startDate) && chkValidDate(endDate)){
				$('#hstr_startDate').val(startDate);
				$('#hstr_endDate').val(endDate);
				$('#hstr_pageNum').val('1');
				$('#historyForm').submit();			
			}else{
				alert("날짜 형식이 잘못되었습니다. YYYY.MM.DD");
				return false;
			}
		}else{
			alert("날짜 형식이 잘못되었습니다. YYYY.MM.DD");
			return false;
		}
	});
}


/**
 * 미리보기 액션
 * 
 * @param
 * 
 * @return
 */
function previewAction(){
	
	//미리보기 레이어
	$('.bt_preview').bind('click', function(e){
		
	/*	if($(this).siblings('.preview_box').css('display') == 'none'){
			var rowid = $(this).siblings('.preview_box').children('.rowid').text();
			$(this).siblings('.preview_box').children('.in_box').load(AjaxParam.getFileCont(rowid));
		}*/
		
		$(this).siblings('.preview_box').fadeToggle();
		
		e.preventDefault();
	}); 
	
	$('.preview_box .bt_close').bind('click', function(e){
		$(this).parent('.preview_box').fadeOut();
		e.preventDefault();
	});
	
}



/**
 * 상세검색 액션
 * 
 * @param
 * 
 * @return
 */
function detailAction(){
	
	// 상세검색 버튼
	$('.ctr_detail').bind('click', function(e){
		
		if($('body').hasClass('type_abs')){
			if($('.sch_setting').css('display') == "none"){
				$('.sch_setting').show('fast');
			}else{				
				$('.calendar').hide();
				$('.sch_setting').hide('fast');				
			}
		}else{			
			$('.calendar').hide();
			$('.sch_setting').slideToggle();
		}		
		e.preventDefault();
	});
	
	// 레이어 닫기 버튼
	$('.sch_setting .bt_sch_setting').bind('click', function(e){
		$('.calendar').hide();
		
		if($('body').hasClass('type_abs')){			
			$('.sch_setting').hide('fast');			
		}else{
			$('.sch_setting').slideToggle();
		}		
		e.preventDefault();
	});
	
	// 첨부파일 check 액션
	$('#detailFile input').bind('click', function(){
		if(this.checked){
			if($(this).val() != 'all'){
				$('#setting5-1').attr('checked',false);
			}else{
				$('#detailFile input').each(function(){
					if($(this).val() != "all"){
						$(this).attr('checked',false);
					}
				});
			}
		}
	});
	
	// 검색 액션
	$('#detailSearchForm').submit('click',function(){
		var chkDate = "";
		
		if($('#detailKwd').val()==""){
			alert("키워드를 입력하여 주십시오.");
			return false;
		}
		
		
		// 첨부파일 확장자
		var tempStr = "";
		$('#detailFile input').each(function(){
			if(this.checked){
				tempStr += $(this).val() + "_";
			}
		});
		
		if(tempStr.length > 0){
			tempStr = tempStr.substring(0, tempStr.length-1);
		}
			
		$('#detl_fileExt').val(tempStr);
		
		// 날짜 검색 버튼 액션		
		$('#detailDate input').each(function(){			
			if(this.checked){
				if($(this).val() == "user"){
					chkDate = "user";
				}
			}
		});
		
		if(chkDate == "user"){
			var startDate = $('#detailDate .day_self input').eq(0).val();
			var endDate = $('#detailDate .day_self input').eq(1).val();
				
			if((startDate.length == 8 || startDate.length == 10) && (endDate.length == 8 || endDate.length == 10)){
				if(chkValidDate(startDate) && chkValidDate(endDate)){
					$('#hstr_startDate').val(startDate);
					$('#hstr_endDate').val(endDate);
					$('#historyForm').submit();			
				}else{							
					alert("날짜 형식이 잘못되었습니다. YYYY.MM.DD");
					return false;
				}
			}else{						
				alert("날짜 형식이 잘못되었습니다. YYYY.MM.DD");
				return false;
			}
		}		
	});
	
	// 메인 페이지 검색 액션(main.jsp)
	$('#searchForm').submit('click',function(){
		if($('#topKwd').val()==""){
			alert("키워드를 입력하여 주십시오.");
			return false;
		}
	});
	
	// 레이어 초기화 버튼
	$('.reset').bind('click',function(){
		$('#detailKwd').val('');			   // 키워드 제거
		$('#setting1-1').attr('checked',true); // 메뉴 통합검색
		$('#setting2-1').attr('checked',true); // 영역 전체
		$('#setting3-1').attr('checked',true); // 기간 전체
		$('#setting4-1').attr('checked',true); // 정렬 전체

		// 첨부파일 전체
		$('#detailFile input').each(function(){
			if($(this).val() != "all"){
				$(this).attr('checked',false);
			}else{
				$(this).attr('checked',true);
			}
		});
	});	
}
function filepreview(){
	
	//alert("asdfs");
	//$(this,'.preview_box').show();
	var $base = $(this).parents(".media:first"),
	$that = $base.find(".preview_box");
	$that.show();
	/*$('.preview label label-default').bind('click', function(e){
		$(this).parent('.preview_box').fadeOut();
		e.preventDefault();
	});*/
}

