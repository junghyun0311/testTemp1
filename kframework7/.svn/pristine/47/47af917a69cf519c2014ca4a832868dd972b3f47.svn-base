var imgNo = 0;	// 이미지 번호
var totNo = 0;  // 총 로우 개수


$().ready(function(){	
	var $wrapper = $('.preview_box'),
		$sumbox = $('.sumbox'),
		$top_bt = $('.top_bt'),
		$in_pos_box = $('.in_pos_box'),
		$photo_box = $in_pos_box.find('>ul'),
		$list_photo = $photo_box.find('li'),
		$photo_box_bt_prev = $wrapper.find('.bt_prev'),
		$photo_box_bt_next = $wrapper.find('.bt_next'),
		$data_info = $('.data_info'),
		$bt_sum_prev = $('.sumbox .bt_sum_prev'),
		$bt_sum_next = $('.sumbox .bt_sum_next'),
		$list_sum = $('.list_sum li'),
		_sum_outerWidth = $list_sum.outerWidth()+10,
		_sum_size = $list_sum.size();	
	
	var photoMove = function (index) {
		
		
		// photo
		/*
		var photoLis = $photo_box.find('li');
		
		photoLis.removeClass('prev');
		photoLis.removeClass('selected');
		photoLis.removeClass('next');

		if (index > 0) {
			photoLis.eq(index - 1).addClass('prev');
		}
		photoLis.eq(index).addClass('selected');
		if (index < (_sum_size - 1)) {
			photoLis.eq(index + 1).addClass('next');
		}
		*/
		// sum
		$list_sum.removeClass('selected');
		$list_sum.eq(index).addClass('selected');
		
	};


	$list_sum.find('a').on('click', function() {
		var li = $(this).parent(),
			index = li.index();

		photoMove(index);
	});

	/*
	$wrapper.on('click', 'li.prev a, .bt_prev', function() {
		var li = $photo_box.find('li.selected'),
			index = li.index()-1;

		if (index > -1) {
			photoMove(index);
		}
		
			$bt_sum_next.trigger('sum_pos_right');
		
	});
	
	
	$wrapper.on('click', 'li.next a, .bt_next', function() {
		var li = $photo_box.find('li.selected'),
			index = li.index()+1;

		if (index < (_sum_size)) {
			photoMove(index);
			$bt_sum_prev.trigger('sum_pos_left');
		}

		
		
	});
	*/
	
	$bt_sum_prev.on('click sum_pos_left', function(){		
		if (-(parseInt($('.list_sum ul').css('margin-left'), 10)) == (_sum_size - 1) * _sum_outerWidth) {
			return;
		}

		$('.list_sum ul').css('margin-left', parseInt($('.list_sum ul').css('margin-left'), 10) -_sum_outerWidth);
		$('.list_sum ul').width($('.list_sum ul').width()+_sum_outerWidth)
	});
	
	$bt_sum_next.on('click sum_pos_right', function(){		
		if(parseInt($('.list_sum ul').css('margin-left'), 10) === 0) {
			return;
		}

		$('.list_sum ul').css('margin-left', parseInt($('.list_sum ul').css('margin-left'), 10) +_sum_outerWidth);
		$('.list_sum ul').width($('.list_sum ul').width()-_sum_outerWidth)
	});
	
	$(window).on('load resize', function(){
		$('.list_sum ul').width($(window).width() - 180 + (-parseInt($('.list_sum ul').css('margin-left'), 10)));

		var _window_height = document.documentElement.clientHeight,
			_total_width = $wrapper.width();

		
		
		if($(this).width()>480){
			var _total_height = _window_height-($sumbox.height()+$top_bt.height()+1);
			$wrapper.height(_total_height);
			if (_total_width < 970) {
				$photo_box.width(640 - (970 - _total_width));
				$photo_box.height(480 - (970 - _total_width));
				$in_pos_box.css('margin-top', (($wrapper.height()-$in_pos_box.height()-$data_info.height())/2));

			} else if (_total_height < 590) {
				$photo_box.width(640 - (590 - _total_height));
				$photo_box.height(480 - (590 - _total_height));

				$in_pos_box.css('margin-top', 0);
			} else {
				$in_pos_box.css('margin-top', (($wrapper.height()-$in_pos_box.height()-$data_info.height())/2));
			}
		}else{
			var _total_height = _window_height-($top_bt.height()+1);
			$wrapper.height(_total_height);
			$photo_box.width(_total_width - 60);
			$photo_box.height(parseInt($photo_box.width() * (2/3), 10));
			$in_pos_box.css('margin-top', (($wrapper.height()-$in_pos_box.height()-$data_info.height())/2));
		}
	});

	

	
	var in_pos_box = $('.in_pos_box'),
		container,
		prevImg,
		nextImg,
		selectedImg,
		startX,
		curX;
	
	in_pos_box.on('touchstart', 'li.selected', function (e) {
		e.preventDefault();
		//클릭시 등록엘리먼트 갱신
		li = $(this); //li.selected
		prevImg = li.prev('li').find('img').clone().addClass('clone_img_left');  // 프리브 이미지
		nextImg = li.next('li').find('img').clone().addClass('clone_img_right'); // 넥스트 이미지
		selectedImg = li.find('img'); // 현재 이미지
		
		startX = curX = (e.originalEvent && e.originalEvent.touches) ? e.originalEvent.touches[0].pageX : e.pageX;
		//startX = 최초 좌표 기억,
		//curX = 좌표 움직인거리 캐치
		
		prevImg.insertBefore(selectedImg);
		nextImg.insertAfter(selectedImg);
		
		li.on('touchmove', onTouchMove);
		li.on('touchend', onTouchEnd);
		//마우스 다운상태에만 이벤트 등록
	});

	
	function onTouchMove(e) {
		
		e.preventDefault();
		
		li = $(this);
		var pageX = (e.originalEvent && e.originalEvent.touches) ? e.originalEvent.touches[0].pageX : e.pageX;
		//현재 좌표 pageX에 등록
		
		var gap = pageX - curX;
		//움직인 거리 gap에 등록
		
		container = li.find('a');
		var currentMarginLeft = parseInt(container.css('marginLeft'), 10);
		container.css('marginLeft', currentMarginLeft + gap);
		
		curX = pageX;
		//현재좌표 curX에 갱신
	}
	
	function onTouchEnd(e) {
		e.preventDefault();
		
		li = $(this);
		container = li.find('a');
		
		container.css('marginLeft', 0);
		//초기화
		
		if (startX > curX) { 
			// next
			var $li = $photo_box.find('li.selected'),
					index = $li.index()+1;
		
				if (index < (_sum_size)) {
					photoMove(index);
					$bt_sum_prev.trigger('sum_pos_left');
				}
		} else {
			// prev
			var $li = $photo_box.find('li.selected'),
					index = $li.index()-1;
		
				if (index > -1) {
					photoMove(index);
				}
				
					$bt_sum_next.trigger('sum_pos_right');
		}
		
		prevImg.remove();
		nextImg.remove();
		//초기화
		
		li.off('touchmove', onTouchMove);
		li.off('touchend', onTouchEnd);
		//이벤트 핸들러 삭제
	}
	
	imageViewAction();
})

