<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="form-box-small">
<%
				if (null == application.getAttribute("allow")||application.getAttribute("allow").toString().equals("no")){
					out.print("<h4>现在未开放选课</h4>");
					out.print("<a href=\"allowSelect\" class='btn btn-primary radius'>点击开放选课</a>");
				}else{
					out.print("<h4>现在已开放选课</h4>");
					out.print("<a href=\"disallowSelect\" class='btn btn-primary radius'>点击关闭选课</a>");
				}
					
%>
 </div>
</body>
</html>