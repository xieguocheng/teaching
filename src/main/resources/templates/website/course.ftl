<!DOCTYPE html>
<html>

<#include "common/head.ftl">

<body>

<#include "common/header.ftl">

<div class="content content-nav-base commodity-content" >

<#include "common/main-nav.ftl">

    <div class="commod-cont-wrap">
        <div class="commod-cont w1200 layui-clear">
            <div class="left-nav">
                <div class="title">课程分类</div>
                <div class="list-box">
                    <dl>
                        <dt>后端开发</dt>
                        <dd><a href="javascript:;">Java</a></dd>
                        <dd><a href="javascript:;">PHP</a></dd>
                        <dd><a href="javascript:;">C++</a></dd>
                    </dl>
                    <dl>
                        <dt>前端开发</dt>
                        <dd><a href="javascript:;">HTML</a></dd>
                        <dd><a href="javascript:;">Javascript</a></dd>
                        <dd><a href="javascript:;">jquery</a></dd>
                        <dd><a href="javascript:;">boostrapt</a></dd>
                    </dl>
                </div>
            </div>

            <div class="right-cont-wrap">
                <div class="right-cont">
                    <div class="sort layui-clear">
                        <a class="active" href="javascript:;" event = 'volume'>流量</a>
                        <a href="javascript:;" event = 'price'>价格</a>
                        <a href="javascript:;" event = 'newprod'>新品</a>
                        <a href="javascript:;" event = 'collection'>收藏</a>
                    </div>
                    <div class="prod-number">
                        <span>200个</span>
                    </div>
                    <div class="cont-list layui-clear" id="list-cont">

                        <div class="item">
                            <div class="img">
                                <a href="javascript:;">
                                    <img style="width: 280px;px; height:170px;" src="http://szimg.mukewang.com/58f57d200001461105400300-360-202.jpg">
                                </a>
                            </div>
                            <div class="text">
                                <p class="title">森系小清新四件套</p>
                                <p class="price">
                                    <span class="pri">￥200</span>
                                    <span class="nub">1266付款</span>
                                </p>
                            </div>
                        </div>

                        <div class="item">
                            <div class="img">
                                <a href="javascript:;">
                                    <img style="width: 280px;px; height:170px;" src="http://szimg.mukewang.com/58f57d200001461105400300-360-202.jpg">
                                </a>
                            </div>
                            <div class="text">
                                <p class="title">森系小清新四件套</p>
                                <p class="price">
                                    <span class="pri">￥200</span>
                                    <span class="nub">1266付款</span>
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <div class="img">
                                <a href="javascript:;">
                                    <img style="width: 280px;px; height:170px;" src="http://szimg.mukewang.com/58f57d200001461105400300-360-202.jpg">
                                </a>
                            </div>
                            <div class="text">
                                <p class="title">森系小清新四件套</p>
                                <p class="price">
                                    <span class="pri">￥200</span>
                                    <span class="nub">1266付款</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <!-- 模版引擎导入 -->
                    <!-- <script type="text/html" id="demo">
                      {{# layui.each(d.menu.milk.content,function(index,item){}}
                        <div class="item">
                          <div class="img">
                            <a href="javascript:;"><img src="{{item.img}}"></a>
                          </div>
                          <div class="text">
                            <p class="title"></p>
                            <p class="price">
                              <span class="pri">{{item.pri}}</span>
                              <span class="nub">{{item.nub}}</span>
                            </p>
                          </div>
                        </div>
                      {{# }); }}
                    </script> -->
                    <div id="demo0" style="text-align: center;"></div>
                </div>
            </div>
        </div>
    </div>
</div>

<#include "common/footer.ftl">

<script>

   /* $(function () {
        $("#course").addClass("active");
    })*/

    layui.config({
        base: '/static/js/website/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['mm','laypage','jquery'],function(){
        var laypage = layui.laypage,$ = layui.$,
            mm = layui.mm;
        laypage.render({
            elem: 'demo0'
            ,count: 100 //数据总数
        });

        $('.sort a').on('click',function(){
            $(this).addClass('active').siblings().removeClass('active');
        })
        $('.list-box dt').on('click',function(){
            if($(this).attr('off')){
                $(this).removeClass('active').siblings('dd').show()
                $(this).attr('off','')
            }else{
                $(this).addClass('active').siblings('dd').hide()
                $(this).attr('off',true)
            }
        })

    });


</script>
</body>
</html>