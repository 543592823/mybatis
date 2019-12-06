<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<%@include file="/common/head.jsp" %>
	<title>注册</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<!-- <link rel="stylesheet/less" type="text/css" href="css/style.less" /> -->
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/all.js"></script>
	<!--[if IE 6]>
	<script src="./js/iepng.js" type="text/javascript"></script>
	<script type="text/javascript">
		EvPNG.fix('div, ul, img, li, input,span, p');
	</script>
	<script type="text-javascript" src="js/jquery/jquery-2.1.3.js"></script>
	<script type="text-javascript" src="js/plugins/jquery-validation/jquery.validate.js"></script>
	<script type="text-javascript" src="js/plugins/jquery-validation/localization/messages_zh.js"></script>
	<script type="text-javascript" src="js/plugins/jquery.form.js"></script>

	<script type="text/javascript">
		// submit:function (form) {
		//   dataType:"json",
		// 		  success : function (data) {
		// 		    if(data.success){
		// 					$.messager.confirm("提示","注册成功,点击确认进入登录界面",function(){
		// 					   window.location.href = "${ctx}/user/login";
		// 					});
		// 			}else{
		// 		        $.messager.popup(data.msg);
		// 		        alert("注册失败");
		// 			}
		// 		  }
		// }
		$(function(){
			$("#registerForm").validate({
				rules:{
					userName:{
						required:true,
						remote:{
							url:"/register",
							type:"POST",
							data:{
								userName:function(){
									return $("#userName").val();
								}
							}
						}
					},
					password:{
						required:true,
						rangelength:[4,16]
					},
					confirmPwd:{
						equalTo:"#password"
					}
				},
				messages:{
					username:{
						required:"用户名称不能为空",
						remote:"账户名已被注册"
					},
					password:{
						required:"密码不能为空",
						rangelength:"密码长度需要在{4}到{16}之间"
					},
					confirmPwd:{
						equalTo:"两次填写的密码不一致"
					}
				},
				errorClass:"text-danger",//文字的错误样式
				//未通过验证,进行高亮处理或其它处理
				highlight:function(input){
					$(input).closest(".mt20").addClass("has-error");
				},
				//通过校验,清除高亮效果或其它处理
				unhighlight:function(input){
					$(input).closest(".mt20").removeClass("has-error");
				},
				submitHandler:function(form){
					$(form).ajaxSubmit({
						dataType:'json',
						success:function(data){
							if(data.success){
								$.messager.confirm("提示消息","注册成功,请重新登录",function(){
									window.location.href="/login.jsp";
								});
							} else {
								$.messager.popup(data.message);
							}
						}
					});
				}
			});
		})




	</script>


	<![endif]-->
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
<div class="reg_con_wper">
	<div class="reg_con px1000">
		<div class="reg_box clearfix">
			<div class="reg_box_l fl">
				<img src="images/reg_pic01.png" alt="">
			</div>
			<div class="reg_box_r fl">
				<h2 class="lg_sec_tit clearfix">
					<span class="fl">注册</span>
					<em class="fr">已有帐号，<a href="${ctx}/login">立即登录</a></em>
				</h2>
				<form id="registerForm" action="${ctx}/user/register" method="post" modelAttribute="UserPfuser">
					<fieldset>
						<p class="mt20">
							<input name="userName" type="text" placeholder="用户名/手机"  class="lg_input01 lg_input">
						</p>

						<p class="mt20">
							<input name="password" type="text" placeholder="密码" class="lg_input02 lg_input">
						</p>
						<p class="mt20">
							<input name="confirmPwd" type="text" placeholder="密码确认" class="lg_input02 lg_input">
						</p>
						<p class="mt20">
							<input name="phoneNumber" type="text" placeholder="手机号" class="lg_input03 lg_input">
							<%--<input id="getCode" type="button" value="获取验证码"><br>--%>
						</p>
						<p class="mt20 yanzheng">
							<%--<input type="text" id="phone" placeholder="请输入手机号码">--%>
							<%--<input id="getCode" type="button" value="获取验证码"><br>--%>
							<%--<input type="text" id="code" placeholder="验证码">--%>
							<%--<input id="validate" type="button" value="验证">--%>

							<input type="text" id="code" placeholder="验证码" class="lg_input04 lg_input">
							<span href="#">获取验证码</span>
						</p>
						<%--<p class="mt20">--%>
						<%--<input type="text" placeholder="邀请码" class="lg_input03 lg_input">--%>
						<%--</p>--%>
						<p class="pt10"><a href="#">使用条款</a>&nbsp;&nbsp;<a href="#">隐私条款</a></p>
						<p class="mt20">
							<%--<a href="${ctx}/user/login" class="lg_btn">立即注册</a>--%>
							<input type="submit" name="立即注册" id="submit" class="lg_btn">

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