<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix ="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script src="js/custom.js"></script>
</head>
<body>
<div class="form-box-small">
        <h3>更新>></h3>
        <form id="signupForm" action="updateCourse" method="post" style="padding: 20px">
        
            <table class="table" id="TABLE1" >
                <tbody>
                    <tr>
                        <td width="20%">课程名称：</td>
                        <td width="80%">
                        <input name="course.id" value="<s:property value="course.id"/>" type="hidden" />
                        <input name="course.name" value="<s:property value="course.name"/>" type="text" class="input-text radius" ID="course.name" datatype="*" required /></td>
                    </tr>
                    <tr>
                        <td>开课教师：</td>
                        <td><input name="course.teacher" value="<s:property value="course.teacher"/>" type="text" class="input-text radius" ID="course.teacher" required  /></td>
                    </tr>
                    <tr>
                        <td>限制人数：</td>
                        <td><input name="course.limitcount" value="<s:property value="course.limitcount"/>" type="number" class="input-text radius" ID="course.limitcount" required /></td>
                    </tr>
                    <tr>
                        <td>课程安排：</td>
                        <td><input name="course.period" value="<s:property value="course.period"/>" type="text" class="input-text radius" ID="course.period" required /></td>
                    </tr>
                    <tr>
                        <td>上课教室：</td>
                        <td><input name="course.room" value="<s:property value="course.room"/>" type="text" class="input-text radius" ID="course.room" required /></td>
                    </tr>
                    <tr>
                        <td>开课时间：</td>
                        <td><input name="course.starttime" value="<s:property value="course.starttime"/>" type="date" class="input-text radius" ID="course.starttime" required /></td>
                    </tr>
                    <tr>
                        <td>包含学分：</td>
                        <td><input name="course.credit" value="<s:property value="course.credit"/>" type="number" class="input-text radius" ID="course.credit" required /></td>
                    </tr>
                    <tr>
                        <td>课程类别：</td>
                        <td>
                        	<span class="select-box">
  								<select class="select" size="1" name="course.category" datatype="*" required>
    								<option value="" selected>选择类别</option>
    								<option value="人文社科">人文社科</option>
    								<option value="科学技术">科学技术</option>
  								</select>
							</span>
						</td>
                    </tr>
                    
            </tbody></table><br>
            <div style="float:right">
                <input type="submit" class="btn btn-primary radius " value="确认" onclick="return confirm('确认更新？')" />
            </div>
            </form>
    </div>
</body>
</html>