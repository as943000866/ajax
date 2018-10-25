<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 
1. 获取当前页面的所有的 a 节点, 并为每个 a 节点都添加 onclick 响应函数, 同时取消其默认行为
2. 准备发送 Ajax 请求: url(a 节点的 href 属性值); args(时间戳)
3. 响应为一个 JSON 对象, 包括: bookName, totalBookNumber, totalMoney
4. 把对应的属性添加到对应的位置
 -->
 <script type="text/javascript" src="${pageContext.request.contextPath }/script/jquery-1.10.1.js"> </script>
 <script type="text/javascript" >
 	$(function(){
 		$("a").click(function(){
 			var url = this.href;
 			var args = {"time": new Date()};
 			
 			$.getJSON(url, args, function(data){
 				$("#bookName").text(data.bookName);
 				$("#totalBookNumber").text(data.totalBookNumber);
 				$("#totalMoney").text(data.totalMoney);
 			})
 			
 			return false;
 		});
 		
 	})
 </script>
</head>
<body>
	 我已经将&nbsp; <span id="bookName"></span> &nbsp; 加入到购物车中.
	 购物车中的书有&nbsp;  <span id="totalBookNumber"></span> &nbsp; 本. 
	 总价格&nbsp;  <span id="totalMoney"></span> &nbsp; 钱.
	
	<br><br>
	Java &nbsp;&nbsp;<a href="${pageContext.request.contextPath }/addToCart?id=Java&price=100">加入购物车</a>
	<br><br>
	
	Oracle &nbsp;&nbsp;<a href="${pageContext.request.contextPath }/addToCart?id=Oracle&price=200">加入购物车</a>
	<br><br>
	
	Oracle &nbsp;&nbsp;<a href="${pageContext.request.contextPath }/addToCart?id=Struts2&price=200">加入购物车</a>
	<br><br>
</body>
</html>