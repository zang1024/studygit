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
	$(document).ready(function() {
		var sex = "${student.ssex}";
		
		if(sex=="男"){
			$("#male").attr("checked",true);
			
		}else{
			
			$("#female").attr("checked",true);
		}
	});
</script>

</head>
<body>


	<table class="table table-dark">



		<tr>
			<td>姓名</td>
			<td><input type="text" value="${student.sname!''}"/></td>

		</tr>

		<tr>
			<td>性别</td>
			<td>
				男<input type="radio" id="male" name="ssex" value="男" />
				女<input type="radio" id="female" name="ssex" value="女"/>
			</td>

		</tr>

		
	</table>


</body>
</html>