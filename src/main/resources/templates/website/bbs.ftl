<!DOCTYPE html>
<html>

<#include "common/head.ftl">

<style>
    /** 动态 */
    .banner.news{background: url(/static/images/website/banner2.jpg) no-repeat center top; background-size: cover;}
    .banner .title{padding-top: 170px;}
    .banner .title.active{padding-top: 120px; transition: 1.5s;}
    .banner .title p{color: #606060; font-size: 36px; text-align: center; line-height: 50px; letter-spacing: 5px;}
    .banner .title p.en{font-size: 20px; letter-spacing: 3px;}
    .main-news{padding: 70px 0 80px 0;}
    .main-news .content > div{padding-bottom: 40px; border-bottom: 1px dashed #eaeaea; position: relative;}
    .main-news .content .news-img{display: inline-block; width: 30%; vertical-align: top;}
    .main-news .content .news-img img{max-width: 90%;}
    .main-news .content .news-panel{display: inline-block; width: 70%; vertical-align: top; padding-left: 5px; box-sizing: border-box;}
    .main-news .content .news-panel strong a{display: block; color: #555; font-size: 18px; line-height: 26px; overflow: hidden; text-overflow:ellipsis; white-space: nowrap;}
    .main-news .content .news-panel p.detail{color: #777; line-height: 24px;}
    .main-news .content .news-panel p.read-push{color: #AAA; padding-top: 5px;}
    .main-news #newsPage .layui-laypage{display: block; text-align: center; margin-top: 70px;}
    .main-news #newsPage .layui-laypage a,.main-news #newsPage .layui-laypage span{font-size: 18px; line-height: 40px; height: 40px; margin-right: 20px; border-radius: 3px; color: #e3e3e3;}
    /*动态详情页*/
    .main-newsdate{margin-top: 80px; text-align: center;}
    .main-newsdate .news{text-align: left; line-height: 104px;}
    .main-newsdate h1{padding-top: 6px;}
    .main-newsdate .pushtime{color: #686868; font-size: 18px; line-height: 82px;}
    .main-newsdate .introTop{padding-bottom: 28px; font-size: 18px; line-height: 20px; text-align: left;}
    .main-newsdate .introBott{font-size: 18px; line-height: 42px; text-align: justify; padding: 40px 0 102px 0;}
    .main-newsdate img{max-width: 100%;}
</style>

<body>

<#include "common/header.ftl">

<div class="content content-nav-base buytoday-content">


<div class="content">

     <#include "common/main-nav.ftl">

    <div class="content content-nav-base buytoday-content">
        <div id="list-cont">


            <!-- banner部分 -->
            <div class="banner news">
                <div class="title">
                    <p>BBS论坛文章</p>
                    <p class="en">Real-time News</p>
                </div>
            </div>

            <!-- main -->
            <div class="main-news">
                <div class="layui-container">
                    <div class="layui-row layui-col-space20">

                        <div class="layui-col-lg6 content">
                            <div>
                                <div class="news-img">
                                    <a href="newsDetail.html">
                                        <img style="width: 184px;height: 142px" src="/static/images/website/banner.jpg">
                                    </a>
                                </div><div class="news-panel">
                                <strong><a href="newsDetail.html">写经验交流材料的技巧全在这了！</a></strong>
                                <p class="detail">
                                    <span style="display: -webkit-box;
-webkit-box-orient: vertical;
-webkit-line-clamp: 3;
overflow: hidden;">看不到您的原稿，这样对空发议论，估计对您的指导性是不大的估计对您的指导性是不大的估计对您的指导性是不大的估计对您的指导性是不大的估计对您的指导性是不大的估计对您的指导性是不大的估计对您的指导性是不大的估计对您的指导性是不大的估计对您的指导性是不大的。建议您将原稿贴出来，好让老师们针对指导。这里简单给出意见：
                                    </span><a href="newsDetail.html">[详细]</a></p>
                                <p class="read-push">阅读 <span>835</span>&nbsp;&nbsp;&nbsp;&nbsp;发布时间：<span>2018-06-21</span></p>
                            </div>
                            </div>
                        </div>
                        <#--<style>
                            span{
                                display: block;
                                width: 120px;
                                overflow: hidden;
                                white-space: nowrap;
                                text-overflow: ellipsis;
                            }
                        </style>-->

                        <div class="layui-col-lg6 content">
                            <div>
                                <div class="news-img">
                                    <a href="newsDetail.html">
                                        <img style="width: 184px;height: 142px" src="http://szimg.mukewang.com/58f57d200001461105400300-360-202.jpg">
                                    </a>
                                </div><div class="news-panel">
                                <strong><a href="newsDetail.html">java从入门到精通！</a></strong>
                                <p class="detail"><span>本教程为Java入门第一季，欢迎来到精彩的Java编程世界！Java语言已经成为当前软件开发行业中主流的开发语言。本教程将介绍Java环境搭建、工具使用、基础语法。带领大家一步一步的踏入Java达人殿堂！Let’s go!</span><a href="newsDetail.html">[详细]</a></p>
                                <p class="read-push">阅读 <span>835</span>&nbsp;&nbsp;&nbsp;&nbsp;发布时间：<span>2018-06-21</span></p>
                            </div>
                            </div>
                        </div>
                        <div id="demo0" style="text-align: center;"></div>
                    </div>
                </div>
            </div>


        </div>
    </div>



<#include "common/footer.ftl">

    <script type="text/javascript">
        $(function () {
            $("#bbs").addClass("active");
        })

        layui.config({
            base: '/static/js/website/' //你存放新模块的目录，注意，不是layui的模块目录
        }).use(['mm','laypage','jquery'],function(){
            var laypage = layui.laypage,$ = layui.$;
            mm = layui.mm;
            laypage.render({
                elem: 'demo0'
                ,count: 100 //数据总数
            });


        });
    </script>



</body>
</html>