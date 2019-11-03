<!DOCTYPE html>
<html>

<#--<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css">-->

<#include "common/head.ftl">

<style>
    .f-main{
        width: 1200px;
        margin:0 auto;
        min-height: 400px;
        margin-top:20px;
        margin-bottom:100px;
    }
    .setting-left {
        width: 220px;
        background-color: #f8fafc;
        float: left;
        text-align: center;
        padding:30px 0px;
    }
    .user-menu-nav-block{
        text-align:left;
        width: 100%;
        padding:0px;
    }
    .split-line{
        width:100%;
        height: 1px;
        border-bottom: 1px solid #d9dde1;
        margin: 40px 0px;
    }
    .setting-header{
        display: block;
        width: 100px;
        height: 100px;
        margin: 0 auto 10px;
        border-radius: 50%;
        border:3px solid #CCC;
    }
    .user-menu-nav-block{
        text-align:left;
        width: 100%;
        padding:0px;
    }
    .user-menu-nav-cur{
        background-color: #009688;
        color: #FFF;
        height: 50px;
        line-height: 50px;
        padding-left:50px;
        padding-right:30px;
        margin-bottom: 10px;
    }
    .user-menu-nav-cur span{
        float: right;
        display: inline-block;
        height: 50px;
        line-height: 50px;
        color: #FFF;
    }

    .user-menu-nav{
        height: 50px;
        line-height: 50px;
        padding-left:50px;
        padding-right:30px;
        margin-bottom: 10px;
    }
    .user-menu-nav:hover{
        background-color: #009688;
        color: white;
    }
    .user-menu-nav span{
        float: right;
        display: inline-block;
        height: 50px;
        line-height: 50px;
    }
    .setting-right{
        width: 930px;
        float: right;
    }
</style>

<body>
<ul class="layui-nav">
    <li class="layui-nav-item">
        <a href="">个人中心<span class="layui-badge-dot"></span></a>
    </li>
    <li class="layui-nav-item">
        <a href=""><img src="//t.cn/RCzsdCq" class="layui-nav-img">我</a>
        <dl class="layui-nav-child">
            <dd><a href="javascript:;">修改信息</a></dd>
            <dd><a href="javascript:;">安全管理</a></dd>
            <dd><a href="javascript:;">退了</a></dd>
        </dl>
    </li>
</ul>

<ul class="layui-nav layui-bg-green" lay-filter="">
</ul>


<div class="f-main clearfix">

    <div class="setting-left">
        <img id="userNavHeader" class="setting-header" src='/static/images/website/us_img4.png'>
        <div class="split-line" style="margin-bottom: 20px;"></div>
        <ul class="user-menu-nav-block">
            <a href="" style="text-decoration: none">
                <li class="user-menu-nav-cur">主页 <span>&gt;</span></li>
            </a>
            <a href="" style="text-decoration: none">
                <li class="user-menu-nav">主页 <span>&gt;</span></li>
            </a>
            <a href="" style="text-decoration: none">
                <li class="user-menu-nav">主页 <span>&gt;</span></li>
            </a>
            <a href="">
                <li class="user-menu-nav">主页 <span>&gt;</span></li>
            </a>
        </ul>
    </div>


    <div class="setting-right"  >
        <div><span class="f-16">最新动态</span></div>
        <div class="split-line" style="margin: 20px 0px;"></div>


    </div>



</div>


<#include "common/footer.ftl">

    <script type="text/javascript">
       $(function(){
            $('.user-menu-nav').hover(function(){
                $(this).find('span').css('color','#0089D2');
            },function(){
                $(this).find('span').css('color','#777');
            });

            /*var headPhoto = $('#userNavHeader').attr('src');
            if(headPhoto == null || headPhoto == '' || headPhoto == 'null'){
                var headPhoto = "/res/i/header.jpg";
                $('#userNavHeader').attr('src',headPhoto);
            }*/
        });

       layui.use('element', function(){
           var element = layui.element;
       });
    </script>

</body>
</html>