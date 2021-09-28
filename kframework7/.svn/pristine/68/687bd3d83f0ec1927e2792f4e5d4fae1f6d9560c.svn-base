/*******************************************************
* 프로그램명 	 : init.js 
* 설명           : 통합검색 초기화용 스크립트
* 작성일         : 2012.04.12
* 작성자         : 장진후
* 수정내역     	 :
  *****************************************************/

// 0: 카테고리명, 1:카테고리코드, 2:카테고리네비게이션 view or more, 3: 사용할 필터리스트 4: 검색건수
var ctgr_arr = [["통합검색","TOTAL","","","view","정렬,영역,기간",0],
                ["인물","PERSON","","","view","조직",0],
                ["사이트","SITE","사이트","SITE","view","영역",0],
                ["게시판","BOARD","","","view","정렬,영역,기간,연도",0],
                ["문서","DOCUMENT","","","view","정렬,영역,기간,연도,첨부문서",0]];

var ctgr_cnt = ctgr_arr.length;
var ctgr_nm = "";
var ctgr_cd = "";
var sub_ctgr_cd = "";
var ctgr_page_size = 0;
var ctgr_page_cnt = 0;
var detl_show = 1;		// 상세 검색 후 창 유지 플래그   0 : 유지 안함, 1 : 유지함

var left_height = 0;
var sizeStatus = 2;		// 2: wide, 1:midium, 0;narrow
var width = 0;
var left_height = 0;
var right_height = 0;
var cont_height = 0;


/**
 * 통합검색 초기화 메인 메소드
 */
$(document).ready(function(){	
	width = $(this).width();	//사이즈 설정
	
	// IE,사파리 캐쉬 버그
	$('#topKwd').val($('#var_kwd').val());
	$('#botKwd').val($('#var_kwd').val());

	if(width < 481){ // narrow
		sizeStatus = 0;
	}else if(width > 480 && width < 801){ // midium
		sizeStatus == 1;
	}else{	// wide
		sizeStatus == 2;
	}	
		
	topScroll();	// 맨위로 가기 버튼
	setResize();	// 창 크기에 맞게 초기화
	initVariable();	// 전역변수 세팅
	ctgrInit();		// 카테고리 세팅
	moduleInit();	// 모듈 세팅
	filterInit();	// 필터 세팅
	detailInit();	// 상세검색 세팅
	
	
	// 슬라이드 박스 세팅
	if($('#slider-range-min')){
		var slide_val = "";
		
		switch($('#hstr_date').val()){
			case "1" :
				slide_val = 0;
				break;
			case "7" :
				slide_val = 10;
				break;
			case "30" :
				slide_val = 20;
				break;
			case "365" :
				slide_val = 30;
				break;
			default :
				slide_val = 40;
				break;
		}
		
		$( "#slider-range-min" ).slider({
			range: "min",
			value: slide_val,
			min: 0,
			max: 40
		}); //기간 슬라이더
	}
	
	// 체크박스 유지
	if($('#var_reSrchFlag').val() == "true"){
		$('#chk_re_chk').attr('checked',true);
	}
	
	$(window).on('resize load', reSizeControll);		// resize시 호출
	
	drawBotLine();
	
	
});

/**
* 카테고리 초기화 
*
* @ param 
*
* @ return	void		
**/
function ctgrInit(){
	if(ctgr_cd == "") 
		ctgr_cd = "TOTAL";
	
	ctgr_nm = rtnCtgrVal(ctgr_cd,1);
	
	// 카테고리 selected 로직
	$('#left > ul > li').each(function(){
		if($(this).text() == ctgr_nm)
			$(this).addClass("selected");
	});
	
	// 모바일 카테고리 타이틀에 현재 카테고리값 대입
	$('.m_title').append('<a href="#none">' + ctgr_nm + '<span></span></a>');
	

	// 모바일 카테고리 클릭 시 액션
	$('.m_title > a').on('click', navCtroll);
}


/**
 * 필터 초기화
 * 
 * @param
 * 
 * @return
 */
