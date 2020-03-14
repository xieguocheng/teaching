<!DOCTYPE html>
<html>

<#include "common/head.ftl">
<link rel="stylesheet" type="text/css" href="/static/css/reset.css">

<body>

<#include "common/header1.ftl">


<div class="f-main clearfix">
    <div class="main-course-left">
        <!-- 基础信息 - start -->
        <div class="course-info">
            <div class="course-title">${(course.name)!}</div>
            <div class="course-meta">

                 <#if curCourseSection??>
                     <a href="/user/course/learn/${(curCourseSection.id)!}" class="learn-btn" >继续学习</a>
                 <#else>
                     <a href="/user/course/learn/first/${(course.id)}" class="learn-btn" >开始学习</a>
                 </#if>

                <div class="static-item"  >
                    <div class="meta">上次学到</div>
                 <div class="meta-value" title="${(curCourseSection.name)!}">${(curCourseSection.name)!}</div>
                </div>
                <div class="static-item"  >
                    <div class="meta">学习人数</div>
                    <div class="meta-value">${(course.studyCount)!}</div>
                </div>
                <div class="static-item">
                    <div class="meta">难度级别</div>
                    <div class="meta-value">
									<#if course?? && course.level??>
										<#if course.level == 1>
										初级
                                        <#elseif course.level == 2>
										中级
                                        <#else>
										高级
                                        </#if>
                                    </#if>
                    </div>
                </div>
                <div class="static-item" style="border:none;">
                    <div class="meta">课程时长</div>
                    <div class="meta-value">${(course.time)!}</div>
                </div>
                <a id="collectionSpan" onclick="doCollect(${(course.id)!})" href="javascript:void(0)" class="following" style="float: right;margin-top:5px;" >
                </a>
            </div>
            <div class="course-brief">
            ${(course.brief)!}
            </div>


            <div class="layui-tab layui-tab-brief">
                <ul class="layui-tab-title">
                    <li class="layui-this">章节</li>
                    <li>评论</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">

                        <!-- 章节信息 - start -->
                        <div id="courseSection">
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
                        <!-- 章节信息 - end -->

                    </div>

                    <div class="layui-tab-item">
                       评论
                    </div>

                </div>
            </div>

        </div>
        <!-- 基础信息 - end -->
    </div>

    <div class="main-course-right"  >
                <#if courseTeacher??>
                <div class="lecturer-item" style="width: 100%;">
                    <#if courseTeacher.hearder?? && courseTeacher.hearder != ''>
                    <img class="lecturer-uimg" src="${courseTeacher.hearder!}">
                    <#else>
                    <img class="lecturer-uimg" src="/static/images/user/default-avatar.png">
                    </#if>
                    <span class="lecturer-name">${(courseTeacher.realname)!""}</span>
                    <span class="lecturer-title">${(schoolName)!""} · ${(courseTeacher.education)!""}</span>
                    <span class="lecturer-p" >${(courseTeacher.title)!""}，${(courseTeacher.sign)!""}</span>
                    <a href="javascript:void(0)"  onclick="doFollow('${(courseTeacher.id!)}');">
                        <span id="followSpan" class="follow-btn">
                        <#if followFlag??>
                        已关注
                        <#else>
                        关注+
                        </#if>
                        </span>
                    </a>
                </div>
                </#if>

                <h4 class="mt-50"><i class="layui-icon layui-icon-flag">&nbsp;推荐课程</i></h4>
                <#if recomdCourseList?? && recomdCourseList?size gt 0 >
                    <#list recomdCourseList as item>
                <a href="/website/course/courseDetail/${item.id}" target="_black" class="mb-5" title="${item.name!}">
                    <li class="ellipsis oc-color-hover">${item.name!}</li></a>
                    </#list>
                </#if>
    </div>

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


    //关注
    function doFollow(followId,url){
        debugger;
        var follow=$('#followSpan').text().trim();
        if(follow==='关注+'){
            url = '/user/follow/doFollow';
        }else {
            url = '/user/follow/isFollow';
        }

        $.ajax({
            url:url,
            type:'POST',
            dataType:'json',
            data:{"followId":followId},
            success:function(data){
                debugger;
                if (data.code === 0){
                    $('#followSpan').html('已关注');
                }else if(data.code === 1){
                    $('#followSpan').html('关注+');
                }
            }
        });
    }
</script>



</body>
</html>