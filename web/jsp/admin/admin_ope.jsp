
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body bgcolor="#cdf2e3">
<table witdh="100%" height="100%" border="1">
    <tr height="10%"><td colspan="2"><p><img src="/res/images/img01.jpg"></p></td></tr>
    <tr>
        <td height="10%" width="10%" align="center"><a href="/servlet/Admin_ManageStudentsServlet" target="iframe1" style=text-decoration:none>管理学生</a></td>
        <td rowspan="8"><iframe width="100%" height="100%" name="iframe1" frameborder="0" src="/jsp/right.jsp"></iframe></td>
    </tr>
    <tr height="10%"><td width="10%" align="center"><a href="/servlet/Admin_ManageTeachersServlet" target="iframe1" style=text-decoration:none>管理教师</a></td></tr>
    <tr height="10%"><td width="10%" align="center"><a href="/servlet/Admin_ManageCoursesServlet" target="iframe1" style=text-decoration:none>管理课程</a></td></tr>
    <tr height="10%"><td width="10%" align="center"><a href="/jsp/modifyPwd.jsp" target="iframe1" style=text-decoration:none>修改密码</a></td></tr>
    <tr height="10%"><td width="10%" align="center"><a href="/servlet/LogoutServlet" style=text-decoration:none>退 出</a></td></tr>
    <tr heigth="10%"><td>&nbsp;</td></tr>
    <tr heigth="5%"><td colspan="2">
        <pre style="display:inline"><font color="#556B2F">    ${type }：[${teacher.teano}] ${teacher.teaname }                                                                                                                     COPYRIGHT 2000-2010 BY  流殇  ALL RIGHTS RESERVED</font></pre>
    </td></tr>
</table>
</body>
</html>
