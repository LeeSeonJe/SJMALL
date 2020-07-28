var html = "";
var flag = false;

$('.product.price').children('b').text(numberWithCommas($('.product.price').children('b').text()))

$('select[name=sizeSel]').on('click', function() {
	if($(this).val() != '옵션을 선택해주세요.') {
		pBuyList[Object.keys(pBuyList)[$(this).val()-1]]++
		pPriceList[Object.keys(pPriceList)[$(this).val()-1]] += productPrice;
		var option = $('option:selected',this).text();
		var size = $('option:selected',this).attr('title');
		$div = $('<div>');
		$p = $('<p class="option_p"></p>').text(option);
		$sizeInput = $('<input type="hidden" />').val(size);
		$button1 = $('<button type="button" class="option_button" onclick="subCount(this, '+ $(this).val() +');">-</button>')
		$input = $('<input class="pCount" type="text" value="1" readonly="readonly"/>')
		$button2 = $('<button type="button" class="option_button" onclick="addCount(this, '+ $(this).val() +');">+</button>')
		$label1 = $('<label class="option_label" style="cursor: pointer;" onclick="optionCancle(this, '+ $(this).val() +');">X</label>');
		$label2 = $('<label class="option_label">원</label>');
		$label3 = $('<label id="price" class="option_label" style="font-size: 17px; font-weight: 700; padding: 2px;"></label>').text(numberWithCommas(productPrice));
		$('option:selected',this).prop('disabled', true);
		$div.append($p, $sizeInput, $button1, $input, $button2, $label1, $label2, $label3);
		$('.product.option').append($div);
		$('select[name=sizeSel] option').eq(0).prop('selected', true);
		totalArea(totalPrice(pPriceList));
		flag = true;
	}
});

function optionCancle(c, num) {
	pBuyList[Object.keys(pBuyList)[num-1]] = 0;
	pPriceList[Object.keys(pPriceList)[num-1]] = 0;
	$(c).parent().remove();
	$('select[name=sizeSel] option').eq(num).prop('disabled', false);
	totalArea(totalPrice(pPriceList));
	if(totalPrice(pPriceList) == 0) {
		$('.product.totalPrice').html("");
		flag = false;
	}
}

function subCount(s, num) {
	if($(s).next().val() == 1) {
	} else {
		pBuyList[Object.keys(pBuyList)[num-1]]--;
		pPriceList[Object.keys(pPriceList)[num-1]] -= productPrice;
		$(s).next().next().next().next().next().text(numberWithCommas(pPriceList[Object.keys(pPriceList)[num-1]]));
		$(s).next().val(pBuyList[Object.keys(pBuyList)[num-1]]);
		totalArea(totalPrice(pPriceList));
	}
}

function addCount(a, num) {
	var productCount = pSizeList[Object.keys(pSizeList)[parseInt(num) - 1]];
	if(parseInt($(a).prev().val()) == productCount) {
	} else {
		pBuyList[Object.keys(pBuyList)[num-1]]++;
		pPriceList[Object.keys(pPriceList)[num-1]] += productPrice;
		$(a).next().next().next().text(numberWithCommas(pPriceList[Object.keys(pPriceList)[num-1]]));
		$(a).prev().val(pBuyList[Object.keys(pBuyList)[num-1]]);
		totalArea(totalPrice(pPriceList));
	}
}

function totalPrice(pPriceList) {
	var total = 0;
	for(var i = 0; i < Object.keys(pPriceList).length; i++) {
		total += pPriceList[Object.keys(pPriceList)[i]];
	}
	return total;
}

function totalArea(total) {
	$('.product.totalPrice').html("");
	$label = $('<label style="float: left; margin-top: 8px;">합계</label>');
	total = numberWithCommas(total)
	$p = $('<p class="totalPrice"></p>').text(total + "원");
	$('.product.totalPrice').append($label, $p);
}

function bucketAdd(productNo) {
	if(flag == true) {
		var bucketProduct = {
				'productNo':productNo,
				'pBuyList':pBuyList,
				'pPriceList':pPriceList
		}
		$.ajax({
			url: "bucketAdd.cu",
			data: bucketProduct,
			success: function(data) {
				if(data.trim() == "success") {
					alert("장바구니에 추가되었습니다.");
					$('.product.option').children().remove();
					$('.product.totalPrice').html("");
					$('body').load(window.location.href+"#sizeSel");
					flag = false;
				}
			}
		})		
	} else {
		alert("옵션을 선택해주세요.");
	}
}

function noSignIn() {
	alert("로그인 후 이용할 수 있습니다.")
	location.href='signIn.co';
}

function numberWithCommas(price) {
    return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}



function customerBuyItem() {
	var length = $('.product.option').children().length
	itemArray = new Array();
	var checkFlag = false;
	for(var i = 0; i < length; i++) {
		itemJson(i);
		checkFlag = true;
	}
	console.log(itemArray);
	if(checkFlag == false) {
		alert("제품을 선택해주세요");
	} else {
		var jsonItem = JSON.stringify(itemArray);
		$.ajax({
			url: "buyItemList.cu",
			type: 'POST',
			contentType:'application/json; charset=UTF-8',
			data: jsonItem,
			success: function(data) {
				if(data.trim() == "success") {
					location.href="customerBuyItem.cu";
				} else if(data.trim() == "change") {
					alert("재고 현황으로 인해 수량이 변경되었습니다. 확인부탁드립니다.");
					location.href="customerBuyItem.cu";				
				} else {
					alert("재고가 없습니다.");
					location.reload();
				}
			}
		})
	}
}


function itemJson(i) {
	bucketNo = 0;
	var itemInfo = new Object();
	
	itemInfo.customerNo = customerNo;
	itemInfo.bucketNo = bucketNo;
	itemInfo.productNo = productNo;
	itemInfo.productThumNail = $('.pImg-area').children('img').attr('alt');
	itemInfo.productName = $('.product.name').children('span').text(); 
	itemInfo.productSize = $('.option_p').eq(i).next('input').val();
	itemInfo.productCount = $('.pCount').eq(i).val()
	itemInfo.productPrice = parseInt($('.product.option').children('div').eq(i).children('.option_label').eq(2).text())
	itemArray.push(itemInfo);
}