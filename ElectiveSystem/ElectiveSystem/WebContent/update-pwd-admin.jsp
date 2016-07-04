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
<div class="form-box">
        <h3>密码修改>></h3>
        <form target="_parent" id="signupForm" method="post" action="updateAdminPwd" style="background-color: #fff; padding: 20px">
            	新密码：<br>
            <input class="input-text" id="password" name="admin.password" type="password" required />
            <br>再一次：<br>

            <input class="input-text" id="confirm_password" name="confirm_password" type="password" required />
            <br><br>
            
            <input type="submit" value="下一步" class="btn btn-primary size-M" />
            <br>
        </form>
    </div>
</body>
</html>