<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body bgcolor=#cdf2e3>
<center><font size="+1" color="red">${msg4}</font></center>

<table width="1000" height="200" align="center" border="1" cellpadding="3">
    <tr bgcolor="#B0E0E6">
        <td colspan="5"><font color="#556B2F"> ѧ����Ϣ���£�</font></td>
    </tr>
    <tr bgcolor="yellow">
        <td>ѧ��</td>
        <td>����</td>
        <td>�Ա�</td>
    </tr>
    <c:forEach items="${pageStudents}" var="student">
        <tr bgcolor="pink">
            <td>${student.stuno }</td>
            <td>${student.stuname }</td>
            <td>${student.stusex }</td>
        </tr>
    </c:forEach>
    <tr bgcolor="#B0E0E6">
        <td colspan="5"><font color="#556B2F"> ��${studentCount}����¼;
            ��${pageCount}ҳ;
            ��ǰ��${currentPageIndex}ҳ.</font></td>
    </tr>
</table>
<a href="/servlet/Admin_ManageStudentsServlet?pageIndex=1">��ҳ</a>
<c:if test="${currentPageIndex!=1}">
    <a href="/servlet/Admin_ManageStudentsServlet?pageIndex=${currentPageIndex-1}">��һҳ</a>
</c:if>
<c:if test="${currentPageIndex!=pageCount}">
    <a href="/servlet/Admin_ManageStudentsServlet?pageIndex=${currentPageIndex+1}">��һҳ</a>
</c:if>
<a href="/servlet/Admin_ManageStudentsServlet?pageIndex=${pageCount}">βҳ</a>
</body>
</html>
