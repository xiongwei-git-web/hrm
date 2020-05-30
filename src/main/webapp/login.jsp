<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="<%request.getContextPath();%>/css/bootstrap.min.css" />
		<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
		<script type="text/javascript" src="%request.getContextPath();%>/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="%request.getContextPath();%>/js/bootstrap.bundle.min.js"></script>
		<script src="https://kit.fontawesome.com/89ea953a05.js" crossorigin="anonymous"></script>
		<style type="text/css">
			*{padding: 0;
			margin: 0;}
			body{
				background: linear-gradient(to left,#d3959b,blue);
				width: 100%;
				height: 100%;
			}
		</style>
	</head>
	<body>
	<div class="row "  style="margin-top: 200px;">
		<div class="col-4"></div>
		<div class="col-4">
			<div class="card">
				<form action="/user/login" method="post">
				<div class="card-body "  style="">
					<h5 class="card-title" style="text-align: center;">人事管理系统</h5>
					<div class="form-group">
					   <label for="user">登入账号</label>
					   <input type="text" class="form-control" name="user" id=user placeholder="登入账号" required>
					 </div>
					 <div class="form-group">
					    <label for="pass">登入密码</label>
					    <input type="password" class="form-control" name="pass" id=pass placeholder="登入密码" required>
					 </div>
					<button type="submit" class="btn btn-primary btn-lg btn-block">登入</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	</body>
</html>
