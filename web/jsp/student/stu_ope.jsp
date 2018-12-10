<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="vo.Student"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.File" %>
<html>
<%
    //不保存缓存
    response.setHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);

    PrintWriter pw = response.getWriter();
    String avatarDir1 = "/avatars/";
    Student student = (Student) request.getSession().getAttribute("student");
    String avatarDir2 = student.getStuno();
    //String avatarDir2 = request.getSession().getAttribute("student.stuno").toString();
    String avatarDir = avatarDir1+avatarDir2;

    String realPath = request.getSession().getServletContext().getRealPath(avatarDir);

    File file = new File(realPath);

    if(!file.exists()){
        pw.print("您没有头像，请上传");
    }else{
        pw.print("<div><img src=\""+avatarDir+"\" alt=\"我的头像\" height=\"200px\" width=\"200px\"></div>");
    }
%>
<body bgcolor="#cdf2e3">
<div>
    <form method="post" action="${pageContext.request.contextPath}/servlet/UploadServlet" enctype="multipart/form-data">
        选择一个文件:
        <input type="file" name="uploadFile" />
        <br>
        <input type="submit" value="上传" />
    </form>
</div>
<table width="100%" height="100%" border="1">
    <tr height="10%"><td colspan="2"><p><img src="/res/images/img01.jpg"></p></td></tr>
    <tr>
        <td height="10%" width="10%" align="center"><a href="/servlet/Stu_SelectCourseServlet" target="iframe1" style=text-decoration:none>网上选课</a></td>
        <td rowspan="8"><iframe width="100%" height="100%" name="iframe1" frameborder="0" src="/jsp/right.jsp"></iframe></td>
    </tr>
    <tr height="10%"><td width="10%" align="center"><a href="/servlet/Stu_QueryCourseServlet" target="iframe1" style=text-decoration:none>选课结果</a></td></tr>
    <tr height="10%"><td width="10%" align="center"><a href="/servlet/Stu_QueryScoreServlet" target="iframe1" style=text-decoration:none>学生成绩</a></td></tr>
    <tr height="10%"><td width="10%" align="center"><a href="/jsp/modifyPwd.jsp" target="iframe1" style=text-decoration:none>修改密码</a></td></tr>
    <tr height="10%"><td width="10%" align="center"><a href="/servlet/LogoutServlet" style=text-decoration:none>退 出</a></td></tr>
    <tr height="10%"><td>&nbsp;</td></tr>
    <tr height="5%"><td colspan="2">
        <pre style="display:inline"><font color="#556B2F">    ${type }：[${student.stuno}] ${student.stuname }                                                                                                                     COPYRIGHT 2000-2010 BY  流殇  ALL RIGHTS RESERVED</font></pre>
    </td></tr>
</table>

</body>
</html>