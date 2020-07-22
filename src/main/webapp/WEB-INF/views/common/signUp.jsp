<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SJ MALL</title>
<link href="resources/common/css/signUp.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>
	<div class="sign-area">
		<h2>회원가입</h2>
		<div class="radio-area">
			<label><input type="radio" name="signIn" value="customer" checked="checked" />&nbsp;CUSTOMER</label> &nbsp;&nbsp;&nbsp; <label><input type="radio" name="signIn" value="business" />&nbsp;BUSINESS</label>
		</div>
		<div class="title-area">
			<h5>정보입력</h5>
			<span>* 표시는 필수 입력항목입니다.</span>
		</div>
		<div class="table-div">
			<form action="joinCustomer.cu" method="get" id="customer-form">
				<table id="customer-table">
					<tr>
						<td><label>아이디*</label></td>
						<td><input type="text" name="id" required="required" onkeyup="idCheck(this, 'c');"/></td>
						<td colspan="2"><label id="id_label_c" style="font-size: 11px;">영 소문자, 숫자 8~20자리로 입력해주세요.</label></td>
					</tr>
					<tr>
						<td><label>비밀번호*</label></td>
						<td><input type="password" name="pwd" required="required" onkeyup="pwdCheck(this, 'c', 1);"/></td>
						<td colspan="2"><label id="pwd_label_c" style="font-size: 11px;">비밀번호는 8~16자리(숫자, 특수문자 포함)</label></td>
					</tr>
					<tr>
						<td><label>비밀번호 확인*</label></td>
						<td><input type="password" name="newPwd" required="required" onkeyup="pwdCheck(this, 'c', 2);" /></td>
						<td colspan="2"><label id="newPwd_label_c" style="font-size: 11px;">비밀번호는 8~16자리(숫자, 특수문자 포함)</label></td>
					</tr>
					<tr>
						<td><label>이메일*</label></td>
						<td><input type="text" id="cEmail_id" name="email_id" required="required" /> &nbsp;@&nbsp;</td>
						<td><input type="text" id="domein1" name="domein" required="required" />&nbsp;&nbsp;</td>
						<td><select id="sel_domein1">
								<option value="domein1">직접입력</option>
								<option value="domein2">naver.com</option>
								<option value="domein3">google.com</option>
								<option value="domein4">daum.net</option>
						</select></td>
					</tr>
					<tr>
						<td><label>이름*</label></td>
						<td><input type="text" name="name" required="required" /></td>
					</tr>
				</table>
			</form>
			
			<form action="joinBusiness.bu" method="get" id="business-form">
				<table id="business-table">
					<tr>
						<td><label>아이디*</label></td>
						<td><input type="text" name="id" required="required" onkeyup="idCheck(this, 'b');"/></td>
						<td colspan="2"><label id="id_label_b" style="font-size: 11px;">영 소문자, 숫자 8~20자리로 입력해주세요.</label></td>
					</tr>
					<tr>
						<td><label>비밀번호*</label></td>
						<td><input type="password" name="pwd" required="required" onkeyup="pwdCheck(this, 'b', 1);"/></td>
						<td colspan="2"><label id="pwd_label_b" style="font-size: 11px;">비밀번호는 8~16자리(숫자, 특수문자 포함)</label></td>
					</tr>
					<tr>
						<td><label>비밀번호 확인*</label></td>
						<td><input type="password" name="pwd" required="required" onkeyup="pwdCheck(this, 'b', 2);"/></td>
						<td colspan="2"><label id="newPwd_label_b" style="font-size: 11px;">비밀번호는 8~16자리(숫자, 특수문자 포함)</label></td>
					</tr>
					<tr>
						<td><label>이메일*</label></td>
						<td><input type="text" id="bEmail_id" name="email_id" required="required" /> &nbsp;@&nbsp;</td>
						<td><input type="text" id="domein2" name="domein" required="required" />&nbsp;&nbsp;</td>
						<td><select id="sel_domein2">
								<option value="domein1">직접입력</option>
								<option value="domein2">naver.com</option>
								<option value="domein3">google.com</option>
								<option value="domein4">daum.net</option>
						</select></td>
					</tr>
					<tr>
						<td><label>회사명*</label></td>
						<td><input type="text" name="enterName" required="required"/></td>
					</tr>
					<tr>
						<td><label>대표자명*</label></td>
						<td><input type="text" name="businessName" required="required" /></td>
					</tr>
					<tr>
						<td><label>사업자번호*</label></td>
						<td><input type="number" name="licenseNo" required="required" /></td>
					</tr>
					<tr>
						<td><label>연락처*</label></td>
						<td colspan="3"><input type="text" name="businessPhone" required="required" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="button-area">
			<button type="button" onclick="signUp();" id="signUp_btn">가입</button>
			<button type="button" onclick="location.href='javascript:history.go(-1)'">취소</button>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>
	
	<script type="text/javascript">
		var status = '${ status }';
		var idCheckFlag = false;
		var pwdCheckFlag = false;
	</script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="resources/common/js/signUp.js"></script>
</body>
</html>