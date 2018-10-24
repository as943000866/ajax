<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		var aNodes = document.getElementsByTagName("a");
		for (var i = 0; i < aNodes.length; i++) {
			aNodes[i].onclick = function(){
				
				var request = new XMLHttpRequest();
				var method = "GET";
				var url = this.href;
				request.open(method, url);
				request.send(null);
				
				request.onreadystatechange = function(){
					if(request.readyState == 4){
						if(request.status == 200 || request.status == 304){
							//1.结果为 XML 格式,所以需要使用 resposeXML 来获取
							var result = request.responseXML;
							
							//结果不能直接使用,必须先创建对应的节点,在把节点加到 #details中
							//目标格式为
							/* 
							<h2>
								<a href="cc">cc</a>
							</h2>
							<a>cc</a> 
							*/
							var name = result.getElementsByTagName("name")[0].firstChild.nodeValue;
							var website = result.getElementsByTagName("website")[0].firstChild.nodeValue;
							var email = result.getElementsByTagName("email")[0].firstChild.nodeValue;
							
							var aNode = document.createElement("a");
							aNode.appendChild(document.createTextNode(name));
							aNode.href = "lmg:" + email;
							
							var h2Node = document.createElement("h2");
							h2Node.appendChild(aNode);
							
							var aNode2 = document.createElement("a");
							aNode2.appendChild(document.createTextNode(website));
							aNode2.href = website;
							
							var detailsNode = document.getElementById("details");
							detailsNode.innerHTML = "";
							detailsNode.appendChild(h2Node);
							detailsNode.appendChild(aNode2);
						}
					}
				}
				
				return false;
			}
		}
	}
</script>
</head>
<body>
	<h1>People</h1>
	<ul>
		<li>
			<a href="files/andy.xml">andy</a>
		</li>
		<li>
			<a href="files/jeremy.xml">richard</a>
		</li>
		<li>
			<a href="files/richard.xml">jeremy</a>
		</li>
	</ul>
	<div id="details">
		
	</div>
</body>
</html>