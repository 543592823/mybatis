<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <%@include file="/common/head.jsp" %>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <!-- <link rel="stylesheet/less" type="text/css" href="css/style.less" /> -->
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="js/all.js"></script>
    <script type="text-javascript" src="js/jquery/jquery-2.1.3.js"></script>
    <script type="text-javascript" src="js/plugins/jquery-validation/jquery.validate.js"></script>
    <script type="text-javascript" src="js/plugins/jquery-validation/localization/messages_zh.js"></script>
    <script type="text-javascript" src="js/plugins/jquery.form.js"></script>

    <script type="text/javascript">
        $(function() {
            $("#loginForm").validate({
                rules : {
                    username : {
                        required : true,
                    },
                    password : {
                        required : true,
                    }
                },
                messages:{
                    username:{
                        required:"用户名不能为空",
                    },
                    password:{
                        required:"密码不能为空",
                    },
                },
                errorClass:"text-danger",
                highlight:function(input){
                    $(input).closest(".form-group").addClass("has-error");
                },
                unhighlight:function(input){
                    $(input).closest(".form-group").removeClass("has-error");
                },
                submitHandler:function(){
                    $("#loginForm").ajaxSubmit({
                        dataType:'json',
                        success:function(data){
                            if(data.success){
                                $.messager.confirm("提示","登录成功,点击确认进入个人中心",function(){
                                    window.location.href="/personal.do";
                                });
                            } else {
                                $.messager.popup(data.message);
                            }
                        }
                    });
                }
            });
        });
    </script>



</head>
<body>
<!-- header start -->
<%@include file="top/topAll.jsp" %>
<!-- end top -->
<div class="zxcf_nav_wper">
    <div class="zxcf_nav clearfix px1000">
        <div class="zxcf_nav_l fl"><img src="images/zxcf_logo.png" alt=""></div>
        <div class="zxcf_nav_r fr">
            <img src="images/lg_pic01.png" alt="">
            <span>
		    <a href="#">返回首页</a></span>

        </div>
    </div>
</div>
<!-- end  -->
<div class="login_con_wper">
    <div class="login_con px1000 ">
        <div class="lg_section clearfix">
            <div class="lg_section_l fl">
                <img src="images/lg_bg02.png">
            </div>
            <!-- end l -->
            <div class="lg_section_r fl">
                <h2 class="lg_sec_tit clearfix">
                    <span class="fl">登录</span>
                    <em class="fr">没有帐号，<a href="${ctx}/register">立即注册</a></em>
                </h2>
                <form id="loginForm" action="${ctx}/user/login" method="post" modelAttribute="UserPfuser">
                    <fieldset>
                        <p class="mt20">
                            <input type="text" name="userName" placeholder="用户名/手机" class="lg_input01 lg_input">

                        </p>
                        <p class="mt20">
                            <input type="text" name="password" placeholder="密码" class="lg_input02 lg_input">

                        </p>
                        <p class="clearfix lg_check"><span class="fl"><input type="checkbox">记住用户名</span><a href="#" class="fr">忘记密码？找回</a></p>
                        <p>
                            <%--<a href="${ctx}/user/login" class="lg_btn">立即登陆</a>--%>
                            <input type="submit" value="立即登陆" class="lg_btn">
                        </p>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- footer start -->
<div class="zscf_aboutus_wper">
    <div class="zscf_aboutus px1000 clearfix">
        <div class="zscf_aboutus_l fl">
            <ul class="zscf_aboutus_lul clearfix">
                <li class="pt10"><a href="#"><img src="images/app.png" alt=""></a>
                </li>
                <li>
                    <p class="pb20">服务热线</p>
                    <strong>400-027-0101</strong>
                </li>
                <li>
                    <p class="pb10 linkpic">
                        <a href="#"><img src="images/ft_sina.png" alt=""></a>
                        <a href="#"><img src="images/ft_weixin.png" alt=""></a>
                        <a href="#"><img src="images/ft_erji.png" alt=""></a>
                    </p>
                    <p><a href="#">kefu@zhongxincaifu.com</a></p>
                </li>
            </ul>
        </div>
        <!-- end left -->
        <div class="zscf_aboutus_r fl clearfix">
            <a href="#" class="fl ft_ewm"><img src="images/ft_erweima.png" alt=""></a>
            <ul class="fl clearfix">
                <li><a href="#">联系我们</a></li>
                <li><a href="#">我要融资</a></li>
                <li><a href="problem.jsp">帮助中心</a></li>
                <li><a href="#">友情链接</a></li>
                <li><a href="#">招贤纳士</a></li>
                <li><a href="#">收益计算器</a></li>
            </ul>
        </div>
        <!-- end right -->

    </div>
</div>

<div class="zscf_bottom_wper">
    <div class="zscf_bottom px1000 clearfix">
        <p class="fl">© 2014 zhongxincaifu &nbsp;  &nbsp;&nbsp;   中兴财富金融信息服务股份有限公司 &nbsp;&nbsp;&nbsp;    来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
        <p class="fr">
            <a href="#"><img src="images/360.png" alt=""></a>
            <a href="#"><img src="images/kexin.png" alt=""></a>
            <a href="#"><img src="images/norton.png" alt=""></a>
        </p>
    </div>
</div>
<!-- footer end -->
</body>
</html>
