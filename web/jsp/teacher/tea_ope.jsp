<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="vo.Student"%>
<html>
<body>
<table width="100%" height="100%" border="1">
    <tr>
        <td height="10%" width="10%" align="center"><a href="/servlet/Tea_QueryCourse1Servlet" target="iframe1" style=text-decoration:none>�鿴�γ�</a></td>
        <td rowspan="8"><iframe width="100%" height="100%" name="iframe1" frameborder="0" src="/jsp/right.jsp"></iframe></td>
    </tr>
    <tr height="10%"><td width="10%" align="center"><a href="/servlet/Tea_EnterScore1Servlet" target="iframe1" style=text-decoration:none>¼��ɼ�</a></td></tr>
    <tr height="10%"><td width="10%" align="center"><a href="/servlet/Tea_QueryScore1Servlet" target="iframe1" style=text-decoration:none>�ɼ��ֲ�</a></td></tr>
    <tr height="10%"><td width="10%" align="center"><a href="/jsp/modifyPwd.jsp" target="iframe1" style=text-decoration:none>�޸�����</a></td></tr>
    <tr height="10%"><td width="10%" align="center"><a href="/servlet/LogoutServlet" style=text-decoration:none>�� ��</a></td></tr>
</table>
</body>
</html>