function filterInit(){
	
	// 변수에 설정된 필터값을 불러들인다.
	var filter = rtnCtgrFilter(ctgr_cd);
	var filter_lst = "";
	var $this;
	
	right_height = $('aside').height();
	
	if(filter!=""){
		filter_lst = filter.split(',');
		
		$('.filter > dl').each(function(){
			// 카테고리 배열의 필터 정보를 가져와서 해당 필터를 활성화 시킨다.
			for(var i=0; i<filter_lst.length; i++){
				if($(this).children('dt').text()==filter_lst[i]){
					$(this).show();
				}
			}
		});
		
		// 확장자 검색 필터 초기화
		$('.file_type > li > input').each(function(){
			if($('#hstr_fileExt').val().indexOf($(this).val()) > -1){
				$(this).attr('checked',true);
			}
		});
		
		// 브라우져 체크하여 달력 생성
		if(mobileFlag == false){
			$('.user_sch .in_txt').each(function(){
				$(this).after(" <a href=\"#none\" class=\"bt_cal\"><img src=\"images/bt_calender.gif\" width=\"15\" height=\"16\" alt=\"달력선택\" /></a>");
			});
		}
		
		// 날짜 검색이 User일 경우, slide box hidden 처리
		if($('#hstr_date').val() == "user"){
			$('.slide_filter').hide();
			$('.user_sch').show();			
		}
		
		// 슬라이드 hidden radio box에 값을 넣는다.
		$('.slide_filter input').each(function(){
			$(this).next('label').removeClass('selected');
			if($(this).val() == $('#var_date').val()){
				$(this).attr('checked',true);				
				$(this).next('label').addClass('selected');
			}			
		});
	}
}

/**
 * 모듈 초기화
 * 
 * @param
 * 
 * @return
 */
function moduleInit(){
	$('body.midium .word_rank h3 a, body.narrow .word_rank h3 a').on('click', relateCtroll); //word_rank
	$('body.midium .word_recommend h3 a, body.narrow .word_recommend h3 a').on('click', relateCtroll); //word_recommend
	
	$('#relate_word').relateWord(); //관련어
	drawSearchedKwd();		// 최근검색어 리스트 출력
	
	// 인기검색어 액션 처리
	$('.word_rank > div > ol > li > a').bind('click',function(){
		dftSchKwd($(this).text());
	});
	
	// 관련어 액션 처리
	$('#relate_word > div > ul > li > a').bind('click',function(){
		dftSchKwd($(this).text());
	});
	
	insertEl();
	$('.ctr_hot_keyword a').on('click', hotKeyword);
}

/**
 * 상세검색 초기화
 * 
 * @param
 * 
 * @return
 */
function detailInit(){
	// 카테고리값을 가져와서 카테고리 input 세팅
	for(var i=0; i<ctgr_arr.length; i++){
		if(ctgr_arr[i][4] == "view" || ctgr_arr[i][4] == "more"){
			if(ctgr_arr[i][1] == ctgr_cd){
				$('#detailCtgr').append("<label for=\"setting1-" + (i+1) + "\"><input type=\"radio\" name=\"category\" value=\"" + ctgr_arr[i][1] + "\" checked id=\"setting1-" + (i+1) + "\">" + ctgr_arr[i][0] + "</label>");	
			}else{
				$('#detailCtgr').append("<label for=\"setting1-" + (i+1) + "\"><input type=\"radio\" name=\"category\" value=\"" + ctgr_arr[i][1] + "\" id=\"setting1-" + (i+1) + "\">" + ctgr_arr[i][0] + "</label>");
			}
			
		}
	}
	
	// 영역 checked(Radio Box)
	$('#detailSrchFd input').each(function(){
		if($(this).val() == $('#hstr_srchFd').val()){
			$(this).attr('checked',true);
		}
	});
	
	// 기간 checked(Radio Box)
	$('#detailDate input').each(function(){
		if($(this).val() == $('#hstr_date').val()){
			$(this).attr('checked',true);
		}
	});
	
	// 정렬 checked(Radio Box)
	$('#detailSort input').each(function(){
		if($(this).val() == $('#hstr_sort').val()){
			$(this).attr('checked',true);
		}
	});
	
	// 첨부파일 checked
	$('#detailFile input').each(function(){
		if($('#hstr_fileExt').val().indexOf($(this).val()) > -1){
			$(this).attr('checked',true);
		}
	});
	
	// 데스크탑 브라우져일 경우 달력 생성
	if( mobileFlag == false ){
		$('.day_self').children().first().after(' <a href="#none" class="bt_cal"><img src="images/bt_calender.gif" width="15" height="16" alt="날짜 선택"></a> -');
		$('.day_self').children().last().after(' <a href="#none" class="bt_cal"><img src="images/bt_calender.gif" width="15" height="16" alt="날짜 선택"></a>');
		// readonly 속성 부여
		$('.day_self').children().attr('readonly',true);
	}else{
		$('.day_self').children().first().after(' - ');		
	}
	
	// 상태 유지 실행
	if(detl_show == 1 && $('#var_detailSearch').val() == "true"){	// 1이면 실행
		$('.sch_setting').show();
	}
}

