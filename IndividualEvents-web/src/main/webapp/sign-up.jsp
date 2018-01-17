<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin index Examples</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="assets/css/app.css">
    <script src="assets/js/jquery.min.js"></script>

</head>

<body data-type="login">
    <script src="assets/js/theme.js"></script>
    <div class="am-g tpl-g" style="width: 400px">
        <div class="tpl-login">
            <div class="tpl-login-content">
                <div class="tpl-login-title">填写详细信息</div>

                <form class="am-form tpl-form-line-form" method="post" action="userAction_AddUserInfo">

                    <img src="" id='show'>
                    <input type="file" id='file'; onchange="c()" name="userInfo.iimg">

                    <div class="am-form-group">
                        <input type="text" class="tpl-form-input" name="userInfo.iname" placeholder="用户名">
                    </div>

                    <div class="am-form-group">
                        <input type="text" class="tpl-form-input" name="userInfo.ipwd" placeholder="密码">
                    </div>

                    <div class="am-form-group">
                        <input type="text" class="tpl-form-input" name="userInfo.ibirthdayd" placeholder="出生年月">
                    </div>


                    <h2><s:radio name="userInfo.isex" list="{'男','女'}" value="%{'男'}"></s:radio></h2><br/>

                    <div class="am-form-group">
                        <input type="text" class="tpl-form-input" name="userInfo.iemail" placeholder="邮箱：zhangsan@qq.com">
                    </div>

                    <div class="am-form-group">
                        <input type="text" class="tpl-form-input" name="userInfo.itab" placeholder="联系电话">
                    </div>

                    <div class="am-form-group tpl-login-remember-me">
                        <input id="remember-me" type="checkbox">
                        <label for="remember-me">
                            我已阅读并同意 <a href="javascript:;">《用户注册协议》</a>
                        </label>
                    </div>

                    <div class="am-form-group">
                        <input type="submit" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn" value="注册"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script src="assets/js/amazeui.min.js"></script>
    <script src="assets/js/app.js"></script>

</body>

</html>
<script type="text/javascript">

    function c () {
        var r= new FileReader();
        f=document.getElementById('file').files[0];
        r.readAsDataURL(f);
        r.onload=function  (e) {
            document.getElementById('show').src=this.result;
        };
    }
</script>