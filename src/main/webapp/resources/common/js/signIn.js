function signIn() {
	var checked = $('input[name=signIn]:checked').val();
	if(checked == "member") {
		$('form').attr('action', '/memberSignIn.co');
		return true;
	} else if(checked == "business") {
		$('form').attr('action', '/businessSignIn.co');	
		return true;
	}
}