<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
<meta charset="BIG5">
<title>Insert title here</title>

</head>
	<%
		boolean isFromRegist = false;
		if(request.getHeader("Referer") != null){
			isFromRegist = request.getHeader("Referer").endsWith("regist.jsp");
		}
		
	%>
<body onload="checkIsFromRegist()">

	<form action="loginSuccess.jsp" method="post" onsubmit="submition()">
		username : <input type="text" name='username' id="username"> 
		<br /><br /> 
		password : <input type="password" name="password" id="password">
		<br /><br /> 
		<a href="regist.jsp">註冊</a> 
		<input type="submit" value="submit">
		<p id="message"></p>
	</form>
	<script type="text/javascript">
		function submition() {
			var username = $("#username").val();
			var password = $("#password").val();

			if (username != "ann" && password != "ann") {

				event.preventDefault();
				$("#message").text("登入失敗");
			}
		}
		
		function checkIsFromRegist() {
			window.alert(<%= isFromRegist%>); 
			window.alert("<%= isFromRegist%>");

			if(<%= isFromRegist%>){
				alert("註冊成功");
			}
		}
	</script>
</body>
</html>