<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script src="js/upload-show.js"></script>
</head>
<body>
<div class="form-box">
        <h3>头像上传>></h3>
        <form id="signupForm" method="post" action="uploadAvatar" enctype="multipart/form-data"
         style="background-color: #fff; padding: 20px">

            <input name="file" id="file" type="file" onchange="javascript:setImagePreview();"><br>

            <br><div id="localImag"><img id="preview" width=-1 height=-1 style="diplay:none" /><br></div>
            
            <input type="submit" value="上传" class="btn btn-primary size-M" onclick="return confirm('确认提交？')" />
            <br>
        </form>
    </div>
</body>
</body>
</html>