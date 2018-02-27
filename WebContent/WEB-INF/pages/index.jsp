<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
   	<title></title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta name="renderer" content="webkit">
	<link rel="shortcut icon" href="<%=path%>/favicon.ico" type="image/x-icon" />
	<script type="text/javascript" src="<%=path%>/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			
			$("#testAjax").click(function(){
				$.ajax({                
					cache: false,    
					async: false, 
					type: "POST",                
					url:  '<%=path%>/company/add',                
					data:{
						tset : 'test'
					},              
					error: function(request) { 
						alert("网络错误");
					},
					beforeSend : function(request){
					},
					success: function(data) {
						alert(data);
						console.log(data);
					}
				});
			});
		});
	</script>
	
	</head>
	<body>
		所有的企业：</br>
		<c:forEach items="${infoList }" var="m">
			${m.ent_name }</br>
		</c:forEach>
		</br>
		</br>
		</br>
		<a href="javascript:;" id="testAjax">事物测试</a></br>
	</body>
</html>

