<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css"/>
  	<script type="text/javascript" src="gearSolid/js/jQuery/jquery-3.2.1.min.js"></script>
 	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<title>种子功能主页面</title>
</head>
<style>
	.function{
		height:250px;
		border:1px solid #DDDDDD;
		padding:2px;
		text-align:center
	}
	.up{
		height:33%;
		line-height:90px;
		background-color: #6F5499;
		color:white;
	}
	.head{
		height:250px;
		background-color: #2C8EBB
	}
</style>
<body>
		<div class="container-fluid head" >
		
		</div>
		<div class="container" style="width:750px">
			  <div class="row">
			  <!-- ------------------------------------------------------------ -->
				  <div class="col-sm-6 col-md-4 col-lg-3 ">
				  	<div class="function" >
				  		<div class="up">
				  			<span class="glyphicon glyphicon-search" style="font-size:30px"></span>
				  		</div>
						<div class="down">
							<h3>
								<a href="search/toPage/search">手动搜索</a>
							</h3>
				  		</div>
				  	</div>
		 		 </div>
		 		   <!-- ------------------------------------------------------------ -->
				  <div class="col-sm-6 col-md-4 col-lg-3 ">
				 	<div class="function" >
				  		<div class="up">
				  			<span class="glyphicon glyphicon-download-alt" style="font-size:30px"></span>
				  		</div>
						<div class="down">
							<h3>
								<a href="search/toPage/show" target	="_blank">种子查看</a>
							</h3>
				  		</div>
				  	</div>
				  </div>
				    <!-- ------------------------------------------------------------ -->
				  <div class="col-sm-6 col-md-4 col-lg-3 ">
				 	<div class="function" >
				  		<div class="up">
				  			<span class="glyphicon glyphicon-download-alt" style="font-size:30px"></span>
				  		</div>
						<div class="down">
							<h3>
								<a href="search/toPage/show" target	="_blank">关键词查看</a>
							</h3>
				  		</div>
				  	</div>
				  </div>
				    <!-- ------------------------------------------------------------ -->
				    <div class="col-sm-6 col-md-4 col-lg-3 ">
				 	<div class="function" >
				  		<div class="up">
				  			<span class="glyphicon glyphicon-download-alt" style="font-size:30px"></span>
				  		</div>
						<div class="down">
							<h3>
								<a href="search/toPage/keyWordSearch" target	="_blank">关键字搜索</a>
							</h3>
				  		</div>
				  	</div>
				  </div>
				    <!-- ------------------------------------------------------------ -->
				</div>
		</div>
</body>
</html>