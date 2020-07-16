<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SJ MALL</title>
<link href="resources/common/css/signIn.css" rel="stylesheet">
</head>
<body class="text-center">
	<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>
	<img class="mb-4" src="resources/common/images/login.png" alt="" width="300" height="300">
	<br>
	<label><input type="radio" name="signIn" value="customer" checked="checked"/>&nbsp;CUSTOMER</label>
	&nbsp;&nbsp;&nbsp;
	<label><input type="radio" name="signIn" value="business"/>&nbsp;BUSINESS</label>
	<form class="form-signin" method="POST" onsubmit="return signIn();">
		<h1 class="h3 mb-3 font-weight-normal">LOGIN</h1>
		<label for="inputEmail" class="sr-only">ID</label> 
		<input type="text" id="inputId" name="id" class="form-control" placeholder="ID" required autofocus> 
		<label for="inputPassword" class="sr-only">PASSWORD</label> 
		<input type="password" id="inputPassword" name="pwd" class="form-control" placeholder="PASSWORD" required>
		<button class="btn btn-lg btn-primary btn-block" type="submit">LOGIN</button>
		<p class="mt-5 mb-3 text-muted">&copy; 2019-2020</p>
	</form>
	<script src="resources/common/js/signIn.js"></script>
</body>
</html>