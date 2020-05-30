<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="<%request.getContextPath();%>/css/bootstrap.min.css" />
		<link rel="stylesheet" href="<%request.getContextPath();%>/css/font-awesome.min.css">
		<script type="text/javascript" src="<%request.getContextPath();%>/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="<%request.getContextPath();%>/js/bootstrap.bundle.min.js"></script>
		<script src="https://kit.fontawesome.com/89ea953a05.js" crossorigin="anonymous"></script>
	</head>
	<body>
	<div class="carousel">
		<div class="row-cols-12  ">
			<nav class="navbar navbar-expand-lg navbar-light bg-primary">
				<h1 class="navbar-brand text-white" style="font-size: 30px;">人事管理系统</h1>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item ">
							<button type="button" class="btn btn-danger">权限管理</button>
						</li>
						<li class="navbar-nav mr-auto ml-5">

						</li>
					</ul>
					<form  action="/user/quit" class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2"   value="当前用户:${user.uName}" readonly />
						<a class="btn btn-danger" href="/user/quit" role="button">退出</a>
					</form>
				</div>
			</nav>
		</div>
		<div class="row">
			<div class="col-2 " >
				<div class="container">
					<div class="card" style="width: 21rem ; margin-left: -15px;">
						<div class="card-header d-flex justify-content-between bg-info " data-toggle="collapse" href="#demo1" >
							用户管理
							<i class="fa fa-arrow-circle-down fa-lg"></i>
						</div>
						<ul class="collapse list-group list-group-flush " id="demo1">
							<li class="list-group-item"><a href="/user/seleatall"  target="page">用户管理</a></li>
						</ul>
					</div>
				</div>
				<div class="container">
					<div class="card" style="width: 21rem ; margin-left: -15px;">
						<div class="card-header d-flex justify-content-between bg-info " data-toggle="collapse" href="#demo2" >
							部门管理
							<i class="fa fa-arrow-circle-down fa-lg"></i>
						</div>
						<ul class="collapse list-group list-group-flush " id="demo2">
							<li class="list-group-item"><a href="/section/selectall"  target="page">部门管理</a></li>
						</ul>
					</div>
				</div>
				<div class="container">
					<div class="card" style="width: 21rem ; margin-left: -15px;">
						<div class="card-header d-flex justify-content-between bg-info " data-toggle="collapse" href="#demo3" >
							职位管理
							<i class="fa fa-arrow-circle-down fa-lg"></i>
						</div>
						<ul class="collapse list-group list-group-flush " id="demo3">
							<li class="list-group-item"><a href="/post/selectall"  target="page">职位管理</a></li>

						</ul>
					</div>
				</div>
				<div class="container">
					<div class="card" style="width: 21rem ; margin-left: -15px;">
						<div class="card-header d-flex justify-content-between bg-info " data-toggle="collapse" href="#demo4" >
							员工管理
							<i class="fa fa-arrow-circle-down fa-lg"></i>
						</div>
						<ul class="collapse list-group list-group-flush " id="demo4">
							<li class="list-group-item"><a href="/staff/selectall" target="page">员工管理</a></li>
						</ul>
					</div>
				</div>
				<div class="container">
					<div class="card" style="width: 21rem ; margin-left: -15px;">
						<div class="card-header d-flex justify-content-between  bg-info" data-toggle="collapse" href="#demo5" >
							公告管理
							<i class="fa fa-arrow-circle-down fa-lg"></i>
						</div>
						<ul class="collapse list-group list-group-flush " id="demo5">
							<li class="list-group-item"><a href="/notice/selectall" target="page">公告管理</a></li>

						</ul>
					</div>
				</div>
				<div class="container">
					<div class="card" style="width: 21rem ; margin-left: -15px;">
						<div class="card-header d-flex justify-content-between  bg-info" data-toggle="collapse" href="#demo6" >
							下载中心
							<i class="fa fa-arrow-circle-down fa-lg"></i>
						</div>
						<ul class="collapse list-group list-group-flush " id="demo6">
							<li class="list-group-item"><a href="/files/selectall" target="page" >	下载中心</a></li>
						</ul>
					</div>
				</div>


			</div>
			<div class="col-10">
				<iframe src="/initialize.jsp" width="100%" height="900px" name="page" ></iframe>
			</div>
		</div>
	</div>
	</body>
	<script>

	</script>
</html>
