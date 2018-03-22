$(function(){
	switch (menu) {
	case 'About':
			$('#about').addClass('active');
		break;
	
	case 'Contact':
			$('#contact').addClass('active');
		break;
		
	case 'Home':
		$('#home').addClass('active');
	break;
	
	default:
		$('#products').addClass('active');
		$('#category').addClass('bg-primary');
		break;
	}
	
})
