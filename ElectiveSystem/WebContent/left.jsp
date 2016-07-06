<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/left.css">
<link href="css/iconfont.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.12.1.js"></script>
<script type="text/javascript">
	function ChangeDiv(id) {
		if ($("ul.sub" + id).is(':visible')) {
			$(".sub" + id).slideUp(300);
		} else {
			$(".sub" + id).slideDown(300);
		}
	}
</script>
</head>
<body>

	<nav class="leftnav">
	<ul>

		<nav class="leftnav">
		<ul>
			<li><a href="main.html" target="main">回到首页</a></li>
			<li><a onClick="JavaScript:ChangeDiv('1')" style="font-weight:bold" href="#">系统设置<i
					class="Hui-iconfont Hui-iconfont-arrow2-bottom right"></i></a></li>
			<ul class="sub1">
				<s:if test="#session.cate!='admin'.toString()">
					<li><a href="showMyInfo" target="main">个人信息</a></li>
					<li><a href="updateInputMyInfo" target="main">信息完善</a></li>
					<li><a href="updateInputPwd" target="main">密码更改</a></li>
				</s:if>
				<s:else><li><a href="updateAdminInputPwd" target="main">密码更改</a></li></s:else>
			</ul>
			<li><a onClick="JavaScript:ChangeDiv('2')" style="font-weight:bold" href="#">选课设置<i
					class="Hui-iconfont Hui-iconfont-arrow2-bottom right"></i></a></li>
			<ul class="sub2">
				<s:if test="#session.cate=='admin'.toString()">
				<li><a href="add-course.jsp" target="main">添加新课</a></li>
				<li><a href="listCourses" target="main">课程管理</a></li>
				<li><a href="listUsers" target="main">用户管理</a></li>
				<li><a href="allow-select.jsp" target="main">选课开放</a></li>
				
				</s:if>
				<s:elseif test="#session.cate=='教师'.toString()">
				<li><a href="add-course.jsp" target="main">添加新课</a></li>
				</s:elseif>
				<s:else>
				<%
				if (null != session.getAttribute("allow")){
					if(session.getAttribute("allow").toString().equals("yes"))
						out.print("<li><a href=\"chooseACourse\" target=\"main\">选择课程</a></li>");
				}
				%>
				<!-- <li><a href="chooseACourse" target="main">选择课程</a></li> -->
				<li><a href="showMyCourse" target="main">我的课程</a></li>
				</s:else>
			</ul>
		</nav>
	</ul>
	</nav>


</body>
</html>