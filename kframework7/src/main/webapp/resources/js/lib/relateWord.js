$.fn.relateWord = function () {
	
	return this.each(function () {
		
		var sh_fn = {
			topmenu: function(e){
				var sh_box_h = e.data.$box_parent.height(),
					sh_el_h = e.data.$box.height();
					
				if(sh_box_h < sh_el_h){
					e.data.$btn_parent.show();
				}else{
					if (!e.data.$btn.hasClass('active')) {
						e.data.$btn_parent.hide();
					}
				}
			},
		
			topctr: function(e){
				var $this = $(this);
					
				if($this.hasClass('active')){
					$this.removeClass('active').html('더보기');
					e.data.$box_parent.css('height','25px');
				}else{
					$this.addClass('active').html('접기');
					e.data.$box_parent.css('height','auto');
				}
				e.preventDefault();
			}
		};
			
		var $this = $(this);

		var btn_parent_string = '<div class="btn"><a href="#">더보기</a></div>',
			$box_parent = $this.children().eq(0);
			
		$this.append(btn_parent_string);
		var $btn_parent = $this.children('.btn');
		
		
		var relate_word = {
				$btn_parent : $btn_parent,
				$btn : $btn_parent.children('a'),
				$box_parent : $box_parent,
				$box : $box_parent.children('ul')
		};
		
		relate_word.$btn.on('click', relate_word, sh_fn.topctr);
		
		$(window).on('resize load', relate_word, sh_fn.topmenu);
		
	});
	
};