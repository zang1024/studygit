<script type="text/javascript">

function pageUtil(pageNum){
	
	var form = document.forms[0];
	form.action= form.action+"?pageNum="+pageNum;
	form.submit();
	
}
</script>
 <ul class="pagination">
 	<#if page.hasPreviousPage>
 		 <li class="page-item">
	      <a class="page-link" href="javascript:pageUtil(${page.prePage})" tabindex="-1">上一页</a>
	    </li>
	<#else>
		 <li class="page-item disabled">
	      <a class="page-link" href="#" tabindex="-1">上一页</a>
	     </li>
 	</#if>
    
    <#list page.navigatepageNums as p>
    	
    	<#if page.pageNum=p>
	 		<li class="page-item active"><a class="page-link" href="javascript:pageUtil(${p})">${p}</a></li>
		<#else>
			<li class="page-item"><a class="page-link" href="javascript:pageUtil(${p})">${p}</a></li>
	 	</#if>
    </#list>
   
    <#if page.hasNextPage>
 		 <li class="page-item">
	      <a class="page-link" href="javascript:pageUtil(${page.nextPage})" tabindex="-1">下一页</a>
	    </li>
	<#else>
		 <li class="page-item disabled">
	      <a class="page-link" href="#" tabindex="-1">下一页</a>
	     </li>
 	</#if>
  </ul>