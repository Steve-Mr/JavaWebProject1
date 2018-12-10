<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<table width="1000" height="200" align="center" border="1" cellpadding="3">
    <tr bgcolor="#B0E0E6">
        <td colspan="5"><font color="#556B2F"> 课程信息如下：</font></td>
    </tr>
    <tr bgcolor="yellow">
        <td>课程号</td>
        <td>课程名</td>
        <td>授课教师</td>
        <td>学  分</td>
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
        <td colspan="5"><font color="#556B2F"> 共${courseCount}条记录，
            ${pageCount}页;
            当前第${currentPageIndex}页.</font></td>
    </tr>
</table>
<h3 align="center">
<a href="/servlet/Admin_ManageCoursesServlet?pageIndex=1">首页</a>
<c:if test="${currentPageIndex!=1}">
    <a href="/servlet/Admin_ManageCoursesServlet?pageIndex=${currentPageIndex-1}">上一页</a>
</c:if>
<c:if test="${currentPageIndex!=pageCount}">
    <a href="/servlet/Admin_ManageCoursesServlet?pageIndex=${currentPageIndex+1}">下一页</a>
</c:if>
<a href="/servlet/Admin_ManageCoursesServlet?pageIndex=${pageCount}">尾页</a>
</h3>
</body>
</html>
