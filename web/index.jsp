<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>
<body >
<script type="text/javascript">
    function getCode(){
        document.form1.codeimg.src="/res/code/code.jsp?t=" + Math.random();
    }
</script>

<table width="100%" height="80%">
    <tr>
        <td width="36%" height="40%">
            <form method="post" action="/servlet/LoginServlet" name="form1">
                <table width="280" align="center">
                    <tr>
                        <td><div align="right"><font size="-1" color="#556B2F">���:</font></div></td>
                        <td><select name="type" style="width:auto">
                            <option value="student" selected>ѧ��</option>
                            <option value="teacher">��ʦ</option>
                            <option value="admin">����Ա</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td><div align="right"><font size="-1" color="#556B2F">�˺�:</font></div></td>
                        <td><input type="text" name="account"></td>
                    </tr>
                    <tr>
                        <td><div align="right"><font size="-1" color="#556B2F">����:</font></div></td>
                        <td><input type="password" name="password" size=21></td>
                    </tr>
                    <tr><td><div align="right"><font size="-1" color="#556B2F">��֤��:</font></div></td>
                        <td><input name="code" size=12> <a href="#" onclick="getCode()"><font size="-1">�����壬��һ��</font></a></td>
                    </tr>
                    <tr><td colspan="2"><div align="center">
                        <img name="codeimg" src="/res/code/code.jsp"></div></td>
                    </tr>
                    <tr>
                        <td colspan="2"><div align="center">
                            <input type="submit" name="submit" value="��¼">
                            <input type="reset" name="reset" value="����">
                            <input type="checkbox" name="autoLogin" value="autoLogin">�������Զ���¼
                        </div></td>
                    </tr>
                    <tr>
                        <td colspan="2"><div align="center"><font size="-1" color="red"><b>${msg1}</b></font></div></td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>
</body>
</html>