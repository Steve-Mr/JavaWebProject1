<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body bgcolor=#cdf2e3>
<center><font size="+1" color="red">${okayMsg1}</font></center>	<br><br>
<form action="/servlet/Admin_ModifyStudentServlet" method="post">
<table width="1000" height="200" align="center" border="1" cellpadding="3">
    <tr bgcolor="#B0E0E6">
        <td colspan="5"><font color="#556B2F"> ѧ����Ϣ���£�</font></td>
    </tr>
    <tr bgcolor="yellow">
        <td>ѧ��</td>
        <td>����</td>
        <td>����</td>
        <td>�Ա�</td>
    </tr>
    <td><div align="center"><input type="text" name="stuno" value="${requestScope.selectedstudent.stuno}"></div></td>
    <td><div align="center"><input type="text" name="stupwd" value="${requestScope.selectedstudent.password}"></div></td>
    <td><div align="center"><input type="text" name="stuname" value="${requestScope.selectedstudent.stuname}"></div></td>
    <td><div align="center"><input type="text" name="stusex" value="${requestScope.selectedstudent.stusex}"></div></td>

</table>
<td><div><input type="submit" name="submit" value="ȷ���޸�"></div></td>
    <tr>
        <td colspan=2 align=center><font color=red size=-1>${erMsg1}</font></td>
    </tr>
</form>
</body>
</html>
