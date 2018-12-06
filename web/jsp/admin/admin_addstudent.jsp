<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body bgcolor=#cdf2e3>
<center><font size="+1" color="red">${okayMsg1}</font></center>	<br><br>
<c:if test="${okayMsg1==null}">
    <form action="/servlet/Admin_AddStudentServlet" method="post">
        <table align=center>
            <tr>
                <td align=right>输入学生学号：</td>
                <td align=left><input type="text" name="stuno"></td>
            </tr>
            <tr>
                <td align=right>输入学生初始密码：</td>
                <td align=left><input type="password" name="stupwd"></td>
            </tr>
            <tr>
                <td align=right>输入学生姓名：</td>
                <td align=left><input type="text" name="stuname"></td>
            </tr>
            <tr>
                <td align=right>输入学生性别：</td>
                <td align=left><input type="text" name="stusex"></td>
            </tr>
            <tr>
                <td align=right><input type="submit" value="提交"></td>
                <td align=left><input type="reset" value="重置"></td>
            </tr>
            <tr><td colspan=2>&nbsp;</td></tr>
            <tr>
                <td colspan=2 align=center><font color=red size=-1>${erMsg1}</font></td>
            </tr>
        </table>
    </form>
</c:if>
</body>
</html>