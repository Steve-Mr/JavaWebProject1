<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body bgcolor=#cdf2e3>
<center><font size="+1" color="red">${okayMsg1}</font></center>	<br><br>
<c:if test="${okayMsg1==null}">
    <form action="/servlet/Admin_AddStudentServlet" method="post">
        <table align=center>
            <tr>
                <td align=right>����ѧ��ѧ�ţ�</td>
                <td align=left><input type="text" name="stuno"></td>
            </tr>
            <tr>
                <td align=right>����ѧ����ʼ���룺</td>
                <td align=left><input type="password" name="stupwd"></td>
            </tr>
            <tr>
                <td align=right>����ѧ��������</td>
                <td align=left><input type="text" name="stuname"></td>
            </tr>
            <tr>
                <td align=right>����ѧ���Ա�</td>
                <td align=left><input type="text" name="stusex"></td>
            </tr>
            <tr>
                <td align=right><input type="submit" value="�ύ"></td>
                <td align=left><input type="reset" value="����"></td>
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