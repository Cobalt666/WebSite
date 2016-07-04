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
<script type="text/javascript" src="js/jquery-1.5.2.min.js"></script>
<script type="text/javascript">
/* 参考自http://www.jq22.com/jquery-info394 */
	var current = 0;
	$(document).ready(function() {

		$("#institute").change(function() {
			$("#institute option").each(function(i, o) {
				if ($(this).attr("selected")) {

					$(".depart").hide();
					$(".depart").eq(i).show();
					current = i;
				}
			});
		});
		$("#institute").change();
	});

	function getSelectValue() {
		alert("1级=" + $("#institute").val());

		$(".depart").each(function(i, o) {

			if (i == current) {
				alert("2级=" + $(".depart").eq(i).val());
			}
		});
	}
</script>
</head>
<body>
<div class="form-box-small">
        <h3>完善个人信息>></h3>
        <form id="signupForm" action="updateMyInfo" method="post" style="padding: 20px">
        
            <table class="table" id="TABLE1" >
                <tbody>
                    <tr>
                        <td width="20%">个人姓名：</td>
                        <td width="80%">
                        <input name="user.id" value="<s:property value="user.id"/>" type="hidden" />
                        <input name="user.name" value="<s:property value="user.name"/>" type="text" class="input-text radius" ID="user.name" datatype="*" required /></td>
                    </tr>
                    <tr>
                        <td>学号/工号：</td>
                        <td><input name="user.number" value="<s:property value="user.number"/>" type="text" class="input-text radius" ID="user.number" required  /></td>
                    </tr>
                    <tr>
                        <td>电子邮箱：</td>
                        <td><input name="user.email" value="<s:property value="user.email"/>" type="email" class="input-text radius" ID="user.email" required /></td>
                    </tr>
                    <tr>
                        <td>选择性别：</td>
                        <td>
                        	<div style="text-align:center;padding:3px">
								<input type="radio" name="user.gender" value="男" required>男 
								<input type="radio" name="user.gender" value="女">女 
							</div>
						</td>
                    </tr>
                    <tr>
                        <td>出生日期：</td>
                        <td><input name="user.birthdate" value="<s:property value="user.birthdate"/>" type="date" class="input-text radius" ID="user.birthdate" required /></td>
                    </tr>
                    <tr>
                        <td>联系方式：</td>
                        <td><input name="user.phone" value="<s:property value="user.phone"/>" type="text" class="input-text radius" ID="user.phone" required /></td>
                    </tr>
                    <tr>
                        <td>选择类别：</td>
                        <td>
                        	<div style="text-align:center;padding:3px">
								<input type="radio" name="user.cate" value="教师" required>教师 
								<input type="radio" name="user.cate" value="学生">学生 
							</div>
						</td>
                    </tr>
                    <tr>
                        <td>选择院系：</td>
                        <td>
							<span class="select-box">
								<select id="institute"  class="select" size="1" name="user.institute" datatype="*" required>
									<option value="" selected>----请选择方向----</option>
									<option value="新媒体">新媒体</option>
									<option value="动画">动画</option>
								</select>
							</span>
							<span class="select-box">
								<select class="depart select" size="1" name="user.depart">
									<option value="">----请选择----</option>
								</select>
								<select class="depart select" size="1" name="user.depart">
								<option value="" selected>----请选择----</option>
									<option value="信息管理信息系统">信息管理信息系统</option>
									<option value="网络工程">网络工程</option>
									<option value="数字媒体技术">数字媒体技术</option>
								</select>
								<select class="depart select" size="1" name="user.depart">
								<option value="" selected>----请选择----</option>
									<option value="动画">动画</option>
									<option value="数字媒体艺术">数字媒体艺术</option>
								</select>
							</span>
						</td>
                    </tr>
                    <tr>
                        <td>输入届数：</td>
                        <td>
                        	<input name="user.grade" value="<s:property value="user.grade"/>" type="text" class="input-text radius" ID="user.grade" required /></td>
                    </tr>
                    <tr>
                        <td>班级名称：</td>
                        <td>
                        	<input name="user.classname" value="<s:property value="user.classname"/>" type="text" class="input-text radius" ID="user.classname" required /></td>
                    </tr>
            </tbody></table><br>
            <div style="float:right">
                <input type="submit" class="btn btn-primary radius " value="确认" onclick="return confirm('确认更新？')" />
            </div>
            </form>
    </div>
</body>
</html>