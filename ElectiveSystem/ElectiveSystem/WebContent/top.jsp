<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix ="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/top.css">
<script type="text/javascript">
	function show_confirm() {
		return confirm("确认退出？");
		if (r == true) {
			return true;
		} else {
			return false;
		}
	}
</script>

<title></title>
<link rel="stylesheet" type="text/css" href="css/top.css">
</head>
<body>
	<span class="navbar">
		<span class="logo">选修课选课系统</span> 
		<span class="tuichu">欢迎，<%=session.getAttribute("name") %>&nbsp;<a href="exit" target="_parent">[登出]</a></span>
	</span>
</body>
</html>