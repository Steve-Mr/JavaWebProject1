<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="vo.Student"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.File" %>
<html>
<body bgcolor="#cdf2e3">
<table width="100%" height="100%" border="1">
    <tr height="10%"><td colspan="2"><p><img src="/res/images/img01.jpg"></p></td></tr>
    <tr>
        <td height="10%" width="10%" align="center"><a href="/servlet/Stu_SelectCourseServlet" target="iframe1" style=text-decoration:none>����ѡ��</a></td>
        <td rowspan="8"><iframe width="100%" height="100%" name="iframe1" frameborder="0" src="/jsp/right.jsp"></iframe></td>
    </tr>
    <tr height="10%"><td width="10%" align="center"><a href="/servlet/Stu_QueryCourseServlet" target="iframe1" style=text-decoration:none>ѡ�ν��</a></td></tr>
    <tr height="10%"><td width="10%" align="center"><a href="/servlet/Stu_QueryScoreServlet" target="iframe1" style=text-decoration:none>ѧ���ɼ�</a></td></tr>
    <tr height="10%"><td width="10%" align="center"><a href="/jsp/modifyPwd.jsp" target="iframe1" style=text-decoration:none>�޸�����</a></td></tr>
    <tr height="10%"><td width="10%" align="center"><a href="/servlet/LogoutServlet" style=text-decoration:none>�� ��</a></td></tr>
    <tr height="10%"><td>&nbsp;</td></tr>
    <tr height="5%"><td colspan="2">
        <pre style="display:inline"><font color="#556B2F">    ${type }��[${student.stuno}] ${student.stuname }                                                                                                                     COPYRIGHT 2000-2010 BY  ����  ALL RIGHTS RESERVED</font></pre>
    </td></tr>
</table>
</body>
</html>