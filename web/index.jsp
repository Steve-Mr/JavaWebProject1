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
                        <td><div align="right"><font size="-1" color="#556B2F">身份:</font></div></td>
                        <td><select name="type" style="width:auto">
                            <option value="student" selected>学生</option>
                            <option value="teacher">教师</option>
                            <option value="admin">管理员</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td><div align="right"><font size="-1" color="#556B2F">账号:</font></div></td>
                        <td><input type="text" name="account"></td>
                    </tr>
                    <tr>
                        <td><div align="right"><font size="-1" color="#556B2F">密码:</font></div></td>
                        <td><input type="password" name="password" size=21></td>
                    </tr>
                    <tr><td><div align="right"><font size="-1" color="#556B2F">验证码:</font></div></td>
                        <td><input name="code" size=12> <a href="#" onclick="getCode()"><font size="-1">看不清，换一张</font></a></td>
                    </tr>
                    <tr><td colspan="2"><div align="center">
                        <img name="codeimg" src="/res/code/code.jsp"></div></td>
                    </tr>
                    <tr>
                        <td colspan="2"><div align="center">
                            <input type="submit" name="submit" value="登录">
                            <input type="reset" name="reset" value="重置">
                            <input type="checkbox" name="autoLogin" value="autoLogin">两周内自动登录
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