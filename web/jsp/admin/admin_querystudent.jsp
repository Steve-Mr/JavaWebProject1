<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<center><font size="+1" color="red">${erMsg1}</font></center>	<br><br>

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
    <td>    ${requestScope.selectedstudent.stuno}</td>
    <td>    ${requestScope.selectedstudent.password}</td>
    <td>    ${requestScope.selectedstudent.stuname}</td>
    <td>    ${requestScope.selectedstudent.stusex}</td>

</table>
<h3 align="center">

<tr height="10%"><td width="10%" align="center"><td><a><button onclick="location.href='/servlet/Admin_ModifyStudentServlet?numOfStu=${requestScope.selectedstudent.stuno}'">�޸�</button></a></td></tr>

<tr height="10%"><td width="10%" align="center"><td><a><button onclick="location.href='/servlet/Admin_deleteStudentServlet?numOfStu=${requestScope.selectedstudent.stuno}'">ɾ��</button></a></td></tr>
</h3>

</body>
</html>
