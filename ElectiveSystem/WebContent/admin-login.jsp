<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选修课选课系统后台</title>
<link rel="stylesheet" type="text/css" href="css/login.css">

<s:if test="message != null"> 
<script language="JavaScript" type="text/javascript">alert('<s:property value="message" />');</script>
</s:if>

</head>

<body>
	<div class="title-login">选修课选课系统后台</div>
	<div class="box">

		<h3 style="text-align: center;">
			管理员登录
		</h3>
		<div id="form_1">
			<div class="line"></div>
			<br>
			<form method="post" action="admin-login" id="FORM1"
				style="padding: 5px; line-height: 35px">

				<input name="admin.name" type="text" id="u" placeholder="输入用户名" class="input-text size-L">
				<br><br> 
				<input name="admin.password" type="password" id="p" placeholder="输入密码" class="input-text size-L"> 
				<br><br> <input type="submit" value="登录" class="btn btn-primary size-L prolong">

			</form>
		</div>
		

	</div>


</body>
</html>