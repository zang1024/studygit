<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/css/bootstrap.min.css">
<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/js/popper.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>

<script type="text/javascript">

	
	$(document).ready(function(){
		
		$("#chAll").click(function(){
			$(".chId").attr("checked",$(this).is(":checked"));
		});
		
		
		
		$("#btnDel").click(function(){
			
			var ids = [];
			$(".chId:checked").each(function(){
				ids.push($(this).val());
			});
			
			$.ajax({
				
				url:'/del',
				data:{ids:ids},
				type:'post',
				dataType:'json',
				traditional:true,
				success:function(data){
					
					if(data.code==1){
						window.location.href="/list";
					}else{
						alert(data.msg);
					}
					
					
				}
				
				
			});
			
		});
		
	});
</script>

</head>
<body>


<form action="/list" method="post">
	<input type="text" style="width:160px" name="sname" value="${student.sname!''}"  placeholder="姓名">
	<button type="submit" class="btn btn-primary">查询</button>
	<button type="button" class="btn btn-danger" id="btnDel">删除</button>
</form>
<table class="table table-dark">

	<tr>
		<th><input type="checkbox" id="chAll"/></th>
		<th>编号</th>
		<th>姓名</th>
		<th>入学日期</th>
		<th>操作</th>
	</tr>
	
	<#list page.list as s>
	<tr>
		<td><input type="checkbox" class="chId" value="${s.sid}"/></td>
		<td>${s.sid}</td>
		<td>${s.sname}</td>
		<td>${s.stime?string('yyyy-MM-dd')}</td>
		<td><a href="/edit?sid=${s.sid}"/>修改</a> </td>
	</tr>
	
	</#list>
</table>

<#include "page.ftl"/>
</body>
</html>