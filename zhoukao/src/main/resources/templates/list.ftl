<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/js/popper.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
</head>
<body>
<form action="/list" method="post">
	<input type="text" style="width: 160px" name="name" value="${student.name!'' }" placeholder="姓名">
	<button type="submit" >查询</button>
	<button type="button">删除</button>
</form>
<table class="table table-dark">

	<tr>
		<th>编号</th>
		<th>姓名</th>
	</tr>
	
	<#list page.list as s>
	<tr>
		<td>${s.id}</td>
		<td>${s.name}</td>
	</tr>
	
	</#list>
</table>

<#include "page.ftl"/>
</body>
</html>