if (status.trim() == 'success') {
	location.href = "main.co";
	alert("회원가입에 성공하였습니다.");
} else if (status.trim() == 'fail') {
	alert("회원가입에 실패하였습니다.");
}

$(function() {
	$('#business-table').hide();
	$('input[value="customer"]').attr('checked', true);
})

// 라디오버튼 클릭
$('input[name=signIn]').on('click', function() {
	var check = $('input[name=signIn]:checked').val();
	if (check == 'customer') {
		$('#customer-table').show();
		$('#business-table').hide();
	} else if (check == 'business') {
		$('#business-table').show();
		$('#customer-table').hide();
	}
})

// 이메일 선택
$('#sel_domein1').on('click', function() {
	var sel = $('#sel_domein1 option:selected').text();
	if (sel == '직접입력') {
		$('#domein1').val("");
	} else if (sel == 'naver.com') {
		$('#domein1').val(sel);
	} else if (sel == 'google.com') {
		$('#domein1').val(sel);
	} else if (sel == 'daum.net') {
		$('#domein1').val(sel);
	}
})

$('#sel_domein2').on('click', function() {
	var sel = $('#sel_domein2 option:selected').text();
	if (sel == '직접입력') {
		$('#domein2').val("");
	} else if (sel == 'naver.com') {
		$('#domein2').val(sel);
	} else if (sel == 'google.com') {
		$('#domein2').val(sel);
	} else if (sel == 'daum.net') {
		$('#domein2').val(sel);
	}
})

// 아이디 유효성 검사
function idCheck(id, kind) {
	if ($(id).val().trim().length == 0) {
		$('#id_labe' + "_" + kind).css("color", "black").css("background-color", "white").text("영 소문자, 숫자 8~20자리로 입력해주세요.");
		idCheckFlag = false;
	} else if (!/^[a-z0-9]{8,20}$/.test($(id).val())) {
		$('#id_label' + "_" + kind).css("color", "white").css("background-color", "red").text("영 소문자, 숫자 8~20자리로 입력해주세요.");
		idCheckFlag = false;
	} else {
		$.ajax({
			url : "idCheck.co",
			// 전역변수에 값을 넣어주기 위해서는 async를 false 처리해준다.
			async: false,
			data : {
				id : $(id).val()
			},
			success : function(data) {
				if (data.trim() == "exist") {
					idCheckFlag = false;
					$('#id_label' + "_" + kind).css("color", "red").css("background-color", "white").text("사용할 수 없는 아이디입니다.");
				} else if (data.trim() == "none") {
					$('#id_label' + "_" + kind).css("color", "green").css("background-color", "white").text("사용할 수 있는 아이디입니다.");
					idCheckFlag = true;
				}
			}
		})
	}
}

function pwdCheck(pwd, kind, num) {
	if ( num == 1 ){
		if($(pwd).val().trim().length == 0) {
			$('#pwd_label' + "_" + kind).css("color", "black").css("background-color", "white").text("비밀번호는 8~16자리(숫자, 특수문자 포함)");
			pwdCheckFlag = false;
		} else if (!/(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{1,50}).{8,16}$/.test($(pwd).val())) {
			$('#pwd_label' + "_" + kind).css("color", "white").css("background-color", "red").text("비밀번호는 8~16자리(숫자, 특수문자 포함)");
			pwdCheckFlag = false;
		} else {
			pwdCheckFlag = true;
			$('#pwd_label' + "_" + kind).css("color", "green").css("background-color", "white").text("사용가능한 비밀번호입니다.");						
		}
	} else  if ( num == 2 ) {
		if($(pwd).val().trim().length == 0) {
			$('#newPwd_label' + "_" + kind).css("color", "black").css("background-color", "white").text("비밀번호는 8~16자리(숫자, 특수문자 포함)");
			pwdCheckFlag = false;
		} else if (!/(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{1,50}).{8,16}$/.test($(pwd).val())) {
			$('#newPwd_label' + "_" + kind).css("color", "white").css("background-color", "red").text("비밀번호는 8~16자리(숫자, 특수문자 포함)");
			pwdCheckFlag = false;
		} else {
			if($('input[name=pwd]').val() == $('input[name=newPwd]').val()) {
				$('#newPwd_label' + "_" + kind).css("color", "green").css("background-color", "white").text("비밀번호가 일치합니다");
				pwdCheckFlag = true;
			} else {
				$('#newPwd_label' + "_" + kind).css("color", "red").css("background-color", "white").text("비밀번호가 일치하지 않습니다.");
				pwdCheckFlag = false;
			}
		}
	}
	
}

//회원가입 버튼클릭
function signUp() {
	var check = $('input[name=signIn]:checked').val();
	if (check == 'customer') {
		if(idCheckFlag == true && pwdCheckFlag == true) {
			var email = $('#cEmail_id').val() + "@" + $('#domein1').val();
			$.ajax({
				url: "emailCheck.co",
				async: false,
				data: {
					email:email
				},
				success: function(data) {
					console.log(data);
					if(data.trim() == "exist") {
						alert("존재하는 이메일입니다.");						
					} else if(data.trim() == "none") {
						$('#customer-form').submit();						
					}
				}
			})
		} else {
			alert("정보를 확인해주세요.");
		}
	} else if (check == 'business') {
		var enterName = $('input[name=enterName]').val().trim().length;
		var businessName = $('input[name=businessName]').val().trim().length;
		var licenseNo = $('input[name=licenseNo]').val().trim().length;
		var businessPhone = $('input[name=businessPhone]').val().trim().length;
		if( enterName != 0 && businessName != 0 && licenseNo != 0 && businessPhone != 0 && idCheckFlag == true && pwdCheckFlag == true ) {
			var email = $('#bEmail_id').val() + "@" + $('#domein2').val();
			$.ajax({
				url: "emailCheck.co",
				async: false,
				data: {
					email:email
				},
				success: function(data) {
					console.log(data);
					if(data.trim() == "exist") {
						alert("존재하는 이메일입니다.");						
					} else if(data.trim() == "none") {
						$('#business-form').submit();						
					}
				}
			})
		} else {
			alert("정보를 확인해주세요.");
		}
	}
}
