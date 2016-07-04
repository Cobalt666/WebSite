<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/iconfont.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/style.css">
<style type="text/css">
a{color:#5a98de;font-size:18px}
a:hover{font-weight:bold}
</style>
</head>
<body>
<div class="form-box">
	<h3>个人信息>></h3>
	<table class="table table-hover table-border table-bordered table-striped">
    	<tbody>
        	<tr>
            	<td width="10%">学号/工号</td>
				<td width="25%">
                    <s:property value="user.number"/>
				</td>
				<td width="10%">姓名</td>
				<td>
                    <s:property value="user.name"/>
				</td>
				<td rowspan="5" style="text-align:center">
				
					<img class="avatar" 
    				src="<s:property value="user.avatar"/>"><br>
    				<a href="upload-avatar.jsp">
    				<i class="Hui-iconfont Hui-iconfont-upload size-L"></i>
    			</a>
                </td>
            </tr>
           <tr>
            	<td>性别</td>
				<td>
                    <s:property value="user.gender"/>
				</td>
				<td>出生日期</td>
				<td>
                    <s:property value="user.birthdate"/>
				</td>
			</tr>
			<tr>
            	<td>所在院系</td>
				<td>
                   <s:property value="user.institute"/>,<s:property value="user.depart"/>
				</td>
				<td>班级</td>
				<td>
                    <s:property value="user.classname"/>
				</td>
			</tr>
			<tr>
            	<td>邮箱</td>
				<td colspan="3">
				<s:property value="user.email"/>
				</td>
			</tr>
			<tr>
            	<td>联系方式</td>
				<td colspan="3">
				<s:property value="user.phone"/>
				</td>
			</tr>
        </tbody>
    </table>
    
</div>
</body>
</html>