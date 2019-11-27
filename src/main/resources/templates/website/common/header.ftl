
<!-- header头部分 -->
<#--<div class="site-nav-bg">
    <div class="site-nav w1200">
        <p class="sn-back-home">
            <a href="/website/index"><i class="layui-icon layui-icon-home"></i>首页</a>
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
</div>-->

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

<div class="header">
    <div class="headerLayout w1200">
        <div class="headerCon">
            <h1 class="mallLogo">
                <a href="/website/index" title="智慧教学视频网站">
                    <img src="/static/images/website/logo.png" style="width: 300px;height: 50px">
                </a>
            </h1>
            <div class="mallSearch">
                <form action="" class="layui-form" novalidate>
                    <input type="text" name="title" required  lay-verify="required" autocomplete="off" class="layui-input"
                           placeholder="请输入想要搜索的课程名称/类型">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">
                        <i class="layui-icon layui-icon-search"></i>
                    </button>
                    <input type="hidden" name="" value="">
                </form>
            </div>
        </div>
    </div>
</div>

  <script type="text/javascript">

      layui.use('element', function(){
          var element = layui.element;
      });
  </script>