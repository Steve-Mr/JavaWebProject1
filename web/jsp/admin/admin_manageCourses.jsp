<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<table width="1000" height="200" align="center" border="1" cellpadding="3">
    <tr bgcolor="#B0E0E6">
        <td colspan="5"><font color="#556B2F"> �γ���Ϣ���£�</font></td>
    </tr>
    <tr bgcolor="yellow">
        <td>�γ̺�</td>
        <td>�γ���</td>
        <td>�ڿν�ʦ</td>
        <td>ѧ  ��</td>
    </tr>
    <c:forEach items="${pageCourses}" var="course">
        <tr bgcolor="pink">
            <td>${course.courseno }</td>
            <td>${course.coursename }</td>
            <td>${course.teaname }</td>
            <td>${course.credit }</td>
        </tr>
    </c:forEach>
    <tr bgcolor="#B0E0E6">
        <td colspan="5"><font color="#556B2F"> ��${courseCount}����¼��
            ${pageCount}ҳ;
            ��ǰ��${currentPageIndex}ҳ.</font></td>
    </tr>
</table>
<h3 align="center">
<a href="/servlet/Admin_ManageCoursesServlet?pageIndex=1">��ҳ</a>
<c:if test="${currentPageIndex!=1}">
    <a href="/servlet/Admin_ManageCoursesServlet?pageIndex=${currentPageIndex-1}">��һҳ</a>
</c:if>
<c:if test="${currentPageIndex!=pageCount}">
    <a href="/servlet/Admin_ManageCoursesServlet?pageIndex=${currentPageIndex+1}">��һҳ</a>
</c:if>
<a href="/servlet/Admin_ManageCoursesServlet?pageIndex=${pageCount}">βҳ</a>
</h3>
</body>
</html>
