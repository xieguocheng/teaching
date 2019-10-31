<!DOCTYPE html>
<html>

<#include "common/head.ftl">

<body>

<#include "common/header.ftl">


<div class="content content-nav-base  login-content">

 <#include "common/main-nav.ftl">

    <div class="login-bg">
        <div class="login-cont w1200">
            <div class="form-box">
                <form class="layui-form" action="">
                    <legend>手机号登录</legend>
                    <div class="layui-form-item">
                        <div class="layui-inline iphone">
                            <div class="layui-input-inline">
                                <i class="layui-icon layui-icon-cellphone iphone-icon"></i>
                                <input type="tel" name="phone" id="phone" lay-verify="required|phone" placeholder="请输入手机号" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline veri-code">
                            <div class="layui-input-inline">
                                <input id="pnum" type="text" name="pnum" lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input">
                                <input type="button" class="layui-btn" id="find"  value="验证码" />
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item login-btn">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit="" lay-filter="demo1" onclick="return false">登录</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<#include "common/footer.ftl">

<script type="text/javascript">
    layui.config({
        base: '/static/js/website/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['jquery','form'],function(){
        var $ = layui.$,form = layui.form;


        $("#find").click(function() {
            if(!/^1\d{10}$/.test($("#phone").val())){
                layer.msg("请输入正确的手机号");
                return false;
            }
            var obj=this;
            $.ajax({
                type:"get",
                url:"../json/login.json",
                dataType:"json",//返回的
                success:function(data) {

                    if(data.result){
                        $("#find").addClass(" layui-btn-disabled");
                        $('#find').attr('disabled',"true");
                        settime(obj);
                        $("#msg").text(data.msg);
                    }else{
                        layer.msg(data.msg);
                    }
                },
                error:function(msg) {
                    console.log(msg);
                }
            });
        })
        var countdown=60;
        function settime(obj) {
            if (countdown == 0) {
                obj.removeAttribute("disabled");
                obj.classList.remove("layui-btn-disabled")
                obj.value="获取验证码";
                countdown = 60;
                return;
            } else {

                obj.value="重新发送(" + countdown + ")";
                countdown--;
            }
            setTimeout(function() {
                        settime(obj) }
                    ,1000)
        }
    })
</script>

</body>
</html>