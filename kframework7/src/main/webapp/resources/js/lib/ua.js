var mobileFlag = false;
$().ready(function(){
		
	var UserAgent = navigator.userAgent;
	
	if (UserAgent.match(/iPhone|iPod|iPad|Android|Windows CE|BlackBerry|Symbian|Windows Phone|webOS|Opera Mini|Opera Mobi|POLARIS|IEMobile|lgtelecom|nokia|SonyEricsson | LG|SAMSUNG|Samsung/i) != null){
		//mobile
		mobileFlag = true;
		$('body').addClass('mobile_browser');
	}else if(UserAgent.match(/MSIE 7.0/i)){
		// old IE
		$('body').addClass('old_browser');
	}else{
		// modern PC browser
		$('body').addClass('modern_browser');
	}
		
})
