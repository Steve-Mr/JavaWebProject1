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
        <td>密码</td>
        <td>姓名</td>
        <td>性别</td>
    </tr>
            <td>${requestScope.selectedstudent.stuno}</td>
    <td>${requestScope.selectedstudent.password}</td>
    <td>    ${requestScope.selectedstudent.stuname}</td>
    <td>    ${requestScope.selectedstudent.stusex}</td>

</table>
<tr height="10%"><td width="10%" align="center"><a href="/jsp/admin/admin_addstudent.jsp"  style=text-decoration:none>添加学生</a></td></tr>

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
