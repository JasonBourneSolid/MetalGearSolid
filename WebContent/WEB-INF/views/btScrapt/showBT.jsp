<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css"/>
  <script type="text/javascript" src="bootstrap/jquery-3.2.1.min.js"></script>
   <script type="text/javascript" src="bootstrap/Validform_v5.3.2_min.js"></script>
 	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>种子展示</title>
</head>
<body>
	<div class="list-group">
		<c:forEach var="BT" items="${torrentInfo.torrents}">
			<a href="${BT.src}" class="list-group-item ">${BT.src}</a>
		</c:forEach>  
	</div>	
</body>
</html>