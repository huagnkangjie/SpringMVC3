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
   	<title>jQuery 闭包</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta name="renderer" content="webkit">
	<link rel="shortcut icon" href="<%=path%>/favicon.ico" type="image/x-icon" />
	<script type="text/javascript" src="<%=path%>/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/system.js"></script>
	
	<script type="text/javascript">
		var name = "全局test";
		var obj = {
				name : 'obj - > test',
				_test : function(){
					return this.name;
				}
		}
		$(function(){
			console.log(obj._test());
			
		});
		
		$(function(){
			console.log(">>>"+system.orgName);
			system.orgName = "新的val";
		});
		$(function(){
			console.log(">>>"+system._getLogo(""));
		});
		
		
		
		
		
		
		
		
		(function(){
			
		})();
		
		
		(function($){
			
		})(jQuery);
	</script>
	
	</head>
	<body>
		
		<button id="test">test 闭包 </button>
	</body>
</html>

