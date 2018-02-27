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
		function delCookies(){
			var keys=document.cookie.match(/[^ =;]+(?=\=)/g);
		    if (keys) {
		        for (var i =  keys.length; i--;)
		            document.cookie=keys[i]+'=0;expires=' + new Date( 0).toUTCString()
		    }  
		}
		
		function getCookies(){
			var allcookies = document.cookie;
			console.log(allcookies);
		}
		
		//设置Cookie
		function fSetCookie(name, value, isForever, domain){
		    var sDomain = ";domain=" + (domain || gOption["sCookieDomain"] );
		    document.cookie = name + "=" + escape(value) + sDomain + (isForever?";expires="+  (new Date(2099,12,31)).toGMTString():"");
		}
		
		var id = 75;
		
		function tp(){
			$.ajax({                
				cache: false,    
				async: false, 
				type: "POST",                
				url:  'http://jb.echevip.com/Inc/Ajax_tp.aspx?id=' + id,                
				data:{
				},              
				error: function(request) { 
					alert("网络错误");
				},
				beforeSend : function(request){
				},
				success: function(data) {
					console.log(data);
					if(id == 75){
						id = 71
					}else if(id ==71 ){
						id = 75
					}
				},
				complete: function(data) { 
					
				}
			});
		}
		
		function tp_1(){
			setTimeout(function(){
				tp();
			},1000);
		}
		
	
	</script>
	
	</head>
	<body>
		
		<button id="test" onclick="tp_1();">投票 </button>
		<button id="test" onclick="fSetCookie(1,2,3,'/');">设置cookie </button>
		<button id="test" onclick="getCookies();">获取所有cookies </button>
		<button id="test" onclick="delCookies();">cookies </button>
		<button id="test" onclick="delCookies();">cookies </button>
		
	</body>
</html>