/**
 * 리사이징시 두번 호출하지 않게 하기 위한 펑션
 * 
 * @param
 *  
 * @return void
 */
function reSizeControll(){
	
	width = $(this).width();	
	
	if(width < 481){ // if narrow
		if(sizeStatus != 0){
			sizeStatus = 0;
			setResize();
		}
	}else if(width > 481 && width < 800){ // if midium
		if(sizeStatus != 1){
			sizeStatus = 1;
			setResize(); 
		}
	}else{
		if(sizeStatus != 2){
			sizeStatus = 2;
			setResize();
		}
	}
}

/**
 * type이 변경되었을 때 이루어져야 될 액션...
 * 
 * @param
 *  
 * @return void
 */
function setResize(){
	if(sizeStatus == 0){ // if narrow
		$('.word_rank h3 a').html('인기검색');
		$('.word_recommend h3 a').html('최근검색');
		$('.result_more a').html('더보기') ;
		$('body').addClass('narrow').removeClass('wide').removeClass('midium');
		$('.keyword').width('');
		// 달력 삭제
		$('.user_sch').hide();
		$('.slide_filter').show();
		
	}else if(sizeStatus == 1){ // if midium
		$('.word_rank h3 a').html('인기검색어');
		$('.word_recommend h3 a').html('최근검색어');
		for (var i = 0; i<$('.keyword').size(); i++){
			$('.keyword').eq(i).width($('.keyword').eq(i).siblings('.in_header').children('.serch').width()+27);
		}
		for (var i = 0; i<$('footer .keyword').size(); i++){
			$('footer .keyword').eq(i).width($('footer .keyword').eq(i).siblings('.serch').width()+27);
		}
		for(var i = 0; i<$('.result_more a').size(); i++){
			var $this = $('.result_more a').eq(i),
								html_origin = $('.result_more a').eq(i).parent().parent('.contents_df').find('h3').html();
			$this.html(html_origin+' 더보기') ;
		}		
		$('body').addClass('midium').removeClass('wide').removeClass('narrow');
		
	}else{  //if wide
		$('.word_rank h3 a').html('인기검색어');
		$('.word_recommend h3 a').html('최근검색어');
		
		for(var i = 0; i<$('.result_more a').size(); i++){
			var $this = $('.result_more a').eq(i),
								html_origin = $('.result_more a').eq(i).parent().parent('.contents_df').find('h3').html();
			$this.html(html_origin+' 더보기') ;
		}
		$('body').addClass('wide').removeClass('midium').removeClass('narrow');
	}
	
	// 필터 액션
	ResizingDraw.drawFilter(sizeStatus);
	
	if(ctgr_page_size > 0){ // 페이징이 가능할 경우
		$('.paging').html((pageNav("gotoPage", $('#var_pageNum').val(), ctgr_page_size, ctgr_page_cnt, sizeStatus)));
	}
	
	drawBotLine();
}

/**
 * 자바 전역 변수 세팅
 * input -> javascript variable
 * 
 * @param
 * 
 * @return
 */
function initVariable(){
	ctgr_cd = $('#var_category').val();
	sub_ctgr_cd = $('#var_subCategory').val();
	
	ctgr_arr[1][6] = $('#tot_person').val();
	ctgr_arr[2][6] = $('#tot_site').val();
	ctgr_arr[3][6] = $('#tot_board').val();
	ctgr_arr[4][6] = $('#tot_document').val();
}