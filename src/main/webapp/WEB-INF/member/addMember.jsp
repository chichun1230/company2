<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	註冊
	<br>
	<form action="../member/addmember" method="post">
		name:<input type="text" name="name"><br> 
		username:<input type="text" name="username"><br> 
		password:<input type="text" name="password"><br> 
		phone:<input type="text" name="phone"><br> 
		address:<input type="text" name="address"><br> 
		admin: <input type="radio" name="admin" value="true">
		yes <input type="radio" name="admin" value="false">
		no <br> <input type="submit" value="ok">
	</form>
</body>
</html>