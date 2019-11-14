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
        <#list treeList as tree>
                <div class="list-box">
                    <dl>
                            <dt off="true" class="active">${tree.name!}</dt>
                        <#list tree.sub as item>
                        <dd style="display: none"><a href="javascript:;">${item.name!}</a></dd>
                        </#list>
                    </dl>
                </div>
        </#list>
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
                        <span>${courseList?size} &nbsp门课程</span>
                    </div>
                    <div class="cont-list layui-clear" id="list-cont">
<#list courseList as item>
                        <div class="item">
                            <div class="img">
                                <a href="javascript:;">
                                    <img style="width: 280px;px; height:170px;"
                                         src="${item.picture!}">
                                </a>
                            </div>
                            <div class="text">
                                <p class="title">${item.name!}</p>
                                <p class="price">
                                    <#if item.free=0>
                                    <span   class="pri" style="font-size: 16px;color: red">￥${item.price!}/块钱</span>
                                    <#else >
                                    <span  class="pri" style="font-size: 16px;color: red">免费</span>
                                    </#if>

                                    <span class="nub">
                                        课时${item.time!}分钟 &nbsp
                                        <i class="layui-icon" style="font-size: 12px">&#xe770;</i>
                                        ${item.studyCount}人在学
                                    </span>

                                </p>
                            </div>
                        </div>
</#list>

                    </div>
                    <!-- 模版引擎导入 -->
                   <#-- <script type="text/html" id="demo0">
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
                    </script>-->
                    <div id="demo0" style="text-align: center;"></div>
                </div>
            </div>
        </div>
    </div>
</div>

<#include "common/footer.ftl">

<script>

   $(function () {
        $("#course").addClass("active");
       $('dt').attr('off');
    })

    layui.config({
        base: '/static/js/website/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['mm','laypage','jquery'],function(){
        var laypage = layui.laypage,$ = layui.$,
            mm = layui.mm;
        laypage.render({
            elem: 'demo0'
            ,url:'website/course/list'
            ,count: 100 //数据总数
            ,jump: function(obj, first){
                //obj包含了当前分页的所有参数，比如：
                debugger;
                console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                console.log(obj.limit); //得到每页显示的条数

                //首次不执行
                if(!first){

                }
            }
        });


        // 模版引擎导入
      /* var html = demo0.innerHTML;
        var listCont = document.getElementById('list-cont');
        // console.log(layui.router("#/about.html"))
        mm.request({
            url: '/website/course/list',
            success : function(res){
                debugger
                console.log(res)
                listCont.innerHTML = mm.renderHtml(html,res)
            },
            error: function(res){
                debugger;
                console.log(res);
            }
        })*/

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