/**
 * 이미지 뷰어 액션
 * 
 * @param
 * 
 * @return
 */
function imageViewAction(){
	var $list_sum = $('.list_sum li'),
	_sum_outerWidth = $list_sum.outerWidth()+10,
	_sum_size = $list_sum.size();
	
	// 검색결과 리스트 액션
	$('.bt_result_list').bind('click',function(){
		$('#historyForm').submit();
	});
	
	// 썸네일 이미지 선택시 액션
	$('.list_sum ul li').bind('click',function(){
		selectImg(0);
	});
	
	// prev 화살표 선택시 액션
	$('.bt_prev').bind('click',function(){
		selectImg(-1);
		
		if(parseInt($('.list_sum ul').css('margin-left'), 10) === 0) {
			return;
		}

		$('.list_sum ul').css('margin-left', parseInt($('.list_sum ul').css('margin-left'), 10) +_sum_outerWidth);
		$('.list_sum ul').width($('.list_sum ul').width()-_sum_outerWidth);
	});
	
	// next 화살표 선택시 액션
	$('.bt_next').bind('click',function(){
		selectImg(1);		
		if (-(parseInt($('.list_sum ul').css('margin-left'), 10)) == (_sum_size - 1) * _sum_outerWidth) {
			return;
		}

		$('.list_sum ul').css('margin-left', parseInt($('.list_sum ul').css('margin-left'), 10) -_sum_outerWidth);
		$('.list_sum ul').width($('.list_sum ul').width()+_sum_outerWidth);
	});
	
	selectImg();
}

/**
 * 썸네일 이미지 선택
 * 
 * @param
 * 
 * @return
 */
function selectImg( index ){
	var link = "";
	var title = "";
	
	if(index != 0){
		if(index == -1 && imgNo > 0)
			imgNo = imgNo - 1;
		else if(index == 1 && totNo != imgNo)
			imgNo = imgNo + 1;
		
		setSelected(imgNo);
	}	
	
	link = $('.selected a .linkImg').text();
	title = $('.selected a .title').text();
	
	$('.in_pos_box ul li a').attr('href',link);
	$('.in_pos_box ul li a img').attr("src",link);
	$('.data_info dt a').text(title);
	$('.bt_view_original').attr('href',link);
			
	getImgRow();
}

/**
 * 선택한 이미지의 row no를 가져온다.
 * 
 * @returns {Number}
 * 
 * @return
 */
function getImgRow(){
	var cnt = 0;

	$('.list_sum ul li').each(function(){		
		if($(this).hasClass('selected')){
			imgNo = cnt;			
		}		
		cnt++;
	});
	
	totNo = cnt;
	
	return;
}

/**
 * Selected 펑션
 * 
 * @param no
 * 
 * @return
 */
function setSelected( no ){
	var cnt = 0;
	
	$('.list_sum ul li').each(function(){
		$(this).removeClass('selected');
		
		if(cnt == no){
			$(this).addClass('selected');
		}		
		cnt++;
	});
}
