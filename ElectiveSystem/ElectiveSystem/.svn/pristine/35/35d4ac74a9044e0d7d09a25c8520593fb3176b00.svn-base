
$().ready(function() {
	// 在键盘按下并释放及提交后验证提交表单
	$("#signupForm").validate({
		rules : {
			"user.name" : "required",
			"admin.password" : {
				required : true,
				minlength : 6
			},
			"user.password" : {
				required : true,
				minlength : 6
			},
			"user.number" : {
				required : true,
				minlength : 9
			},
			confirm_password : {
				required : true,
				minlength : 6,
				equalTo : "#password"
			},
			"user.email" : {
				required : true,
				email : true
			},
			/*"user.grade" : "required",*/
			"user.gender" : "required",
			/*"user.classname" : "required"*/
		},
		
		messages : {
			"user.name" : "请输入您的名字",
			"user.password" : {
				required : "请输入密码",
				minlength : "密码长度不能小于 6 个字母"
			},
			"admin.password" : {
				required : "请输入密码",
				minlength : "密码长度不能小于 6 个字母"
			},
			"user.number" : {
				required : "请输入编号",
				minlength : "长度不能小于 9 个"
			},
			confirm_password : {
				required : "请输入密码",
				minlength : "密码长度不能小于 6 个字母",
				equalTo : "两次密码输入不一致"
			},
			"user.email" : "请输入一个正确的邮箱",
			/*"user.grade" : "请选择年级",*/
			"user.gender" : "请选择性别",
			/*"user.classname" : "请输入班级"*/
		}
	});
});
