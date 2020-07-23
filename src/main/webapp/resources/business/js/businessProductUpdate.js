var flag = false;
var flag2 = false;	
var size1 = "";
	size1 += '<label><input type="checkbox" name="productSize" value="FREE" onclick="option(this, 0)"/>FREE</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size1 += '<label><input type="checkbox" name="productSize" value="S" onclick="option(this, 1)"/>S</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size1 += '<label><input type="checkbox" name="productSize" value="M" onclick="option(this, 2)"/>M</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size1 += '<label><input type="checkbox" name="productSize" value="X" onclick="option(this, 3)"/>X</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size1 += '<label><input type="checkbox" name="productSize" value="XL" onclick="option(this, 4)"/>XL</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/>'

var size2 = "";
	size2 += '<label><input type="checkbox" name="productSize" value="FREE" onclick="option(this, 0)"/>FREE</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size2 += '<label><input type="checkbox" name="productSize" value="26" onclick="option(this, 1)"/>26</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size2 += '<label><input type="checkbox" name="productSize" value="27" onclick="option(this, 2)"/>27</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size2 += '<label><input type="checkbox" name="productSize" value="28" onclick="option(this, 3)"/>28</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size2 += '<label><input type="checkbox" name="productSize" value="29" onclick="option(this, 4)"/>29</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size2 += '<label><input type="checkbox" name="productSize" value="30" onclick="option(this, 5)"/>30</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size2 += '<label><input type="checkbox" name="productSize" value="31" onclick="option(this, 6)"/>31</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size2 += '<label><input type="checkbox" name="productSize" value="32" onclick="option(this, 7)"/>32</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size2 += '<label><input type="checkbox" name="productSize" value="33" onclick="option(this, 8)"/>33</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size2 += '<label><input type="checkbox" name="productSize" value="34" onclick="option(this, 9)"/>34</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/>'

var size3 = "";
	size3 += '<label><input type="checkbox" name="productSize" value="220" onclick="option(this, 0)"/>220</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size3 += '<label><input type="checkbox" name="productSize" value="230" onclick="option(this, 1)"/>230</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size3 += '<label><input type="checkbox" name="productSize" value="240" onclick="option(this, 2)"/>240</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size3 += '<label><input type="checkbox" name="productSize" value="250" onclick="option(this, 3)"/>250</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size3 += '<label><input type="checkbox" name="productSize" value="260" onclick="option(this, 4)"/>260</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size3 += '<label><input type="checkbox" name="productSize" value="270" onclick="option(this, 5)"/>270</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size3 += '<label><input type="checkbox" name="productSize" value="280" onclick="option(this, 6)"/>280</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size3 += '<label><input type="checkbox" name="productSize" value="290" onclick="option(this, 7)"/>290</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/><br>'
	size3 += '<label><input type="checkbox" name="productSize" value="300" onclick="option(this, 8)"/>300</label><input name="productCount" type="number" placeholder="수량을 입력해주세요." disabled="disabled" required="required"/>'

cateSelect();
sizeSelect();
statusSelect();

function statusSelect() {
	for(var i = 0; i < $('input[name=status]').length; i++) {
		if(status == $('input[name=status]').eq(i).val()) {
			$('input[name=status]').eq(i).attr('checked', true);
		} else if(status == $('input[name=status]').eq(i).val()) {
			$('input[name=status]').eq(i).attr('checked', true);
		}
	}
}
	
function sizeSelect() {
	var length = $('input[name=productSize]').length;
	for(var i = 0; i < length; i++) {
		for(var j = 0; j < Object.keys(pSizeList).length; j++) {
			if($('input[name=productSize]').eq(i).val() == Object.keys(pSizeList)[j] && $('select[name=productCategory] option:selected').val() == category) {
				$('input[name=productSize]').eq(i).attr('checked',true);
				$('input[name=productCount]').eq(i).val(pSizeList[Object.keys(pSizeList)[j]]);
				$('input[name=productCount]').eq(i).attr('disabled', false);
				flag2 = true;
			} else {
				flag2 = false;
			}
		}
	}
}

function cateSelect() {
	var length = $('select[name=productCategory] option').length;
	for(var i = 1; i < length; i++) {
		if($('select[name=productCategory] option').eq(i).val() == category){
			$('select[name=productCategory] option').eq(i).attr('selected',true)
			if($('select[name=productCategory] option').eq(i).val() == "Top" || $('select[name=productCategory] option').eq(i).val() == "OnePiece"){
				$('#cateSize').html("");
				$('#cateSize').append(size1);
				flag = true;
			} else if($('select[name=productCategory] option').eq(i).val() == "Pants" || $('select[name=productCategory] option').eq(i).val() == "skirt") {
				$('#cateSize').html("");
				$('#cateSize').append(size2);
				flag = true;
			} else if($('select[name=productCategory] option').eq(i).val() == "Shoes") {
				$('#cateSize').html("");
				$('#cateSize').append(size3);
				flag = true;
			}
			break;
		}
	}
}

function option(o, num) {
	if ($(o).is(":checked") == true) {
		$('input[name=productCount]').eq(num).attr('disabled', false);
		flag2 = true;
	} else {
		$('input[name=productCount]').eq(num).attr('disabled', true);
	}
}

$('select[name=productCategory]').on('click', function() {
	var select = $('select[name=productCategory] option:selected').val();
	if (select == '선택') {
		$('#cateSize').html("");
		$('#cateSize').html('카테고리를 선택해주세요.');
		flag = false;
	} else if (select == 'Top') {
		$('#cateSize').html("");
		$('#cateSize').append(size1);
		sizeSelect();
		flag = true;
	} else if (select == 'Pants') {
		$('#cateSize').html("");
		$('#cateSize').append(size2);
		sizeSelect();
		flag = true;
	} else if (select == 'Skirt') {
		$('#cateSize').html("");
		$('#cateSize').append(size2);
		sizeSelect();
		flag = true;
	} else if (select == 'OnePiece') {
		$('#cateSize').html("");
		$('#cateSize').append(size1);
		sizeSelect();
		flag = true;
	} else if (select == 'Shoes') {
		$('#cateSize').html("");
		$('#cateSize').append(size3);
		sizeSelect();
		flag = true;
	}
})

function submitContents() {
	oEditors.getById["productDetail"].exec("UPDATE_CONTENTS_FIELD", []);
	var imgChk = $('#productDetail').val().indexOf('img')
	if (imgChk == -1) {
		alert("사진 한장 이상을 첨부해주세요");
		return false;
	}
	if (flag == false && flag2 == false) {
		alert("모든정보를 작성해주세요.")
		return false;
	} else if (flag == true && flag2 == true) {
		return true;
	} else {
		alert("모든정보를 작성해주세요.")
		return false;
	}
}