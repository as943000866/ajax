<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/jquery-1.10.1.js"></script>
<script type="text/javascript">
$(function(){
	$("a").click(function(){
		
		var url = this.href;
		var args = {"time":new Date()};
		
		//url:
		//args: JSON 格式
		//function: 回调函数: 当响应结束时, 回调函数被触发.
		$.getJSON(url, args, function(data){
			var name = data.person.name;
			var email = data.person.email;
			var website = data.person.website;
			
			$("#details").empty().append("<h2><a href='aa:" + email + "'>" + name + "</a></h2>")
								 .append("<a>" + website + "</a>");
			
		});
		
		return false;
	});	
})
</script>
</head>
<body>
	<h1>People</h1>
	<ul>
		<li>
			<a href="files/andy.js">andy</a>
		</li>
		<li>
			<a href="files/richard.js">richard</a>
		</li>
		<li>
			<a href="files/jeremy.js">jeremy</a>
		</li>
	</ul>
	<div id="details">
		
	</div>
</body>
</html>