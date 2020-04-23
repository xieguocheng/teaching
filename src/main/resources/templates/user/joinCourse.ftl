<!DOCTYPE html>
<html>

<#--<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css">-->

<#include "common/head.ftl">

<style>
    .f-main{
        width: 1200px;
        margin:0 auto;
        min-height: 600px;
        margin-top:20px;
        margin-bottom:100px;
    }
    .split-line{
        width:100%;
        height: 1px;
        border-bottom: 1px solid #d9dde1;
        margin: 40px 0px;
    }
    .setting-right{
        width: 930px;
        float: right;
    }
</style>

<body>

<#include "common/header.ftl">


<div class="f-main clearfix">

<#include "common/nav.ftl">


    <div class="setting-right"  >

       <#-- <div><span class="f-16">最新动态</span></div>
        <div class="split-line" style="margin: 20px 0px;"></div>-->

        <div class="layui-tab">
            <ul class="layui-tab-title">
                <li class="layui-this">所有在学课程</li>
                <li>免费课程</li>
                <li>实战课程</li>

            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">

                    <form id="queryPageForm" action="">


                    <#list page.list as item>
				<div class="comment clearfix">
                    <div class="comment-main" style="width: 100%">
                        <a href="/course/learn/${item.id!}.html" target="_blank" class="user-name link-a" style="font-size:20px;">${item.courseName!}</a>
                        <div class="comment-content">
                            <span class="learn-rate">已学${item.id!0}%</span>
                            <span>
							<a href="/course/video/${item.sectionId!}.html" target="_blank" >
                                ${item.sectionName!}
                            </a>
							</span>
                        </div>
                        <div class="comment-footer">
							<span>时间：
							<#if item.createTime??>
                                ${item.createTime?string('yyyy-MM-dd')}
                            </#if>
							</span>
                            <a href="/course/video/${item.sectionId!}.html" target="_blank" >
                                <span class="continue-btn" style="margin-left: 50px;">继续学习</span>
                            </a>
                        </div>
                    </div>
                </div>
                </#list>


                    </form>

                </div>
                <div class="layui-tab-item">内容2</div>
                <div class="layui-tab-item">内容3</div>

            </div>
        </div>


    </div>



</div>


<#include "common/footer.ftl">

    <script type="text/javascript">
        //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
        layui.use('element', function(){
            var element = layui.element;
        });

    </script>

</body>
</html>