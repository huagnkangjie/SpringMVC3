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
	<script language="javascript" type="text/javascript">   
	
		function a(callback){
			console.log("调用函数");
			callback();
		}
		
		function b(){
			console.log("回调b");
		}
		
		function c(){
			console.log("回调c");
		}
		  
		function test(){
			a(c);
		}
		
		function ajaxTest1(){
			ajaxAsync('company/add',ajaxCallback);
		}
		
		function ajaxCallback(data){
			console.log(111);
			console.log(111 + " >>>>>>> " + data);
		}
		function ajaxTest2(){
			ajaxAsync('company/add',ajaxCallback2);
		}
		
		function ajaxCallback2(data){
			console.log(222);
			console.log(222 + " >>>>>>> " + data);
		}
		
		function ajaxAsync(/*url*/url, callback){
			
			$.ajax({                
				cache: false,    
				async: true, 
				type: "POST",                
				url:  '<%=path%>/' + url,                
				data:{
					tset : 'test'
				},              
				error: function(request) { 
					alert("网络错误");
				},
				beforeSend : function(request){
				},
				complete: function(data) {
					console.log(data);
					callback(data);
				}
			});
		}
	</script>   
	</head>   
	   
	<body>   
	<button onClick="test();">click me</button>   
	<button onClick="ajaxTest1();">ajax test1</button>   
	<button onClick="ajaxTest2();">ajax test2</button>   
	</body>
</html>

