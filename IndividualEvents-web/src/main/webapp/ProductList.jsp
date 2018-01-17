<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
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
            商品详细信息列表
        </ul>

    </div>
    <form class="am-form am-g">
        <div class="tpl-login">
            <div class="tpl-login-content">

                <form class="am-form am-g">
                    <s:if test="#parameters.msg[0]==1">
                        <p style="color:green">操作成功！</p>
                    </s:if>
                    <s:elseif test="#parameters.msg[0]==-1">
                        <p style="color:red">操作失败！</p>
                    </s:elseif>
                    <input type="button" value="上架" onclick="clickSubbmint(1)"  class="am-btn am-btn-default">
                    <input type="button" value="下架" onclick="clickSubbmint(2)" class="am-btn am-btn-default "/>
                    <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
                        <tr>
                            <td><input type="checkbox" id="all"> &nbsp;|&nbsp;排序</td>
                            <td>图片</td>
                            <td>商品名称</td>
                            <td>类型</td>
                            <td>尺码</td>
                            <td>价格</td>
                            <td>是否包邮</td>
                            <td>上架/下架</td>
                            <td>管理</td>
                        </tr>
                        <s:iterator value="#request.productList" var="obj" status="ids">
                            <tr>
                                <td>
                                    <input class="xpg" type="checkbox" value="${obj[0].pno}"/> &nbsp;|&nbsp;
                                    ${ids.count }</td>
                                <td><img src="${pageContext.request.contextPath}/${obj[0].pimg }" width="50" height="50"></td>
                                <td>${obj[0].pname }</td>
                                <td>${obj[1].tname }</td>
                                <td>${obj[0].psize }</td>
                                <td>${obj[0].pprice }</td>
                                <td>${obj[0].ppackage }</td>
                                <td>${obj[0].pstatus==1?"上架":"下架" }</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/productAction_toUpdateProduct?product.pno=${obj[0].pno}">编辑</a>&nbsp;|&nbsp;
                                    <a href="productAction_deleteproduct?product.pno=${obj[0].pno }">删除</a>
                                </td>
                            </tr>
                        </s:iterator>
                    </table>
                </form>
            </div>
        </div>
    </form>
</div>


<!--[if (gte IE 9)|!(IE)]><!-->
<script src="assets/js/amazeui.min.js"></script>
<!--<![endif]-->
<script type="text/javascript">

        $("#all").click(function () {
            if ($(this).prop("checked")) {
                $(":checkbox").prop("checked", true);
            } else {
                $(":checkbox").prop("checked", false);
            }
        });

    function clickSubbmint(pstatus){
        var temp = 0;
        var cked = $(".xpg:not('#all')");
        var param = "?";
        for(var i = 0;i < cked.length; i++){
            if(cked[i]. checked== true){
                temp += 1;
                param += "pno=" + cked[i].value + "&";
            }
        }
        param = param.substring(0,param.length-1);
        if(temp == 0){
            alert("请选择操作的商品");
            return;
        }
        param+="&pstatus="+pstatus;
        console.log(param)
        $.post("productAction_headelProduct"+param,"",function(data){
            window.location.href = "productAction_findproductList";
        });
    }

</script>

</body>
</html>