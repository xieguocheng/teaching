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
                    <legend>账号密码/手机登录</legend>
                    <div class="layui-form-item">

                        <div class="layui-inline iphone">
                            <div class="layui-input-inline">
                                <i class="layui-icon layui-icon-cellphone iphone-icon"></i>
                                <input type="tel" name="account" id="account" lay-verify="required|phone"
                                       placeholder="请输入手机号/账号" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-inline iphone" id="mima" >
                            <div class="layui-input-inline">
                                <i class="layui-icon layui-icon-password iphone-icon"></i>
                                <input hidden type="password" name="loginPassword" id="loginPassword"
                                       placeholder="请输入密码" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-inline veri-code" id="duanxin" style="display: none">
                            <div class="layui-input-inline">
                                <i class="layui-icon layui-icon-vercode iphone-icon"></i>
                                <input style="padding-left: 40px;" id="pnum" type="text" name="pnum"
                                       placeholder="请输入验证码" autocomplete="off" class="layui-input">
                                <input type="button" class="layui-btn" id="find"  value="验证码" />
                            </div>
                        </div>

                    </div>

                    <div class="layui-form-item login-btn">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit="" lay-filter="demo1" id="loginBtn" onclick="return false">登录</button>
                        </div>
                    </div>

                    <div style="left: 15px; cursor: pointer;"  id="passwordLogin" onclick="passwordLogin()" hidden>
                        账号密码登录
                    </div>
                    <div style="left: 15px; cursor: pointer;" id="smsLogin" onclick="smsLogin()" >
                        短信登录
                    </div>

                </form>
            </div>
        </div>
    </div>

</div>

<#include "common/footer.ftl">

<script type="text/javascript">

    $(function () {

        // 登陆事件
        $('#loginBtn').on('click', function () {
            var loginUsername = $('#account').val();
            var loginPassword = $('#loginPassword').val();
            var params = {};
            params.username = loginUsername;
            params.password = loginPassword;
            debugger;
            var loginLoadIndex = layer.load(2);
            $('#loginBtn').val("正在登录...");
            $.ajax({
                type:'post',
                url:"/login"+"?username="+loginUsername+"&password="+loginPassword,
                dataType:'json',
                //data:JSON.stringify(params),
                data: "name="+loginUsername+"&password="+loginPassword,
                contentType:'application/json',
                success: function (data) {
                    debugger;
                    layer.close(loginLoadIndex);
                    console.log(data);
                    if(data.status=="ok"){
                        console.log("ok")
                        window.location.href = '/user/home';
                    }else if(data.status=="error"){
                        console.log("error")
                        $('#loginBtn').val("登录");
                        layer.msg("账号密码错误！", {icon: 5, time: 2000});
                    }
                },
                error:function () {
                    debugger;
                    layer.close(loginLoadIndex);
                    $('#loginBtn').val("登录");
                    layer.msg("error！", {icon: 5, time: 2000});
                }
            });
        })
     });


   //密码登录
   function passwordLogin(){
       $("#smsLogin").show();
       $("#passwordLogin").hide();
       document.getElementById("mima").style.display = "block";
       document.getElementById("duanxin").style.display = "none";
   }
   //短信登录
    function smsLogin(){
        $("#smsLogin").hide();
        $("#passwordLogin").show();

        document.getElementById("mima").style.display = "none";
        document.getElementById("duanxin").style.display = "block";
    }

    layui.config({
        base: '/static/js/website/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['jquery','form'],function(){
        var $ = layui.$,form = layui.form;


        $("#find").click(function() {
            if(!/^1\d{10}$/.test($("#account").val())){
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