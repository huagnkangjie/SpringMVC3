<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<% String url = request.getRequestURL().toString();
	if(null!=url&&url.startsWith("http://kaipin.tv")) 
	response.sendRedirect("http://www.kaipin.tv");
%>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
   	<title></title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta name="renderer" content="webkit">
	<link rel="shortcut icon" href="<%=basePath%>/favicon.ico" type="image/x-icon" />
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		
	</script>
	
	</head>
	<body>
		首页</br>
		<a href="<%=basePath%>/main/index?pages=index">进入管理页面</a></br></br>
		<a href="<%=basePath%>/main/index?pages=uediter">uediter</a></br></br>
		<a href="javascript:void(0);" id="ajaxAbortStart">Ajax abort  Start</a></br></br>
		<a href="javascript:void(0);" id="ajaxAbortEnd">Ajax abort  End</a></br></br>
		<a href="<%=path%>/article/list/1">table 页面</a></br></br>
		<a href="<%=basePath%>/main/index?pages=tag">自定义标签</a></br></br>
		<a href="<%=basePath%>/main/index?pages=websocket">websoket</a></br></br>
		<a href="<%=basePath%>/main/index?pages=callback">callback</a></br></br>
		<a href="<%=basePath%>/main/index?pages=jQuery">jQuery 闭包</a></br></br>
		<a href="<%=basePath%>/main/index?pages=cookies">cookies 操作</a></br></br>
		<a href="<%=basePath%>/main/index?pages=json">json 参数请求</a></br></br>
		<a href="javascript:void(0);" id="aopLog">aop log</a></br></br>
	</body>
	
	<script type="text/javascript">
		var request = "";
		$(function(){
			$("#ajaxAbortStart").click(function(){
				if(request != ''){
					 request.abort();
					 request = "";
					 alert("中断了链接");
				}
				request = $.ajax({
					url: '<%=path%>/main/abort',
					success:function(data){
						alert(data);
						request = "";
					},
				});
			});
			$("#ajaxAbortEnd").click(function(){
				if(request != ''){
					 request.abort();
					 request = "";
				}
			});
			
			$("#aopLog").click(function(){
				$.ajax({
					url: '<%=path%>/aop/log',
					success:function(data){
						alert(data);
					}
				});
			});
		});
	</script>
</html>

