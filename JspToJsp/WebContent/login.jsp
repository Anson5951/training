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
		<a href="regist.jsp">���U</a> 
		<input type="submit" value="submit">
		<p id="message"></p>
	</form>
	<script type="text/javascript">
		function submition() {
			var username = $("#username").val();
			var password = $("#password").val();

			if (username != "ann" && password != "ann") {

				event.preventDefault();
				$("#message").text("�n�J����");
			}
		}
		
		function checkIsFromRegist() {
			window.alert(<%= isFromRegist%>); 
			window.alert("<%= isFromRegist%>");

			if(<%= isFromRegist%>){
				alert("���U���\");
			}
		}
	</script>
</body>
</html>