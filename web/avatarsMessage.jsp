<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件上传结果</title>
</head>
<body>
<h2 align="center">${message}</h2>
<%
    response.setHeader("refresh", "2; URL = /jsp/student/stu_ope.jsp");
%>
</body>
</html>