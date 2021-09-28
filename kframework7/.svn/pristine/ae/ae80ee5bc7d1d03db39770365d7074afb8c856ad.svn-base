$().ready(function(){
	$('body.wide .a_section h3 a').live('click', relateCtrollWide);
	
	$('.slide_filter input:radio').on('click', clickSlider); //기간 슬라이더
	
	$('.bt_self_input').on('click', function(e){
		calender_flag = true;
		$('.slide_filter').hide();
		$('.user_sch').show();
		e.preventDefault();
	});
	
	$('.bt_slider').on('click', function(e){
		$('.user_sch').hide();
		$('.slide_filter').show();
		e.preventDefault();
	}); //기간입력방식 선택	
	
	$('.cate_person li:last-child, .list_df li:last-child').addClass('last');
})

