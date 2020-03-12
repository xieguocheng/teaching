
<!-- header头部分 -->
<ul class="layui-nav layui-bg-green" align="right">
    <li class="layui-nav-item layui-layout-left" >
        <a href="/website/index"><span class="layui-icon">&#xe68e;</span>首页</a>
    </li>
<li class="layui-nav-item ">
        <#if Session["name"]??>
            <a href="/user/home"><img src="/static/images/user/default-avatar.png" class="layui-nav-img">我的</a>
            <dl class="layui-nav-child">
                <dd><a href="/user/home">个人中心</a></dd>
                <dd><a href="/user/setting">安全管理</a></dd>
                <dd><a href="/logout">退出</a></dd>
            </dl>
        <#else >
        <li class="layui-nav-item"><a href="/website/login">登录</a></li>
        <li class="layui-nav-item"><a href="/website/register">注册</a></li>
        </#if>
    </li>
    <li class="layui-nav-item " >
        <a href="/website/shopcart">我的购物车<span class="layui-icon">&#xe657;</span></a>
    </li>
</ul>


  <script type="text/javascript">

      layui.use('element', function(){
          var element = layui.element;
      });
  </script>