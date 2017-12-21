<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>害虫列表</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<form id="queryForm" action="pest/list" method="post">
  		<%--当前页 --%>
  		<input type="hidden" id="currentPage" name="currentPage" value="${pageBean.currentPage }"/>
  		<%--每页显示记录数 --%>
  		<input type="hidden" id="pageSizeId" name="pageSize" value="${pageBean.pageSize }"/>
  		<input type="hidden" id="pestId" name="pestId" />
  		<table align="center" border="1" width="800px">
  			<tr>
  				<td>  
  				名称： <input type="text" name="name" value="${param.name }"/>
  				类别：
  				<select name="category">
  					<option value="0">不选</option>
  					<c:forEach items="${pageBean.categoryList }" var="category">
  					<option value="${category }"
  						<c:if test="${param.category==category }">selected="selected"</c:if>>
  						${category }
  					</option>
  					</c:forEach>
  				</select>
  			 	科目：
  				<select name="family">
  					<option value="0">不选</option>
  					<c:forEach items="${pageBean.familyList}" var="family">	
  						<option value="${family }" 
  							<c:if test="${param.family==family }">selected="selected"</c:if>>
  							${family }
  						</option>
  					</c:forEach>
  				</select>
  				
  				<input type="submit" value="搜索"/>
   				</td>
			</tr>
  		</table>
  	</form>
  	
	<table border="1" align="center" width="80%">
		<tr>
			<th width="10%">编号</th>
			<th width="20%">名称</th>
			<th width="10%">科目</th>
			<th width="10%">类别</th>
		</tr>
		<c:forEach items="${pageBean.data }" var="pest">
			<tr align="center">
				<td>${pest.id }</td>
				<td><a style="text-decoration: none;" 
					href="pest/detail?pestId=${pest.id}">
					${pest.name }</a>
				</td>
				<td>${pest.family }</td>
				<td>${pest.category }</td>
			</tr>
		</c:forEach>
		<tr>
			<td align="center" colspan="4">
				<c:choose>
					<c:when test="${pageBean.currentPage==pageBean.firstPage}">
    	 	 		首页&nbsp;
    	 	 		上一页
    	 	 		</c:when>
					<c:otherwise>
						<a href="javascript:void(0)"
							onclick="toPage(${pageBean.firstPage})">首页</a>&nbsp;
    	 			<a href="javascript:void(0)"
							onclick="toPage(${pageBean.prePage})">上一页</a>&nbsp;
    	 	 		</c:otherwise>
				</c:choose>
				
				<c:choose>
    	 	 		<c:when test="${pageBean.currentPage==pageBean.totalPage}">
    	 	 			下一页&nbsp;
    	 	 			末页
    	 	 		</c:when>
    	 	 		<c:otherwise>
    	 	 		<a href="javascript:void(0)" onclick="toPage(${pageBean.nextPage})">下一页</a>&nbsp;
    	 			<a href="javascript:void(0)" onclick="toPage(${pageBean.totalPage})">末页</a>&nbsp;
    	 	 		</c:otherwise>
    	 	 	</c:choose>
    	 	 	
    	 	 	当前为第${pageBean.currentPage }页/共${pageBean.totalPage }页&nbsp;
    	 		共${pageBean.totalCount }条数据&nbsp;
    	 		每页显示 <input type="text" size="2" id="pageSize" value="${pageBean.pageSize }" onblur="changePageSize()"/> 条&nbsp;
    	 		跳转到第<input type="text" id="curPage" size="2" onblur="changePage()"/>页
    	 		
			</td>
		</tr>
	</table>
		
	</form>
</body>

<script type="text/javascript">
  	/*改变每页显示记录数*/
  	function changePageSize(){
  		//1.得到用户输入
  		var pageSize = document.getElementById("pageSize").value;
  		//判断规则：只能输入1-2个的数字
  		if(pageSize == null||pageSize=="") return;
  		var reg = /^[1-9][0-9]?$/;
  		if(!reg.test(pageSize)){
  			alert("只能输入1-2位的数字");
  			return;
  		}
  		
  		//var url = "${pageContext.request.contextPath}/ListPestServlet?currentPage=${pageBean.currentPage}&pageSize="+pageSize;
  		//window.location.href=url;
  		
  		//2.
  		//提交表单,同时发送参数(pageSize)
  		document.getElementById("pageSizeId").value=pageSize;
  		var queryForm = document.getElementById("queryForm");
  		queryForm.submit();//提交表单
  	}
  	
  	/*跳转页面*/
  	function changePage(){
  		var curPage = document.getElementById("curPage").value;
  		if(curPage ==null||curPage=="") return;
  		var reg = /^[1-9][0-9]?$/;
  		if(!reg.test(curPage)){
  			alert("只能输入1-2位的数字");
  			return;
  		}
  		/*如果输入的页码大于等于总页数*/
  		var totalPage = "${pageBean.totalPage}";
  		if(parseInt(curPage)>parseInt(totalPage)){
  			alert("已经超过总页数");
  			return;
  		}
  		
  		
  		//var url = "${pageContext.request.contextPath}/ListPestServlet?currentPage="+curPage+"&pageSize=${pageBean.pageSize}";
  		//window.location.href=url;
  		
  		//提交表单
  		document.getElementById("currentPage").value=curPage;
  		var queryForm = document.getElementById("queryForm");
  		queryForm.submit();//提交表单
  		
  	}
  	
  	//提交查询表单
  	function toPage(pageNo){
  		//提交之前，把当前页设置跳转到页码
  		document.getElementById("currentPage").value = pageNo;
  		//提交表单
  		var queryForm = document.getElementById("queryForm");
  		queryForm.submit();//提交表单
  		
  		/*var url = "${pageContext.request.contextPath}/ListPestServlet?currentPage="+pageNo+"&pageSize=${pageBean.pageSize}";
  		window.location.href = url;*/
  	}
  	
  	
</script>
</html>
