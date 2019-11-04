<!DOCTYPE html>
<html>

<#include "common/head.ftl">

<body>
<#include "common/header.ftl">
<div class="f-main clearfix">

<#include "common/nav.ftl">


    <div class="setting-right">

        <div class="layui-tab">
            <ul class="layui-tab-title">
                <li class="layui-this">基本信息</li>
                <li>账号密码设置</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <form class="layui-form">

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">已绑手机</label>
                                <div class="layui-input-inline">
                                    <input type="tel" name="mobile" value="152178483687" autocomplete="off" class="layui-input" disabled>
                                </div>
                                <div class="layui-form-mid layui-word-aux">手机号/账号可用于当做网站登录</div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">头像</label>
                            <div class="layui-input-block">
                                <button type="button" class="layui-btn" id="img">
                                    <i class="layui-icon">&#xe67c;</i>上传图片
                                </button>
                            </div>
                        </div>

                        <div class="layui-form-item" style="left:">
                            <div class="layui-inline">
                                <label class="layui-form-label">姓名</label>
                                <div class="layui-input-block" style="width: 120px;">
                                    <input type="text" name="realname" placeholder="请输入" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">性别</label>
                                <div class="layui-input-block">
                                    <input type="radio" name="gender" value="男" title="男" checked="">
                                    <input type="radio" name="gender" value="女" title="女">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">生日</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="birthday" id="birthday" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">学历</label>
                                <div class="layui-input-block" style="width: 120px;">
                                    <select name="education" lay-filter="aihao">
                                        <option value="大专">大专</option>
                                        <option value="本科">本科</option>
                                        <option value="硕士">硕士</option>
                                        <option value="博士">博士</option>
                                        <option value="博士后">博士后</option>
                                    </select>
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">学校</label>
                                <div class="layui-input-block" style="width: 120px;">
                                    <select name="school" lay-filter="aihao">
                                        <option value="惠州学院">惠州学院</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                    <#-- <div class="layui-form-item">
                         <label class="layui-form-label">地址</label>
                         <div class="layui-input-inline">
                             <select name="quiz1">
                                 <option value="">请选择省</option>
                                 <option value="浙江" selected="">浙江省</option>
                                 <option value="你的工号">江西省</option>
                                 <option value="你最喜欢的老师">福建省</option>
                             </select>
                         </div>
                         <div class="layui-input-inline">
                             <select name="quiz2">
                                 <option value="">请选择市</option>
                                 <option value="杭州">杭州</option>
                                 <option value="宁波" disabled="">宁波</option>
                                 <option value="温州">温州</option>
                                 <option value="温州">台州</option>
                                 <option value="温州">绍兴</option>
                             </select>
                         </div>
                         <div class="layui-input-inline">
                             <select name="quiz3">
                                 <option value="">请选择县/区</option>
                                 <option value="西湖区">西湖区</option>
                                 <option value="余杭区">余杭区</option>
                                 <option value="拱墅区">临安市</option>
                             </select>
                         </div>-->

                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">头衔</label>
                            <div class="layui-input-block">
                                <textarea placeholder="请输入内容" name="title" class="layui-textarea"></textarea>
                            </div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">签名</label>
                            <div class="layui-input-block">
                                <textarea placeholder="请输入内容" name="sign" class="layui-textarea"></textarea>
                            </div>
                        </div>





                        <div class="layui-form-item">
                            <label class="layui-form-label">兴趣爱好</label>
                            <div class="layui-input-block">
                                <input type="checkbox" name="like[java]" title="Java">
                                <input type="checkbox" name="like[C++]" title="C++">
                                <input type="checkbox" name="like[Python]" title="Python">
                                <input type="checkbox" name="like[java]" title="Java">
                                <input type="checkbox" name="like[C++]" title="C++">
                                <input type="checkbox" name="like[Python]" title="Python">
                            </div>
                        </div>


                        <br> <br>
                        <div class="layui-form-item" style="margin: 0px 0px 0px 100px;">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="*">立即提交</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>

                    </form>
                </div>
                <div class="layui-tab-item">

                    <form class="layui-form">
                        <div class="layui-form-item">
                            <label class="layui-form-label"><span style="color: red">*</span>账号</label>
                            <div class="layui-input-inline">
                                <input type="tel" name="username" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label"><span style="color: red">*</span>旧密码</label>
                            <div class="layui-input-inline">
                                <input type="text" name="oldPassword" autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">初始化密码为123456</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label"><span style="color: red">*</span>新密码</label>
                            <div class="layui-input-inline">
                                <input type="text" name="password" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <br> <br>
                        <div class="layui-form-item" style="margin: 0px 0px 0px 100px;">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="*">立即提交</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>
                    </form>

                </div>
                <div class="layui-tab-item">内容3</div>
                <div class="layui-tab-item">内容4</div>
                <div class="layui-tab-item">内容5</div>
            </div>
        </div>




    </div>
</div>


<#include "common/footer.ftl">

    <script type="text/javascript">
        layui.use(['form', 'layedit', 'laydate'], function(){
            var form = layui.form,
                    layer = layui.layer,
                    layedit = layui.layedit,
                    laydate = layui.laydate;

            //日期
            laydate.render({
                elem: '#birthday'
            });

            //监听提交
            form.on('submit(formDemo)', function(data) {
                layer.msg(JSON.stringify(data.field));
                return false;
            });
        });

        layui.use('upload', function(){
            var upload = layui.upload;
            //执行实例
            var uploadInst = upload.render({
                elem: '#img' //绑定元素
                ,url: '/upload/' //上传接口
                ,done: function(res){
                    //上传完毕回调
                }
                ,error: function(){
                    //请求异常回调
                }
            });
        });

    </script>

</body>
</html>