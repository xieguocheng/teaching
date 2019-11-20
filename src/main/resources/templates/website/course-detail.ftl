<!DOCTYPE html>
<html>

<#include "common/head.ftl">

<body>

<div class="site-nav-bg">
    <div class="site-nav w1200">
        <p class="sn-back-home">
            <i class="layui-icon layui-icon-home"></i>
            <a href="/website/index">首页</a>
        </p>
        <div class="sn-quick-menu">
 <#if Session["name"]??>

            <div class="login"><a href="/user/home"><i class="layui-icon layui-icon-username"></i>我的</a></div>
 <#else >
            <div class="login"><a href="/website/login">登录</a></div>
            <div style="margin-right: 10px">/</div>
            <div class="login"><a href="/website/register">注册</a></div>
 </#if>
            <div class="sp-cart"><a href="/website/shopcart"><i class="layui-icon layui-icon-cart"></i>购物车</a><span>2</span></div>
        </div>
    </div>
</div>



    <div class="layui-row">
        <div class="layui-col-md4" style="background-color: #00b7ee">

                <video width="100%" height="100%" controls style="align:center">
                    <source src="http://learn.wushirui.cn/20191014_173145.mp4" type="video/mp4">
                </video>

        </div>
        <div class="layui-col-md4 layui-col-md-offset4" class="layui-bg-red">
            偏移4列，从而在最右
        </div>
    </div>



</body>
</html>