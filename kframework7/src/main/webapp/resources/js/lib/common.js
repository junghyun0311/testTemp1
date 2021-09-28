var insertEl = function(){
	$('.aside_wrapper').append('<div class="ctr_hot_keyword"><div class="btn_paging"><a href="#" class="bt_prev"><img src="images/bt_paging_l.gif" width="16" height="16" alt=""/></a><a href="#" class="bt_next"><img src="images/bt_paging_r.gif" width="16" height="16" alt="" /></a></div></div>');
	
	var $relate_box = $('#relate_word .box'),
		relate_height = $relate_box.find('li').height();
	
	$relate_box.height(relate_height);
	
	$('#org_m li ul').hide();
	
	$('nav#left ul li:first').addClass('first');
	
}

var activeToggle = function (e){
	var $this = $(this)
		$old_selected = $this.siblings('.selected');
	$old_selected.removeClass('selected');
	$this.addClass('selected');
	e.preventDefault();
},

showToggle = function (e,$this,target){
	var $this = $this,
		$target = target;
	console.log($this)
	$this.toggleClass('active');
	$target.toggle();
	e.preventDefault();
},

hotKeyword = function (e){
	var $this = $(this),
		$toggle = $this.parent(),
		$sh_el = $this.parent().parent().parent().find('ul, ol'),
		$sh_el1 = $sh_el.eq(0),
		$sh_el2 = $sh_el.eq(1);
	
	if($sh_el1.hasClass('dp_n')){
		$toggle.removeClass('active');
		$sh_el1.removeClass('dp_n');
		$sh_el2.addClass('dp_n');
	}else{
		$toggle.addClass('active');
		$sh_el2.removeClass('dp_n');
		$sh_el1.addClass('dp_n');
	}
	e.preventDefault();
},

topScroll = function(){
	var init_obj = $(".bt_top");
						//init_height = init_obj.offset().top; 
							
		$(window).scroll(function() {
			var init_height = $("aside").height();
				if($(document).scrollTop()>init_height){
					_top = $(document).scrollTop();
					setTimeout(function() {
						init_obj.stop().animate({ top: _top-init_height-47 }, 1000/15, 'swing');
					}, 000);
				}else{
					init_obj.stop().animate({ top: "0" }, 1000/15, 'swing');
				}
		});
},

navCtroll = function(e){
	$('.aside_wrapper').removeClass('dp_b');
	$('.filter').removeClass('pos_ab');
	$(this).parent().siblings('ul').toggleClass('dp_b');
	$(this).toggleClass('active');
	$('.a_section h3 a').removeClass('active');
	e.preventDefault();
},

relateCtroll = function(e){
	var $this = $(this),
						$sh_el = $this.parent().siblings('.aside_wrapper');
						
	$this.toggleClass('active');
	$('.a_section h3 a').not($this).removeClass('active');
	$('nav#left ul').removeClass('dp_b');
	$('nav#left h2 a').removeClass('active');
	$('.aside_wrapper').not($sh_el).removeClass('dp_b');
	$sh_el.toggleClass('dp_b');
	if($sh_el.is(':visible')){
		$('.filter').addClass('pos_ab');
	}else{
		$('.filter').removeClass('pos_ab');
	}
	e.preventDefault();
},

relateCtrollWide = function(e){
	var $this = $(this),
						$sh_el = $this.parent().siblings('.aside_wrapper');
	$sh_el.toggleClass('wdp_b');
	e.preventDefault();
},

clickSlider = function(){
	var index_this = $('.slide_filter input:radio').index(this),
							t_val = parseInt(index_this+'0'),
							$active_el = $(this).next('label');
							
	$( "#slider-range-min" ).slider({value:t_val});
	$('.slide_filter label.selected').removeClass('selected');
	$active_el.addClass('selected');
},

/*
ctrFolder = function(e){
	var $this = $(this),
						$show = $this.siblings('ul');
						
	$this.toggleClass('active');
	if($this.hasClass('active')){
		$this.attr('src','images/ico_plus.gif').attr('alt','접기');
	}else{
		$this.attr('src','images/ico_minus.gif').attr('alt','펼치기');
		
	}
	
	$show.toggle();
	e.preventDefault();
},
*/

ctrFilter = function(e){
	var $this = $(this),
						$ctr_el = $this.parent('*');
	$this.toggleClass('active');
	
	if($this.hasClass('active')){
		$ctr_el.css('height', 'auto');
	}else{
		$ctr_el.css('height', '');
	}
	
	e.preventDefault();
	
},

viewType = function(){
		$('#bt_view_sum .selected').removeClass('selected');
		$(this).addClass('selected');
		$('#bt_view_sum').toggleClass('bt_view_sum_on');
		e.preventDefault();
},

allChk = function(){
	var $this = $(this),
						$chk_el = $this.parent('*').parent('*').find('input[type=checkbox]');
						
	if($(this).is(':checked')){
		$chk_el.attr('checked', 'checked');
	}else{
		$chk_el.removeAttr('checked');
	}
}
