

<ul class="layui-nav layui-bg-green" align="right">

    <li class="layui-nav-item layui-layout-left" >
        <a href="/website/index"><span class="layui-icon">&#xe68e;</span>首页</a>
    </li>

    <li class="layui-nav-item ">
        <a href=""><img src="/static/images/user/default-avatar.png" class="layui-nav-img">我的</a>
        <dl class="layui-nav-child">
            <dd><a href="/user/setting">个人设置</a></dd>
            <dd><a href="javascript:;">安全管理</a></dd>
            <dd><a href="/logout">退了</a></dd>
        </dl>
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