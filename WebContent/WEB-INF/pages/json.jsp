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
   	<title>Json 参数请求</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta name="renderer" content="webkit">
	<link rel="shortcut icon" href="<%=path%>/favicon.ico" type="image/x-icon" />
	<script type="text/javascript" src="<%=path%>/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/system.js"></script>
	
	<script type="text/javascript">
		function tp(){
			$.ajax( {
			    url : 'http://localhost:8082/SpringMVC3/test/v1?token=adfa',
			    type : "POST", 
			    dataType:"json",
			    contentType:'application/json;charset=UTF-8',
			    data:JSON.stringify({
			    	name : '张三', 
			    	token : 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
			    	id : 1,
			    	password : 'passwordd',
			    	qq : 'asdfasdfasdfasdfasdfasdf',
			    	qq2 : 'asdfasdfasdfasdfasdf'
			    }),
			    success : function(data) {
			    	console.log(data);   
			   
			    },
				error:function(e){
			    alert("err"); 
				}
			    });
		}
		
	
	</script>
	
	</head>
	<body>
		
		<button id="test" onclick="tp();">test Json 参数请求 </button>
		
	</body>
</html>

