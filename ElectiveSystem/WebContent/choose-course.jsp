<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/iconfont.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
	<div class="form-box-large" style="width: auto">
		<h3>课程列表>></h3>
		<form action="queryCoursesByUser" method="post">
			<input class="input-search radius" placeholder="搜索内容"
				name="queryString"> <span class="select-box-small radius">
				<select id="institute" class="select-small" size="1"
				name="queryCate">
					<option value="" selected>----请选择查询类型----</option>
					<option value="name">按名称</option>
					<option value="teacher">按老师</option>
					<option value="category">按分类</option>
			</select>
			</span> <input class="btn btn-primary radius" value="开始搜索" type="submit" />
		</form>
		<br>
		<form action="queryCoursesByUserNotEmpty" method="post">
			<input class="btn btn-primary radius" value="只看余量不为0的" type="submit" />
		</form>
		<br>
		<div
			style="font-size: 0px; line-height: 0px; border-top: solid 1px #ddd; float: none;"></div>
		<br>
		<div class="error">
			<%
				if (null != session.getAttribute("msg"))
					out.print(session.getAttribute("msg").toString());
			%>
		</div>
		<table
			class="table table-border table-bordered table-hover table-striped radius">
			<thead>
				<tr class="text-c">
					<th>课程名称</th>
					<th>开课教师</th>
					<th>课程安排</th>
					<th>开课时间</th>
					<th>限制人数</th>
					<th>所含学分</th>
					<th>所属分类</th>
					<th>剩余人数</th>
					<th>选择</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="courses" var="course">
					<tr class="text-c">
						<td><s:property value="#course.name" /></td>
						<td><s:property value="#course.teacher" /></td>
						<td><s:property value="#course.period" />，<s:property
								value="#course.room" /></td>
						<td><s:property value="#course.starttime" /></td>
						<td><s:property value="#course.limitcount" /></td>
						<td><s:property value="#course.credit" /></td>
						<td><s:property value="#course.category" /></td>
						<td><s:property value="#course.rest" /></td>
						<td><a
							href="choose?courseid=<s:property value="#course.id"/>"
							onclick="return confirm('确认添加?')"> <i
								class="Hui-iconfont Hui-iconfont-add2"></i>
						</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<s:action name="showMyCourse" namespace="/" executeResult="true"></s:action>
	<script type="text/javascript">
		/* 参考自http://www.h-ui.net/Hui-4.12-toTop.shtml */
		var $backToTopEle = $(
				'<a href="javascript:void(0)" class="Hui-iconfont toTop" title="返回顶部" alt="返回顶部" style="display:none">&#xe684;</a>')
				.appendTo($("body")).click(function() {
					$("html, body").animate({
						scrollTop : 0
					}, 120);
				});
		var $backToTopFun = function() {
			var st = $(document).scrollTop(), winh = $(window).height();
			(st > 0) ? $backToTopEle.show() : $backToTopEle.hide();
			/*IE6下的定位*/
			if (!window.XMLHttpRequest) {
				$backToTopEle.css("top", st + winh - 166);
			}
		};
		$(function() {
			$(window).on("scroll", $backToTopFun);
			$backToTopFun();
		});
	</script>
</body>
</html>