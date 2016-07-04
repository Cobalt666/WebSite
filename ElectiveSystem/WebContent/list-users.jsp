<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/iconfont.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
a{color:#000}
</style>

</head>
<body>
<div class="form-box-large" style="width:auto">
	<h3>用户列表>></h3>
	<form action="queryUsers" method="post" >
	<input class="input-search radius" placeholder="搜索内容" name="queryString" >
        <span class="select-box-small radius">
			<select id="institute"  class="select-small" size="1" name="queryCate">
				<option value="" selected>----请选择查询类型----</option>
				<option value="name">按名称</option>
				<option value="number">按编号</option>
				<option value="gender">按性别</option>
				<option value="cate">按类型</option>
			</select>
		</span>
        <input class="btn btn-primary radius" value="开始搜索" type="submit" />
    </form><br /><br />
		<table class="table table-border table-bordered table-hover table-striped radius">
  			<thead>
    		<tr>
    			<th>ID</th>
    			<th>编号</th>
    			<th>照片</th>
    			<th>姓名</th>
    			<th>性别</th>
    			<th>邮箱</th>
    			<th>联系方式</th>
    			<th>生日</th>
    			<th>类别</th>
    			<th>届</th>
    			<th>学院</th>
    			<th>专业</th>
    			<th>班级</th>
    			<th>更新</th>
    			<th>删除</th>
    		</tr>
  			</thead>
  		<tbody>
  		<s:iterator value="users" var="user">
  		<tr>
    			<td><s:property value="#user.id"/></td>
    			<td><s:property value="#user.number"/></td>
    			<td style="text-align:center">
    				<img class="avatar size-M radius" 
    				src="<s:property value="#user.avatar"/>"><br>
    				<a href="uploadAction?userid=<s:property value="#user.id"/>">
    					<i class="Hui-iconfont Hui-iconfont-upload bold-icon"></i>
					</a>
    			</td>
    			<td><s:property value="#user.name"/></td>
    			<td><s:property value="#user.gender"/></td>
    			<td><s:property value="#user.email"/></td>
    			<td><s:property value="#user.phone"/></td>
    			<td><s:property value="#user.birthdate"/></td>
    			<td><s:property value="#user.cate"/></td>
    			<td><s:property value="#user.grade"/></td>
    			<td><s:property value="#user.institute"/></td>
    			<td><s:property value="#user.depart"/></td>
    			<td><s:property value="#user.classname"/></td>
    			<td style="text-align:center;"><a href="updateInputUser?userid=<s:property value="#user.id"/>" >
    				<i class="Hui-iconfont Hui-iconfont-edit"></i>
				</a></td>
    			<td style="text-align:center;"><a href="deleteUser?userid=<s:property value="#user.id"/>"  onclick="return confirm('确认删除?')">
    					<i class="Hui-iconfont Hui-iconfont-del2"></i>
    			</a></td>
    	</tr>
		</s:iterator>
		</tbody>
		</table>
	</div>
</body>
</html>