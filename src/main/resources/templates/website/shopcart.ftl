<!DOCTYPE html>
<html>

<#include "common/head.ftl">

<body>

<#include "common/header.ftl">


<div class="content content-nav-base shopcart-content">

 <#include "common/main-nav.ftl">




    <div class="cart w1200">
        <div class="cart-table-th">
            <div class="th th-chk">
                <div class="select-all">
                    <div class="cart-checkbox">
                        <input class="check-all check" id="allCheckked" type="checkbox" value="true">
                    </div>
                    <label>&nbsp;&nbsp;全选</label>
                </div>
            </div>
            <div class="th th-item">
                <div class="th-inner">
                    课程
                </div>
            </div>
            <div class="th th-price">
                <div class="th-inner">
                    单价
                </div>
            </div>
            <div class="th th-amount">
                <div class="th-inner">
                    数量
                </div>
            </div>
            <div class="th th-sum">
                <div class="th-inner">
                    小计
                </div>
            </div>
            <div class="th th-op">
                <div class="th-inner">
                    操作
                </div>
            </div>
        </div>
        <div class="OrderList">
            <div class="order-content" id="list-cont">

                <ul class="item-content layui-clear">
                    <li class="th th-chk">
                        <div class="select-all">
                            <div class="cart-checkbox">
                                <input class="CheckBoxShop check" id="" type="checkbox" num="all" name="select-all" value="true">
                            </div>
                        </div>
                    </li>
                    <li class="th th-item">
                        <div class="item-cont">
                            <a href="javascript:;">
                                <img style="width: 120px;height: 90px" src="http://szimg.mukewang.com/58f57d200001461105400300-360-202.jpg" alt="">
                            </a>
                            <div class="text">
                                <div class="title">Java从入门到精通</div>
                                <p><span>xo老师</span>  <span>130</span>cm</p>
                            </div>
                        </div>
                    </li>
                    <li class="th th-price">
                        <span class="th-su">189.00</span>
                    </li>
                    <li class="th th-amount">
                        <div class="box-btn layui-clear">
                            <div class="less layui-btn">-</div>
                            <input class="Quantity-input" type="" name="" value="1" disabled="disabled">
                            <div class="add layui-btn">+</div>
                        </div>
                    </li>
                    <li class="th th-sum">
                        <span class="sum">189.00</span>
                    </li>
                    <li class="th th-op">
                        <span class="dele-btn">删除</span>
                    </li>
                </ul>

                <ul class="item-content layui-clear">
                    <li class="th th-chk">
                        <div class="select-all">
                            <div class="cart-checkbox">
                                <input class="CheckBoxShop check" id="" type="checkbox" num="all" name="select-all" value="true">
                            </div>
                        </div>
                    </li>
                    <li class="th th-item">
                        <div class="item-cont">
                            <a href="javascript:;">
                                <img style="width: 120px;height: 90px" src="http://szimg.mukewang.com/58f57d200001461105400300-360-202.jpg" alt="">
                            </a>
                            <div class="text">
                                <div class="title">宝宝T恤棉质小衫</div>
                                <p><span>粉色</span>  <span>130</span>cm</p>
                            </div>
                        </div>
                    </li>
                    <li class="th th-price">
                        <span class="th-su">189.00</span>
                    </li>
                    <li class="th th-amount">
                        <div class="box-btn layui-clear">
                            <div class="less layui-btn">-</div>
                            <input class="Quantity-input" type="" name="" value="1" disabled="disabled">
                            <div class="add layui-btn">+</div>
                        </div>
                    </li>
                    <li class="th th-sum">
                        <span class="sum">189.00</span>
                    </li>
                    <li class="th th-op">
                        <span class="dele-btn">删除</span>
                    </li>
                </ul>

                <ul class="item-content layui-clear">
                    <li class="th th-chk">
                        <div class="select-all">
                            <div class="cart-checkbox">
                                <input class="CheckBoxShop check" id="" type="checkbox" num="all" name="select-all" value="true">
                            </div>
                        </div>
                    </li>
                    <li class="th th-item">
                        <div class="item-cont">
                            <a href="javascript:;">
                                <img style="width: 120px;height: 90px" src="http://szimg.mukewang.com/58f57d200001461105400300-360-202.jpg" alt="">
                            </a>
                            <div class="text">
                                <div class="title">宝宝T恤棉质小衫</div>
                                <p><span>粉色</span>  <span>130</span>cm</p>
                            </div>
                        </div>
                    </li>
                    <li class="th th-price">
                        <span class="th-su">189.00</span>
                    </li>
                    <li class="th th-amount">
                        <div class="box-btn layui-clear">
                            <div class="less layui-btn">-</div>
                            <input class="Quantity-input" type="" name="" value="1" disabled="disabled">
                            <div class="add layui-btn">+</div>
                        </div>
                    </li>
                    <li class="th th-sum">
                        <span class="sum">189.00</span>
                    </li>
                    <li class="th th-op">
                        <span class="dele-btn">删除</span>
                    </li>
                </ul>
            </div>
        </div>


        <div class="FloatBarHolder layui-clear">
            <div class="th th-chk">
                <div class="select-all">
                    <div class="cart-checkbox">
                        <input class="check-all check" id="" name="select-all" type="checkbox"  value="true">
                    </div>
                    <label>&nbsp;&nbsp;已选<span class="Selected-pieces">0</span>门</label>
                </div>
            </div>
            <div class="th batch-deletion">
                <span class="batch-dele-btn">批量删除</span>
            </div>
            <div class="th Settlement">
                <button class="layui-btn">结算</button>
            </div>
            <div class="th total">
                <p>应付：<span class="pieces-total">0</span></p>
            </div>
        </div>
    </div>
</div>

<#include "common/footer.ftl">

<script type="text/javascript">
    layui.config({
        base: '/static/js/website/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['mm','jquery','element','car'],function(){
        var mm = layui.mm,$ = layui.$,element = layui.element,car = layui.car;

        car.init()


    });
</script>
</body>
</html>