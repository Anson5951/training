<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<form action="login.jsp" method="get">
first name : <input type="text" name='firstname' id="firstname">
<br/><br/>
last name : <input type="text" name="lastname" id="lastname">
<br/><br/>
username : <input type="text" name='username' id="username">
<br/><br/>
password : <input type="password" name="password" id="password">
<br/><br/>
<input type="submit" value="submit">
<p id="message"></p>
</form>
</body>
</html>