/*******************************************************
* 프로그램명 	 : calendar.js 
* 설명        : 표준화 3차 통합검색 전용 달력 스크립트(Jquery)
* 작성일      : 2012.05.11
* 작성자      : 장진후
* 수정내역    :
  *****************************************************/

var calendar = {
		
	/**
	 * 달력을 그리는 함수
	 */
	drawCal : function( y, m, d ){
		
		//오늘날짜 정보
		var todayis = new Date();
		var today_year 	= todayis.getFullYear();
        var today_month = todayis.getMonth() + 1;
        var today_day 	= todayis.getDate();
        var calHtml = "";
        
		// 월, 년도  선택       
        calHtml += ' <div class="in_box">';
        calHtml += '	<table>';
        calHtml += '		<caption>';
        calHtml += '			<a href="javascript:calendar.preMonth('+y+','+m+','+d+',-1);"><img src="images/bt_calendar_l.gif" width="8" height="15" alt="이전월" /></a>';
        calHtml += '			<span>';
        calHtml += '				<select onchange="calendar.drawCal(this.value,'+m+','+d+');" title="기간선택">';
        
        for(var i=(parseInt(y)-3); i<=(parseInt(y)+3); i++){
			if (i == y)
				calHtml += '      		<option selected value='+i+'>'+ i +'년</option>';
			else
				calHtml += '      		<option value='+i+'>'+ i +'년</option>';
		}
                
        calHtml += '				</select>';
        calHtml += '				<select onchange="calendar.drawCal('+y+',this.value,'+d+');" title="기간선택">';
        
        for (var i=1; i<=12; i++){
			if ( i == m ){
				calHtml += ' 	  <option selected value='+i+'>'+ i +'월</option>';
			}else{
				calHtml += ' 	  <option value='+i+'>'+ i +'월</option>';
			}
		}
        
        calHtml += '				</select>';
        calHtml += '			</span>';
        calHtml += '			<a href="javascript:calendar.preMonth('+y+','+m+','+d+',1);"><img src="images/bt_calendar_r.gif" width="8" height="15" alt="다음월" /></a>';
        calHtml += '		</caption>';
        
        // 요일 출력
        calHtml += '		<thead>';
        calHtml += '			<tr>';
        calHtml += '				<th scope="col" class="sun">일</th>';
        calHtml += '				<th scope="col">월</th>';
        calHtml += '				<th scope="col">화</th>';
        calHtml += '				<th scope="col">수</th>';
        calHtml += '				<th scope="col">목</th>';
        calHtml += '				<th scope="col">금</th>';
        calHtml += '				<th scope="col" class="sat">토</th>';
        calHtml += '			</tr>';
        calHtml += '		</thead>';
        	
        // 일 출력
        calHtml += '		<tbody>';
        calHtml += '			<tr>';
                
		var d1 = (y+(y-y%4)/4-(y-y%100)/100+(y-y%400)/400 
			  +m*2+(m*5-m*5%9)/9-(m<3?y%4||y%100==0&&y%400?2:3:4))%7; 
		
		var lineCheck = 0;
		  
		for (i = 0; i < 42; i++) { 
			if (i%7==0) 
				calHtml += '</tr>\n<tr>'; 
			
			if (i%7==0 && i>=31 && !(lineCheck >= 29)) 
				break;
			
			if (i < d1 || i >= d1+(m*9-m*9%8)/8%2+(m==2?y%4||y%100==0&&y%400?28:29:30)){ 
				calHtml += '<td> </td>'; 
				lineCheck = 0;
			}else{
				var style_text = '';

				// today
				if (( (i+1-d1) )==today_day && m==today_month && y==today_year){
					style_text = 'class="today"';
				}
				
				// select된 날짜 디자인
				if ( (i+1-d1)  == d )
					style_text = 'class="select"';
								
				calHtml += '<td ' + style_text+ '><a href="#none">' + (i+1-d1) + '</a></td>';
			}
			lineCheck = i+1-d1;
		} 
		
		calHtml += '</tr>'; 
		calHtml += '</tbody>'; 
		calHtml += '</table>'; 
		calHtml += '</div>'; 
		calHtml += '<div class="c_close"><img src="images/bt_c_close.gif" width="11" height="13" class="c_point" alt="닫기" /></div>'; 
				
		$('.calendar').html(calHtml);
		
		$('.in_box tbody tr td a').each(function(){
			if($(this).text() != ""){
				$(this).bind('click',function(){
					var year = $('.in_box table caption span').children().eq(0).val();
					var month = $('.in_box table caption span').children().eq(1).val();
					var day = $(this).text();
					
					if(month < 10)
						month = "0" + month;
					
					if(day < 10)
						day = "0" + day;
					
					var sel_date = year + month +day;
					
					cal_input_layer.prev().val(sel_date);
					
					$('#hstr_date').val('user');
				});
			}
		});
		
		$('.calendar td a, .calendar .c_close').on('click', function(e){
			$('.calendar').hide();
			e.preventDefault();
		});
	},
	
	/***********************************************************************
	*
	*  ※ 주의 : 아래쪽 코드는  변경할 필요 없습니다 !!!!!!   ^_^
	*                  
	***********************************************************************/
	
	//////////////////////////////////////////////////////////////////
	// 버튼 이벤트
	//////////////////////////////////////////////////////////////////

	/**
	* ago년 전후 출력 (작년, 내년)
	*
	* @ param   y			- YYYY   년도
	* @ param   m			- MM      월
	* @ param   d			- DD        일
	* @ param   ago			- ago년 전후
	* 
	* @ return   			-   void
	**/	
	preYear : function(y,m,d,ago){
		var tmpdate = new Date(parseInt(y)+parseInt(ago), parseInt(m)-1, d);
		this.drawCal(tmpdate.getFullYear(),  tmpdate.getMonth() + 1,  tmpdate.getDate());
	},
	
	/**
	* ago월 전후 출력  (전달, 다음달)
	*
	* @ param   y			- YYYY   년도
	* @ param   m			- MM      월
	* @ param   d			- DD        일
	* @ param   ago			- ago월 전후
	* 
	* @ return   			-   void
	**/	
	preMonth : function (y,m,d,ago)	{
		var tmpdate = new Date(parseInt(y), parseInt(m)-1+parseInt(ago), d);
		this.drawCal(tmpdate.getFullYear(),  tmpdate.getMonth() + 1,  tmpdate.getDate());
	}
};