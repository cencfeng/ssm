<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="context/base/jquery.min.js"></script>
<title>登录</title>
<script type="text/javascript">
 $(function(){
	 $("#btnsubmit").click(function(){
		 var username=$("#username").val();
		 var password=$("#password").val();
		 if(username=="")
			 {
			 alert("用户名不能为空");
			 return false;
			 }
		 if(password=="")
			 {
			 alert("密码不能为空");
			 return false;
			 }
	 });
	
 })
</script>
</head>
<body>
	<form action="User/login" method="post">
		Username:<input type="text" id="username" name="username">
		Password:<input type="password" id="password" name="password">
		<input type="submit" id="btnsubmit" value="Login">
		<input type="reset" id="btnreset" value="reset">
		<input type="button" id="test" value="test">		
	</form>
</body>
</html>