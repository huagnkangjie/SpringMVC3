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
		
	</script>
	
	</head>
	<body>
		<a href="<%=path%>/article/1.html">第1篇文章</a></br></br>
		<a href="<%=path%>/article/2.html">第2篇文章</a></br></br>
		<a href="<%=path%>/article/3.html">第3篇文章</a></br></br>
		<a href="<%=path%>/article/4.html">第4篇文章</a></br></br>
		<a href="<%=path%>/article/5.html">第5篇文章</a></br></br>
		<a href="<%=path%>/article/6.html">第6篇文章</a></br></br>
	</body>
</html>

