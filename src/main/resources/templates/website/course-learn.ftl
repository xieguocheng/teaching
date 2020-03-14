<!DOCTYPE html>
<html>

<#include "common/head.ftl">
<link rel="stylesheet" type="text/css" href="/static/css/reset.css">

<body>

<#include "../user/common/header.ftl">

<div class="f-main clearfix">
    <div class="main-course-left">
        <div class="course-info">
            <div class="course-title" style="font-size: 24px;">${(courseSection.name)!}</div>

            <div class="course-video">
                <video src="${courseSection.videoUrl}" width="100%" height="100%" controls preload></video>
            </div>

            <div class="layui-tab layui-tab-brief">
                <ul class="layui-tab-title">
                    <li class="layui-this">评论</li>
                    <li>问答</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <style>
                            .comment_content {
                                margin-top:10px;
                                letter-spacing: .2px;
                                font-size: 95%;
                            }

                            .comment{
                                display: flex;
                                flex-flow: row;
                                padding:1.8em 0em;

                                border-bottom: thin solid #ddd;
                            }
                           .comment:last-child{
                                border-bottom: 0;
                            }
                            .imgdiv{
                                margin-right: 1.5em;
                            }
                            .imgcss {
                                width:50px;
                                height:50px;
                                border-radius: 50%;
                            }
                            .conmment_details{

                                width: 100%;
                            }
                            .comment_name {

                                color:#009688;
                                font-size:15px;
                                font-weight: bolder;
                            }
                            .layui-icon {
                                font-size: 10px;
                                color: grey;
                            }

                        </style>
                         <#if courseCommentList??>
                             <#list courseCommentList as item>
                        <div class="comment">
                            <div class="imgdiv">
                                <img class="imgcss"  src="/static/images/user/default-avatar.png"/>
                            </div>
                            <div class="conmment_details">
                                <span class="comment_name">${item.username!} </span>    
                                <span style="float:right">${item.createTime?string('yyyy-MM-dd hh:mm:ss')}</span>
                                <div class="comment_content" >${item.content!}</div>
                            </div>
                            <hr>
                        </div>
                             </#list>
                         </#if>

                        <div style="margin-top: 20px;">
                            <form class="layui-form" action="/user/course/comment">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">请发表评论:</label>
                                    <div class="layui-input-block">
                                        <textarea placeholder="请输入内容" name="content" class="layui-textarea"></textarea>
                                    </div>
                                    <input name="sectionId" value="${courseSection.id}" hidden/>
                                </div>
                                <div class="layui-form-item" style="margin: 0px 0px 0px 100px;">
                                    <div class="layui-input-block">
                                        <button class="layui-btn" lay-submit lay-filter="*">发布评论</button>
                                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                    </div>
                                </div>
                            </form>
                        </div>

                    </div>

                    <div class="layui-tab-item">

                        <div style="margin-top: 20px;">
                            <form class="layui-form">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">请发表问答:</label>
                                    <div class="layui-input-block">
                                        <textarea placeholder="请输入内容" name="sign" class="layui-textarea"></textarea>
                                    </div>
                                </div>
                                <div class="layui-form-item" style="margin: 0px 0px 0px 100px;">
                                    <div class="layui-input-block">
                                        <button class="layui-btn" lay-submit lay-filter="*">确认发布</button>
                                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                    </div>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- 章节-start -->
    <div class="main-course-right"  >
        <h4 class="mt-50">所有章节</h4>
        <div class="video-course-fix-parent">
            <div class="video-course-fix">
					<#if chaptSections??>
					<#list chaptSections as item>
					<div class="chapter">
                        <a href="javascript:void(0);" class="js-open">
                            <h3>
                                <strong><div class="icon-chapter layui-icon layui-icon-spread-left"></div>${item.name!}</strong>
                                <span class="drop-down">▼</span>
                            </h3>
                        </a>
                        <ul class="chapter-sub">
							<#if item.sections??>
							<#list item.sections as section>
							<a href="/user/course/learn/${section.id}" >
                                <li class="chapter-sub-li">
                                    <i class="layui-icon  layui-icon-video ">&nbsp${section.name!} (${section.time!})</i>
                                </li>
                            </a>
                            </#list>
                            </#if>
                        </ul>
                    </div>
                    </#list>
                    </#if>
            </div>
        </div>

    </div>
    <!-- 章节-end -->
</div>


<script>

    layui.use('element', function(){
        var element = layui.element;
    });

    $(function(){
        //实现 章节鼠标焦点 动态效果
        $('.chapter li').hover(function(){
            $(this).find('.layui-icon-video').css('color','#FFF');
        },function(){
            $(this).find('.layui-icon-video').css('color','#777');
        });

        $('.js-open').click(function(){
            var display = $(this).parent().find('ul').css('display');
            if(display == 'none'){
                $(this).parent().find('ul').css('display','block');
                $(this).find('.drop-down').html('▼');
            }else{
                $(this).parent().find('ul').css('display','none');
                $(this).find('.drop-down').html('▲');
            }
        });


    });
</script>

</body>
</html>