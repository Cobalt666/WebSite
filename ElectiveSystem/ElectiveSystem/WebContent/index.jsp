<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.5.2.min.js"></script>
<script type="text/javascript">
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
<body>
	<select id="institute">
		<option>----请选择方向----</option>
		<option value="新媒体">新媒体</option>
		<option value="动画">动画</option>
	</select>
	<select class="depart">
		<option>----请选择----</option>
	</select>

	<select class="depart">
		<option>信息管理信息系统</option>
		<option>网络工程</option>
		<option>数字媒体技术</option>
	</select>
	<select class="depart">
		<option>动画</option>
		<option>数字媒体艺术</option>
	</select>
</body>
</html>