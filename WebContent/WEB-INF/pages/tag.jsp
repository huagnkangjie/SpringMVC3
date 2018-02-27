<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="/WEB-INF/tld" prefix="mytag"%>
<html>
  <head>
    <title>My JSP 'Test.jsp' starting page</title>
  </head>
 
  <body>
    This is my JSP page. <br>
    Date : <mytag:demo /><br>
    File : <mytag:demo parameter="filename" /></br>
    test : <mytag:demo parameter="test" />
  </body>
</html>