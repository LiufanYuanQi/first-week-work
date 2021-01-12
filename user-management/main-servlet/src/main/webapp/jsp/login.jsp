<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<link href="../static/js/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../static/js/jquery/jquery-1.11.1-min.js"></script>
<script type="text/javascript" src="../static/js/bootstrap_3.3.0/js/bootstrap.min.js"></script>
</head>
<script>
	if(window.top!=window){
		window.top.location=window.location;
	}
	$(function () {
		$("#user").focus();
		$("#workbenchBtn").click(function () {
			$.ajax({
				data:{
					loginact: $("#loginAct").val(),
					loginpwd: $("#loginPwd").val()
				},
				type: "post",
				url: "/userLogin",
				success(data) {
					if (data.flag == true) {
						window.location.href = "workbench";
					}else {
						alert(data.message);
					}
				}
			})
		});
	});
</script>
<body>
	<div style="position: absolute; top: 0px; left: 0px; width: 60%;">
		<img src="../static/image/loginPicture.jpg" style="width: 100%; height: 90%; position: relative; top: 50px;">
	</div>

	<div style="position: absolute; top: 120px; right: 100px;width:450px;height:400px;border:1px solid #D5D5D5">
		<div style="position: absolute; top: 0px; right: 60px;">
			<div class="page-header">
				<h1>登录</h1>
			</div>

			<form action="<%--登录url--%>" class="form-horizontal" role="form">
				<div class="form-group form-group-lg">
					<div style="width: 350px;">
						<input id="loginAct" class="form-control" type="text" placeholder="用户名">
					</div>
					<div style="width: 350px; position: relative;top: 20px;">
						<input id="loginPwd" class="form-control" type="password" placeholder="密码">
					</div>
					<div class="checkbox"  style="position: relative;top: 30px; left: 10px;">
						
							<span id="msg"></span>
						
					</div>
					<button type="button" id="workbenchBtn" class="btn btn-primary btn-lg btn-block"  style="width: 350px; position: relative;top: 45px;">登录</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>