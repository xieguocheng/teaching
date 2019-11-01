<!DOCTYPE html>
<html>

<#include "common/head.ftl">
<style>
    /** 关于 */
    .banner.about{background: url(/static/images/website/banner2.jpg) no-repeat center top; background-size: cover;}
    .main-about{padding-bottom: 130px;}
    .main-about ul.aboutab{padding: 100px 0; text-align: center;}
    .main-about ul.aboutab li{display: inline-block; padding: 0 22px; margin-left: 15px; font-size: 20px; line-height: 46px; color: #b5b5b5; border: 1px solid #e2e2e2; border-radius: 3px; cursor: pointer;}
    .main-about ul.aboutab li:first-child{margin-left: 0;}
    .main-about ul.aboutab li.layui-this
    ,.main-about ul.aboutab li:hover{color: #2ab5a3; border-color: #afddd7; transition: 0.3s;}
    .main-about .tabJob, .main-about .tabCour{display: none;}
    /*公司简介*/
    .main-about .tabIntro{padding-bottom: 15px;}
    .main-about .tabIntro .content{vertical-align: middle;}
    .main-about .tabIntro .content .img{width: 50%;}
    .main-about .tabIntro .content .img img{width: 100%;}
    .main-about .tabIntro .content .panel{width: 50%;}
    .main-about .tabIntro .content p{padding: 0 20px; line-height: 24px; text-align: justify;}
    .main-about .tabIntro .p_hidden{padding: 0 20px; display: none;}
    /*招贤纳士*/
    .main-about .tabJob .content{padding: 0 0 40px 20px; border: 1px solid #e2e2e2; border-top: 4px solid #65d0c5; margin-top: 90px;}
    .main-about .tabJob .content:first-child{margin-top: 10px;}
    .main-about .tabJob .content p{font-size: 18px; line-height: 40px;}
    .main-about .tabJob .content p.title{font-size: 24px; color: #545454; line-height: 60px;}
    .main-about .tabJob .content ol{padding-left: 20px; list-style-type: none; counter-reset: sectioncounter;}
    .main-about .tabJob .content ol li{color: #8d8d8d; font-size: 16px; line-height: 30px;}
    .main-about .tabJob .content ol li:before {content: counter(sectioncounter) "、"; counter-increment: sectioncounter;}
    /*发展历程*/
    .main-about .tabCour p.title{font-size: 28px; line-height: 28px; text-align: center;}
    .main-about .tabCour .timeline{position: relative; margin-top: 75px;}
    .main-about .tabCour .timeline:before{position: absolute; top: 0; bottom: 0; content: ""; width: 2px; background-color: #e2e2e2; left: 50px;}
    .main-about .tabCour .timeline li{position: relative; padding-top: 70px;}
    .main-about .tabCour .timeline li:first-child{padding-top: 0;}
    .main-about .tabCour .timeline li .cour-img{position: absolute; left: 0; width: 100px; border-radius: 50%;}
    .main-about .tabCour .timeline li .cour-img img{width: 100%;}
    .main-about .tabCour .timeline li .cour-panel{padding-top: 20px; padding-left: 120px; text-align: left;}
    .main-about .tabCour .timeline li .cour-panel p.label{font-size: 18px; color: #000;}
    .main-about .tabCour .timeline li .cour-panel p{color: #949494; line-height: 30px;}

    .banner .title{padding-top: 170px;}
    .banner .title.active{padding-top: 120px; transition: 1.5s;}
    .banner .title p{color: #606060; font-size: 36px; text-align: center; line-height: 50px; letter-spacing: 5px;}
    .banner .title p.en{font-size: 20px; letter-spacing: 3px;}
</style>

<body>

<#include "common/header.ftl">


<div class="content content-nav-base buytoday-content">


<div class="content">

    <#include "common/main-nav.ftl">

    <div class="content content-nav-base buytoday-content">
        <div id="list-cont">

            <!-- banner部分 -->
            <div class="banner about">
                <div class="title">
                    <p>关于我们</p>
                    <p class="en">About Us</p>
                </div>
            </div>
            <!-- main部分 -->
            <div class="main-about">
                <div class="layui-container">
                    <div class="layui-row">

                        <ul class="aboutab">
                            <li class="layui-this">网站简介</li><li>招贤纳士</li><li>录屏流程</li>
                        </ul>

                        <div class="tabIntro">

                            <div class="content">
                                <div class="layui-inline img">
                                    <img style="width: 600px;height: 600px" src="http://szimg.mukewang.com/58f57d200001461105400300-360-202.jpg">
                                </div>
                                <div class="layui-inline panel">
                                <p>身处在前端社区的繁荣之下，我们都在有意或无意地追逐。而 layui 偏偏回望当初，奔赴在返璞归真的漫漫征途，
                                    自信并勇敢着，追寻于原生态的书写指令，试图以最简单的方式诠释高效。</p>
                                 </div>
                            </div>

                            <div class="content">
                                <div class="layui-inline panel p_block">
                                    <p>如果眼下还是一团零星之火，那运筹帷幄之后，迎面东风，就是一场烈焰燎原吧，那必定会是一番尽情的
                                        燃烧。待，秋风萧瑟时，散作满天星辰，你看那四季轮回，正是Layui不灭的执念。
                                    </p>
                                </div><div class="layui-inline img"><img src="../res/static/img/us_img2.jpg"></div>
                                <p class="p_hidden">如果眼下还是一团零星之火，那运筹帷幄之后，迎面东风，就是一场烈焰燎原吧，那必定会是一番尽情的燃烧。待，秋风萧瑟时，散作满天星辰，你看那四季轮回，正是Layui不灭的执念。</p>
                            </div>

                            <div class="content">
                                <div class="layui-inline img">
                                    <img src="../res/static/img/us_img3.jpg">
                                </div>
                                <div class="layui-inline panel">
                                <p>拥有双面的不仅是人生，还有Layui。一面极简，一面丰盈。极简是视觉所见的外在，是开发所念的简易。丰盈是倾情雕琢的内在，是信手拈来的承诺。一切本应如此，简而全，双重体验。</p>
                                </div>
                            </div>

                        </div>

                        <div class="tabJob">
                            <div class="content">
                                <p class="title">前端开发工程教师</p>
                                <p>> 职位描述</p>
                                <ol>
                                    <li>前端开发及维护工作；</li>
                                    <li>有良好的技术基础，熟悉 Web 标准，熟练掌握多种 Web 前端技术；</li>
                                    <li>掌握行业内流行的类库，Vue.js， React 等主流框架；</li>
                                    <li>参与公司前端工程的设计、研发；</li>
                                    <li>了解不同浏览器之间的差异，移动设备之间的差异。</li>
                                </ol>
                            </div>
                            <div class="content">
                                <p class="title">IOS 开发工程教师</p>
                                <p>> 职位描述</p>
                                <ol>
                                    <li>前端开发及维护工作；</li>
                                    <li>有良好的技术基础，熟悉 Web 标准，熟练掌握多种 Web 前端技术；</li>
                                    <li>掌握行业内流行的类库，Vue.js， React 等主流框架；</li>
                                    <li>参与公司前端工程的设计、研发；</li>
                                    <li>了解不同浏览器之间的差异，移动设备之间的差异。</li>
                                </ol>
                            </div>
                            <div class="content">
                                <p class="title">JAVA 工程教师</p>
                                <p>> 职位描述</p>
                                <ol>
                                    <li>前端开发及维护工作；</li>
                                    <li>有良好的技术基础，熟悉 Web 标准，熟练掌握多种 Web 前端技术；</li>
                                    <li>掌握行业内流行的类库，Vue.js， React 等主流框架；</li>
                                    <li>参与公司前端工程的设计、研发；</li>
                                    <li>了解不同浏览器之间的差异，移动设备之间的差异。</li>
                                </ol>
                            </div>
                        </div>

                        <div class="tabCour">
                            <p class="title">我们的蜕变</p>
                            <ul class="timeline">

                                <li class="odd">
                                    <div class="cour-img"><img src="/static/images/website/us_img4.png"></div>
                                    <div class="cour-panel layui-col-sm4 layui-col-lg5">
                                        <p class="label">2017 年 6 月</p>
                                        <p>我们成立了，来到了杭州西湖这个美丽的地方。</p>
                                    </div>
                                </li>

                                <li>
                                    <div class="cour-img"><img src="/static/images/website/us_img4.png"></div>
                                    <div class="cour-panel layui-col-sm4 layui-col-sm-offset8 layui-col-lg5 layui-col-lg-offset7">
                                        <p class="label">2017 年 6 月</p>
                                        <p>我们成立了，来到了杭州西湖这个美丽的地方。</p>
                                    </div>
                                </li>
                                <li class="odd">
                                    <div class="cour-img"><img src="/static/images/website/us_img4.png"></div>
                                    <div class="cour-panel layui-col-sm4 layui-col-lg5">
                                        <p class="label">2017 年 6 月</p>
                                        <p>我们成立了，来到了杭州西湖这个美丽的地方。</p>
                                    </div>
                                </li>
                                <li>
                                    <div class="cour-img"><img src="/static/images/website/us_img4.png"></div>
                                    <div class="cour-panel layui-col-sm4 layui-col-sm-offset8 layui-col-lg5 layui-col-lg-offset7">
                                        <p class="label">2017 年 6 月</p>
                                        <p>我们成立了，来到了杭州西湖这个美丽的地方。</p>
                                    </div>
                                </li>
                                <li class="odd">
                                    <div class="cour-img"><img src="/static/images/website/us_img4.png"></div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>


    </div>
</div>

<#include "common/footer.ftl">

    <script type="text/javascript">

        layui.config({
            base: '/static/js/website/'
        }).use('mm');

    </script>


</body>
</html>