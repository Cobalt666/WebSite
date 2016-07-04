<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选修课选课系统</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script src="js/custom.js"></script>


<script language="JavaScript" type="text/javascript">
	function ChangeDiv(divId, divName, count) {
		for (i = 1; i <= count; i++) {
			document.getElementById(divName + i).style.display = "none";
		}
		document.getElementById(divName + divId).style.display = "block";
	}
</script>
</head>

<body>
	<div class="title-login">选修课选课系统</div>
	<div class="box">

		<h3 style="text-align: center;">
			<button class="btn-link "
				onClick="JavaScript:ChangeDiv('1','form_',2)">登录</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="btn-link "
				onClick="JavaScript:ChangeDiv('2','form_',2)">注册</button>
		</h3>
		<div id="form_1">
			<div class="line-left"></div>
			<br>
			<form method="post" action="login" id="FORM1" style="padding: 5px; line-height: 35px">

				<input name="user.number" type="text" id="u" placeholder="输入学号/职工编号" class="input-text size-L">
				<br><br> 
				<input name="user.password" type="password" id="p" placeholder="输入密码" class="input-text size-L"> 
				<div style="text-align:center;padding:5px">
				<input id="r"  type="radio" name="user.cate" value="教师">教师 
				<input id="r1" type="radio" name="user.cate" value="学生" checked>学生 </div>
				<input type="submit" value="登录" class="btn btn-primary size-L prolong">

			</form>
		</div>
		<div id="form_2" style="display: none">
			<div class="line-right"></div>
			<br>
			<form method="post" action="reg" id="signupForm" class="cmxform" style="padding: 5px; line-height: 35px">

				<input id="user.number" name="user.number" type="text" placeholder="输入学号/职工编号，至少9位数字" class="input-text"><br><br>
				<input id="user.name" name="user.name" type="text"  placeholder="输入姓名，汉字" class="input-text" ><br><br>
				<input id="user.classname" name="user.classname" type="text" placeholder="输入班级名称" class="input-text" ><br><br>
				<input id="user.email" name="user.email" type="text" placeholder="输入邮箱" class="input-text" ><br><br>
				<input id="password" name="user.password" type="password" placeholder="输入密码" recheck="password"  class="input-text" ><br> <br>
				<input id="confirm_password" name="confirm_password" type="password" placeholder="再次输入" class="input-text"><br> <br>
				<input id="user.grade" name="user.grade" type="text" placeholder="届，入学年份后两位" class="input-text"><br><br>
				<div style="text-align:center;padding:3px">
				<input type="radio" name="user.gender" value="男" required>男 
				<input type="radio" name="user.gender" value="女">女 </div>
				
				<div style="text-align:center;padding:3px">
				<input id="r"  type="radio" name="user.cate" value="教师" required>教师 
				<input id="r1" type="radio" name="user.cate" value="学生">学生 </div>
				<input type="submit" value="注册" class="btn btn-primary size-L prolong">

			</form>
		</div>

	</div>


</body>
</html>