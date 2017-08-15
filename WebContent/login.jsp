<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:set var="ctx" value="${pageContext.request.contextPath}" />

 <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css"/>
  <link rel="stylesheet" type="text/css" href="gearSolid/js/validForm/style.css"/>
 <link rel="stylesheet" type="text/css" href="gearSolid/css/login.css"/>
 
 <script type="text/javascript" src="gearSolid/js/jQuery/jquery-3.2.1.min.js"></script> 
 <script type="text/javascript" src="gearSolid/js/validForm/Validform_v5.3.2_min.js"></script>
  <script type="text/javascript" src="SSM/js/login.js"></script>
<title>登录</title>
</head>
<body style="background-image:url(bootstrap/img/laysha.png); ">
<div class="login_content_background">
</div>
<div class="login_content_face">
		<form id="loginForm" action="${ctx}/Login/loginValid" method="post">
			  <div class="form-group">
				    <label for="Name">用户名&emsp;<(▰˘◡˘▰)></label>
				    <input type="text" class="form-control" id="Name" name="name" placeholder="Name" datatype="*"  nullmsg="用户名不能不填" >
			  </div>
			  <div class="form-group">
				    <label for="exampleInputPassword1">密码&emsp;( ・◇・)？</label>
				    <input type="password" class="form-control" id="Password"  name="password" placeholder="Password" datatype="n" nullmsg=密码必须填写"">
			  </div>
			  <button type="submit" class="btn btn-default  btn-block">登&emsp;&emsp;录</button>
		</form>
</div>
</body>
</html>