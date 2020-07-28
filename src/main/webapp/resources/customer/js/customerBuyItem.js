if (status.trim() == "no") {
	alert("재고가 없습니다.")
	location.href = "customerBasket.cu";
} else if (status.trim() == "change") {
	alert("재고 현황으로 인한 수량이 변경되었습니다. 확인부탁드립니다.");
}

var totalPrice = 0;
for(var i = 0; i < $('input[name=productPrice]').length; i++) {
	totalPrice += parseInt($('input[name=productPrice]').eq(i).val());
	var price = numberWithCommas($('input[name=productPrice]').eq(i).next().text())
	$('input[name=productPrice]').eq(i).next().text(price)
}
$('input[name=totalPrice]').val(totalPrice);
$('#totalPrice').text(numberWithCommas(totalPrice));

function sample6_execDaumPostcode() {
	new daum.Postcode({
		oncomplete : function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을
				// 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName
							: data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
				// 조합된 참고항목을 해당 필드에 넣는다.
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('sample6_postcode').value = data.zonecode;
			document.getElementById("sample6_address").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("sample6_detailAddress").focus();
		}
	}).open();
}

function optionSelect(o) {
	if ($('option:selected', o).val() == 4) {
		$('.order_memo').remove();
		$input = $('<tr class="memo_tr"><td colspan="6"><input name="orderMemo" style="width: 100%;" type="text" placeholder="50자까지 입력 가능합니다. 초과된 내용은 자동 삭제 됩니다." required="required" maxlength="50"/></tr></td>')
		$('.order_address_table').append($input);
	} else {
		$('.order_memo').remove();
	}
}

function validate() {
	var flag = true;
	if ($('select[name=orderMemo] option:selected').val() == 0) {
		alert("요청사항을 선택해주세요.")
		flag = false;
	}
	return flag;
}

function maxLengthCheck(object) {
	if (object.value.length > object.maxLength) {
		object.value = object.value.slice(0, object.maxLength);
	}
}

function numberWithCommas(price) {
    return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}