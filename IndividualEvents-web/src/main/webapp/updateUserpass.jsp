<!doctype html>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="assets/css/amazeui.min.css"/>
<link rel="stylesheet" href="assets/css/admin.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/app.js"></script>
</head>
</head>

<body style="font-family: 微软雅黑">
<header class="am-topbar admin-header">
  <div class="am-topbar-brand"><a href="main.jsp"><img src="assets/i/logo.png"></a></div>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
    <ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">

   <li class="am-dropdown tognzhi" data-am-dropdown>
  <button class="am-btn am-btn-primary am-dropdown-toggle am-btn-xs am-radius am-icon-bell-o" data-am-dropdown-toggle> 消息管理<span class="am-badge am-badge-danger am-round">6</span></button>
  <ul class="am-dropdown-content">
  	
    <li class="am-dropdown-header">所有消息都在这里</li>

    <li><a href="#">未激活会员 <span class="am-badge am-badge-danger am-round">556</span></a></li>
    <li><a href="#">未激活代理 <span class="am-badge am-badge-danger am-round">69</span></a></li>
    <li><a href="#">未处理汇款</a></li>
    <li><a href="#">未发放提现</a></li>
    <li><a href="#">未发货订单</a></li>
    <li><a href="#">低库存产品</a></li>
    <li><a href="#">信息反馈</a></li>

  </ul>
</li>

        <li class="kuanjie">
            <a href="#">会员管理</a>
            <a href="#">订单管理</a>
            <a href="#">产品管理</a>
            <a href="#">系统设置</a>
        </li>

 <li class="soso">
<p>
	<select data-am-selected="{btnWidth: 70, btnSize: 'sm', btnStyle: 'default'}">
          <option value="b">全部</option>
          <option value="o">产品</option>
          <option value="o">会员</option>
    </select>
</p>
<p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="搜索" /></p>
<p><button class="am-btn am-btn-xs am-btn-default am-xiao"><i class="am-icon-search"></i></button></p>
 </li>

      <li class="am-hide-sm-only" style="float: right;"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>
<div class="am-cf admin-main">
<div class="nav-navicon admin-main admin-sidebar">
    <div class="sideMenu am-icon-dashboard" style="color:#000000; margin: 10px 0 0 0; font-size: 18px">欢迎：<a href="#">${LoginUser.iname}</a>
    </div>
    <div class="sideMenu">
        <h3 class="am-icon-flag"><a href="#">商品管理</a></h3>
        <ul>
            <li><a href="productAction_findproductList">商品列表</a></li>
            <li><a href="productAction_toAddProduct">添加新商品</a></li>
            <li><a href="typeAction_findTbType">商品风类</a></li>
        </ul>


        <h3 class="am-icon-users"><em></em> <a href="#">个人中心</a></h3>
        <ul>
            <li><a href="userAction_findUserInfoList?userInfo.ino=${LoginUser.ino}">查看个人信息</a> </li>
            <li><a href="userAction_toupdateinfo?userInfo.ino=${LoginUser.ino}">编辑个人信息</a> </li>
            <li><a href="userAction_toUpdatePassword?userInfo.ino=${LoginUser.ino}">修改密码</a></li>
            <li><a href="index.html">销注登录</a></li>
        </ul>

    </div>
    <!-- sideMenu End --> 
    
    <script type="text/javascript">
			jQuery(".sideMenu").slide({
				titCell:"h3", //鼠标触发对象
				targetCell:"ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
				effect:"slideDown", //targetCell下拉效果
				delayTime:300 , //效果时间
				triggerTime:150, //鼠标延迟触发时间（默认150）
				defaultPlay:true,//默认是否执行效果（默认true）
				returnDefault:true //鼠标从.sideMen移走后返回默认状态（默认false）
				});
		</script> 

</div>

<div class=" admin-content">
		<div class="daohang"></div>
</div>
</div>






<div class="admin-biaogelist">
    <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on">
            编辑个人详细信息
        </ul>

    </div>
    <div class="am-form am-g">
        <div class="tpl-login">
            <div class="tpl-login-content"  style="width: 400px">

                <s:if test="#parameters.msg[0]==1">
                    <p style="color:green">修改成功！</p>
                </s:if>
                <s:elseif test="#parameters.msg[0]==-1">
                    <p style="color:red">修改失败！</p>
                </s:elseif>

                <s:form class="am-form tpl-form-line-form" method="post" action="userAction_UpdatePassword">

                    <s:hidden name="userInfo.ino"/>
                    <s:hidden name="userInfo.iimg"/>
                    <s:hidden name="userInfo.ibirthday"/>
                    <s:hidden name="userInfo.iemail"/>
                    <s:hidden name="userInfo.itab"/>

                    <div class="am-form-group">
                        用户名：<s:textfield class="tpl-form-input" name="userInfo.iname"/>
                    </div>
                    <div class="am-form-group">
                        密码：<s:textfield class="tpl-form-input" name="userInfo.ipwd"/>
                    </div>


                    <div class="am-form-group">
                        <input type="submit" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn" value="确认修改"/>
                    </div>
                </s:form>



            </div>
        </div>
    </div>
</div>









<!--[if (gte IE 9)|!(IE)]><!--> 
<script src="assets/js/amazeui.min.js"></script>
<!--<![endif]-->

</body>

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

</html>