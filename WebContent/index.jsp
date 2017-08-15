<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css"/>
  <script type="text/javascript" src="bootstrap/jquery-3.2.1.min.js"></script>
   <script type="text/javascript" src="bootstrap/Validform_v5.3.2_min.js"></script>
 	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
 	<script type="text/javascript">
 		$(function(){
 			$("#searchForm").Validform({
 				btnSubmit:"#btn_sub", 	
 				postonce:true,
 				ajaxPost:true,
 				callback:function(data){
 					$.each(data,function(index,object){
 						var  tag= "<tr><td><a href="+object+">"+object+"</tr></td></a >";
 						$("#hrefTable tbody").append(tag);
 					})
 				
 				}
 			});

 		})
 	</script>
<title>种子爬虫</title>
</head>
<body style="background-image:url(bootstrap/img/back.png); ">
	<div style="margin: 100px auto; width:70%;height:700px;border:0px">
	    <div style="width: 49%; height: 100%; background-color:#ffffff;float: left;">
		     <div class="panel-body">
				    <form id="searchForm" action="search/scrapt">
						  <div class="form-group">
						    <label for="exampleInputEmail1">关键字.你懂的</label>
						    <input type="text" name="scraptKey" class="form-control" id="scrapt" >
						  </div>
						  <button id="btn_sub" type="submit" class="btn btn-default btn-block">爬取数据</button>
					</form>
				</div>
	   </div>
	    <div style="width: 49%; height: 100%; ; background-color:#ffffff;float: right;">
	    	<table class="table table-bordered" id="hrefTable">
	    		<tbody>
	    		</tbody>
	    	
	    	</table>
	    </div>
	</div>
</body>
</html>