<%--
  Created by IntelliJ IDEA.
  User: glb
  Date: 2019/6/14
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>${systemName}</title>
    <style type="text/css">
        body{
            background-color: #2469ac;
            font-size: 12px;
            margin:0;
        }
        table {
            font-size: 12px;
        }
        #container {
            width: 100%;
            height: 250px;
            background-image: url("${pageContext.servletContext.contextPath}/images/login_back.jpg");
            overflow: hidden;
            position: absolute;
            left: 0px;
            top: 160px;
        }
        .leftlogo {
            position: absolute;
            top:0px;
            left:0px;
            width: 571px;
            height: 250px;
            background-image: url("${pageContext.servletContext.contextPath}/images/login_logo.png");
        }
        .loginFormDiv {
            position:absolute;
            top:0;
            left:690px;
            width: 498px;
            height:250px;
            z-index:10;
            padding:0;
        }
        .loginTable {
            font-weight:bold;
        }
        .txt {
            border: 1px solid #999999;
            width: 100px;
            height: 21px;
            margin-left: 8px;
            font-size: 12px;
        }
        .validateCodeDiv {
            position: absolute;
            width: 160px;
            height: 80px;
            background-color:#f5f5f5;
            border: 1px solid black;
            z-index:15;
        }
    </style>
    <script type="text/javascript" src="js/jquery.js"> </script>
    <script type="text/javascript" src="js/user_login.js"></script>
    <script type="text/javascript" src="js/commons.js"></script>
</head>
<body>
<div id="container">
    <div class="leftlogo"></div>
    <div class="loginFormDiv">
        <form name="frm1" onsubmit="return false;">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="loginTable">
                <tr>
                    <td height="92" colspan="3" align="center" valign="middle">
                        <span style="color:red;font-weight:bold;" id="messBox"></span>
                    </td>
                </tr>
                <tr>
                    <td width="80" height="28" align="right" valign="middle">用户ID：</td>
                    <td width="120" align="left" valign="middle"><input type="text" name="account" class="txt" /></td>
                    <td rowspan="3" align="left" valign="middle">
                        <img src="images/login_submitBtn1.gif" id="submitBtn" style="cursor:pointer"/>
                    </td>
                </tr>
                <tr>
                    <td height="28" align="right" valign="middle">密码：</td>
                    <td align="left" valign="middle"><input type="password" name="passwd" class="txt" /></td>
                </tr>
                <tr>
                    <td height="28" align="right" valign="middle">验证码：</td>
                    <td align="left" valign="middle">
                        <input iscode="true" type="text" name="vcode" class="txt" maxLength="4" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<div class="validateCodeDiv"  style="cursor:pointer;display: none" onclick="changeCode();">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td height="60">
                <img src="servlet/getValidateCode" id="imgVcode" iscode="true"/>
            </td>
        </tr>
        <tr>
            <td iscode="true" align="center" valign="middle" height="20" style="color:blue">若看不清，点图片换一张</td>
        </tr>
    </table>
</div>
</body>
</html>
