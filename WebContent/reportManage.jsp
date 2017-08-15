<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 
 
 	 <script type="text/javascript" src="gearSolid/js/jQuery/jquery-3.2.1.min.js"></script>
 	
 	 <!-- easyui部分 -->
 	<link rel="stylesheet" type="text/css" href="easyui1.5/themes/metro/easyui.css"/>
	<script type="text/javascript" src="easyui1.5/locale/easyui-lang-zh_CN.js"></script>
 	<script type="text/javascript" src="easyui1.5/jquery.easyui.min.js"></script>
 	 
     <!-- easyui部分 -->
  	
 	<!-- bootstrap部分 -->
 		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css"/>
 	 	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
 	<!-- bootstrap部分 -->
  
<title>报告管理系统</title>
</head>
<body class="easyui-layout">
		
		<div data-options="region:'east' ,width:500">
				<c:forEach var="Type" varStatus="status0" items="${reportType}"> 
					<div class="panel panel-default">
						  <div class="panel-heading">${Type}</div>
						  <div class="panel-body">
						  	<table class="table table-hover">
						  		<thead>
								  		<tr><th>报告模板名称</th></tr>
						  		</thead>
						  		<tbody>
						  			<c:forEach var="report" varStatus="status1" items="${htmlReport}"> 
						  				<tr><td>${report.name}</td></tr>
							  		</c:forEach>			
						  		</tbody>
							  	
						  	</table>
						</div>
		 			</div>
				</c:forEach>
		</div>
		<div data-options="region:'center'">
		</div>
</body>
</html>