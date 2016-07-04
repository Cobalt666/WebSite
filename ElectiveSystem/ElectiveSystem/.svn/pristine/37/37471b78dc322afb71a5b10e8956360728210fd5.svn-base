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
	<h3>课程列表>></h3>
		<table class="table table-border table-bordered table-hover table-striped radius">
  			<thead>
    		<tr>
    			<th>ID</th>
    			<th>课程名称</th>
    			<th>开课教师</th>
    			<th>课程安排</th>
    			<th>开课时间</th>
    			<th>限制人数</th>
    			<th>所含学分</th>
    			<th>所属分类</th>
    			<th>更新</th>
    			<th>删除</th>
    		</tr>
  			</thead>
  		<tbody>
  		<s:iterator value="courses" var="course">
    		<tr>
    			<td><s:property value="#course.id"/></td>
    			<td><s:property value="#course.name"/></td>
    			<td><s:property value="#course.teacher"/></td>
    			<td><s:property value="#course.period"/></td>
    			<td><s:property value="#course.starttime"/></td>
    			<td><s:property value="#course.limitcount"/></td>
    			<td><s:property value="#course.credit"/></td>
    			<td><s:property value="#course.category"/></td>
    			<td style="text-align:center;">
    				<a href="updateInputCourse?courseid=<s:property value="#course.id"/>" >
    					<i class="Hui-iconfont Hui-iconfont-edit"></i>
					</a>
				</td>
    			<td style="text-align:center;">
    				<a href="deleteCourse?courseid=<s:property value="#course.id"/>" onclick="return confirm('确认删除?')" >
    					<i class="Hui-iconfont Hui-iconfont-del2"></i>
					</a>
				</td>
    		</tr>
    	</s:iterator>
  		</tbody>
</table>
	</div>



</body>
</html>