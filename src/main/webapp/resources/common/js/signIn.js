function signIn() {
	var checked = $('input[name=signIn]:checked').val();
	if(checked == "customer") {
		$('form').attr('action', 'customerSignIn.co');
		return true;
	} else if(checked == "business") {
		$('form').attr('action', 'businessSignIn.co');	
		return true;
	}
}