
<style>
    .setting-left {
        width: 220px;
        background-color: #f8fafc;
        float: left;
        text-align: center;
        padding:30px 0px;
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
    .user-menu-nav span{
        float: right;
        display: inline-block;
        height: 50px;
        line-height: 50px;
    }
</style>

<div class="setting-left">
    <img id="userNavHeader" class="setting-header" src=''>
    <div class="split-line" style="margin-bottom: 20px;"></div>
    <ul class="user-menu-nav-block">
        <a href="" style="text-decoration: none">
            <li class="user-menu-nav-cur">个人中心 <span class="layui-icon">&#xe68e;</span></li>
        </a>
        <a href="" style="text-decoration: none">
            <li class="user-menu-nav">我的课程 <span class="layui-icon">&#xe705;</span></li>
        </a>
        <a href="" style="text-decoration: none">
            <li class="user-menu-nav">已创课程 <span class="layui-icon">&#xe705;</span></li>
        </a>
        <a href="" style="text-decoration: none">
            <li class="user-menu-nav">我的收藏  <span class="layui-icon">&#xe600;</span></li>
        </a>
        <a href="" style="text-decoration: none">
            <li class="user-menu-nav">我的关注  <span class="layui-icon">&#xe770;</span></li>
        </a>
        <a href="">
            <li class="user-menu-nav">我的问答 <span class="layui-icon">&#xe63a;</span></li>
        </a>
        <a href="/user/setting">
            <li class="user-menu-nav">个人设置 <span class="layui-icon">&#xe620;</span></li>
        </a>
    </ul>
</div>

    <script type="text/javascript">
        $(function(){
            $('.user-menu-nav').hover(function(){
                $(this).find('span').css('color','#fff');
            },function(){
                $(this).find('span').css('color','#777');
            });

            var headPhoto = $('#userNavHeader').attr('src');
            if(headPhoto == null || headPhoto == '' || headPhoto == 'null'){
                var headPhoto = "/static/images/user/default-avatar.png";
                $('#userNavHeader').attr('src',headPhoto);
            }
        });
    </script>