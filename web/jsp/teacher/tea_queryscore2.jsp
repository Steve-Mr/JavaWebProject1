<%@ page contentType="text/html; charset=gb2312" language="java" import="java.util.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dao.TeacherDAO"%>
<%@page import="vo.Teacher"%>
<%@page import="dao.CourseDAO"%>
<%@page import="vo.Course"%>

<body>
<center><font size="+1" color="red">${msg8}</font></center>
<c:if test="${msg8==null}">
    <br><br>
    <center><img src="${chartUri }"></center>
</c:if>
</body>