<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body bgcolor=#cdf2e3>
<center><font size="+1" color="red">${msg4}</font></center>

<table width="1000" height="200" align="center" border="1" cellpadding="3">
    <tr bgcolor="#B0E0E6">
        <td colspan="5"><font color="#556B2F"> 学生信息如下：</font></td>
    </tr>
    <tr bgcolor="yellow">
        <td>学号</td>
        <td>姓名</td>
        <td>性别</td>
    </tr>
    <c:forEach items="${pageStudents}" var="student">
        <tr bgcolor="pink">
            <td>${student.stuno }</td>
            <td>${student.stuname }</td>
            <td>${student.stusex }</td>
        </tr>
    </c:forEach>
    <tr bgcolor="#B0E0E6">
        <td colspan="5"><font color="#556B2F"> 共${studentCount}条记录;
            共${pageCount}页;
            当前第${currentPageIndex}页.</font></td>
    </tr>
</table>
<a href="/servlet/Admin_ManageStudentsServlet?pageIndex=1">首页</a>
<c:if test="${currentPageIndex!=1}">
    <a href="/servlet/Admin_ManageStudentsServlet?pageIndex=${currentPageIndex-1}">上一页</a>
</c:if>
<c:if test="${currentPageIndex!=pageCount}">
    <a href="/servlet/Admin_ManageStudentsServlet?pageIndex=${currentPageIndex+1}">下一页</a>
</c:if>
<a href="/servlet/Admin_ManageStudentsServlet?pageIndex=${pageCount}">尾页</a>
</body>
</html>
