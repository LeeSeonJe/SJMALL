priceCommas();


$('input[name=productNo]').prop("checked",true);
itemCheck()

function allSelect(c) {
	console.log($(c).is(":checked"));
	if($(c).is(":checked") == true) {
		$('input[name=productNo]').prop("checked",true);
		itemCheck();
	} else {
		$('input[name=productNo]').prop("checked",false);
		itemCheck();
	}
}

function itemCheck() {
	var flag = false;
	var length = $('input[name=productPrice]').length;
	var totalCount = 0;
	var totalPrice = 0;
	for(var i = 0; i < length; i++) {
		if($('input[name=productNo]').eq(i).is(":checked")){
			totalCount += parseInt($('input[name=productCount]').eq(i).val());
			totalPrice += parseInt($('input[name=productPrice]').eq(i).val());
		} else {
			flag = true;
			$('#allSel').prop("checked",false);
		}
	}
	if(flag != true) {
		$('#allSel').prop("checked",true);
	} 
	$('#totalCount').text(totalCount);
	$('#totalPrice').text(totalPrice);
	$('#totalPrice2').text(totalPrice);
	priceCommas()
}


function subCount(s, bucketNo, productNo, productSize, productPrice) {
	console.log(bucketNo)
	$.ajax({
		url: "pCountSub.cu",
		async: false,
		dataType : "json",
		data: {
			bucketNo:bucketNo,
			productNo:productNo,
			productSize:productSize,
			productPrice:productPrice
		},
		success: function(data){
			console.log(data)
			if(Object.keys(data)[0] == 'min') {
				console.log("max")
				alert("최소 수량입니다.");
			} else if(Object.keys(data)[0] == 'no') {
				console.log("no")
				console.log($(a));
				alert("재고가 없습니다.");
				$(a).parent().next().children('label').click();
			} else {
				console.log(data.bucketNo);
				$(s).next().next().next().next().next().next().next().val(data.productPrice);
				$(s).next().next().next().next().next().text(data.productPrice);
				$(s).next().val(data.productCount);
				itemCheck();
				priceCommas()
			}
		}
	})
}

function addCount(a, bucketNo, productNo, productSize, productPrice) {
	$.ajax({
		url: "pCountAdd.cu",
		async: false,
		dataType : "json",
		data: {
			bucketNo:bucketNo,
			productNo:productNo,
			productSize:productSize,
			productPrice:productPrice
		},
		success: function(data){
			console.log(data)
			if(Object.keys(data)[0] == 'max') {
				console.log("max")
				alert("최대 수량입니다.");
			} else if(Object.keys(data)[0] == 'no') {
				console.log("no")
				console.log($(a));
				alert("재고가 없습니다.");
				$(a).parent().next().children('label').click();
			} else {
				console.log(data.bucketNo);
				$(a).next().next().next().next().next().val(data.productPrice);
				$(a).next().next().next().text(data.productPrice);
				$(a).prev().val(data.productCount);
				itemCheck();
				priceCommas()
			}
		}
	})
}

function delectBasket(c, bucketNo) {
	var result = confirm("장바구니에 삭제하시겠습니까?");
	console.log(c)
	if (result) {
		$.ajax({
			url : "delectBasket.cu",
			data : {
				bucketNo : bucketNo
			},
			success : function(data) {
				console.log(Object.keys(data).length)
				if(data.length == 2) {
					$('.container-fluid').html("<h3 style='width: 848px; text-align: center; margin-top: 200px; margin-bottom: 200px;'>장바구니가 비어있습니다.</h3>")
				} else {
					$(c).parent().parent().parent().remove();					
				}
				itemCheck()
			}
		})
	} else {

	}
}

function numberWithCommas(price) {
    return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function priceCommas() {
	for(var i = 0; i < $('.item_price').length; i++){
		$('.item_price').eq(i).next().text(numberWithCommas($('.item_price').eq(i).next().text()))
	}
	$('#totalPrice').text(numberWithCommas($('#totalPrice').text()))
	$('#totalPrice2').text(numberWithCommas($('#totalPrice2').text()))
}

