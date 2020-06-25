<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
    Exception exception = (Exception) request.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <script src="${ctx}/js/jquery-1.6.2.min.js"></script>
    <script src="${ctx}/js/jquery.tmpl.js"></script>
</head>
<body>
<h2>登录</h2>
    <form method="post" action="${ctx}/login">
        <table>
            <tr>
                <td>账号：<input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>
                    密码：<input type="text" name="password"/>
                    <input id="remember" name="remember_me" value="true" type="checkbox" />记住我
                </td>
            </tr>
            <tr>
                <td>验证码：<input type="text" name="imagecode"><img src="${ctx}/code/image"></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"/></td>
            </tr>
            <tr>
                <td style="color: red;"><%=exception == null ? "" : exception.getMessage()%></td>
            </tr>
        </table>
    </form>

<h3>短信登录</h3>
<form method="post" action="${ctx}/sms/login">
    <div>
        手机号：<input type="text" id="mobile" name="mobile" value="15724123719">
    </div>
    <div>
        验证码：<input type="text" name="smscode">
        <a href="javascript:;" onclick="sendSms()">获取验证码</a>
    </div>
    <div>
        <button type="submit">立即登陆</button>
    </div>
</form>

<div>QQ登录</div>
<a href="${ctx}/auth/callback.do" >QQ登录</a>
<script type="text/javascript">
    function sendSms() {
        $.get("${ctx}/sms/code",function (){

        });
    }

</script>
————————————————
    ------------------------------------------------------------
    <div id="div_demo">

    </div>

    <script id="demo" type="text/x-jquery-tmpl">
        <div style="margin-bottom:10px;">
        　　<span>${ID} </span>
        　　<span style="margin-left:10px;">{{= Name}}</span>
        　　<span style="margin-left:10px;">${Num+1}</span>
        　　<span style="margin-left:10px;">${Status}</span>
        </div>
    </script>

    <script type="text/javascript">
        var users = [
            { ID: 'think8848', Name: 'Joseph Chan', Num: '1', Status: 1 },
            { ID: 'aCloud', Name: 'Mary Cheung', Num: '2'}
        ];
        $("#demo").tmpl(users).appendTo('#div_demo');

    </script>
</body>
</html>
