<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body bgcolor=#cdf2e3>
<center><font size="+1" color="red">${msg4}</font></center>

<table width="1000" height="200" align="center" border="1" cellpadding="3">
    <tr bgcolor="#B0E0E6">
        <td colspan="5"><font color="#556B2F"> ��ʦ��Ϣ���£�</font></td>
    </tr>
    <tr bgcolor="yellow">
        <td>��ʦ��</td>
        <td>�� ��</td>
        <td>�� ��</td>
        <td>ְ λ</td>
    </tr>
    <c:forEach items="${pageTeachers}" var="teacher">
        <tr bgcolor="pink">
            <td>${teacher.teano }</td>
            <td>${teacher.teaname }</td>
            <td>${teacher.teasex }</td>
            <td>${teacher.title }</td>
        </tr>
    </c:forEach>
    <tr bgcolor="#B0E0E6">
        <td colspan="5"><font color="#556B2F"> ��${teacherCount}����¼;
            ��${pageCount}ҳ;
            ��ǰ��${currentPageIndex}ҳ.</font></td>
    </tr>
</table>
<a href="/servlet/Admin_ManageTeachersServlet?pageIndex=1">��ҳ</a>
<c:if test="${currentPageIndex!=1}">
    <a href="/servlet/Admin_ManageTeachersServlet?pageIndex=${currentPageIndex-1}">��һҳ</a>
</c:if>
<c:if test="${currentPageIndex!=pageCount}">
    <a href="/servlet/Admin_ManageTeachersServlet?pageIndex=${currentPageIndex+1}">��һҳ</a>
</c:if>
<a href="/servlet/Admin_ManageTeachersServlet?pageIndex=${pageCount}">βҳ</a>
</body>
</html>
