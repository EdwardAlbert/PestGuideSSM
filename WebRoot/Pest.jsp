<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>害虫详情</title>

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

	<br>
	<table align="center" width="60%">
		<tr>
			<td colspan="3" align="center"><img alt=""
				src="${pageContext.request.contextPath}/assets/${pest.pictureURL }"
				style="display: inline; width: 300px;"></td>
		</tr>
		<tr>
			<td width="20%" align="center"><h3>${pest.name }</h3></td>
			<td width="20%" align="center"><h3>${pest.family }</h3></td>
			<td width="20%" align="center"><h3>${pest.category }</h3></td>
		</tr>
		<tr>
			<td colspan="3">
				<h3>形态特征：</h3> ${pest.feature }<br /> <br />
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<h3>生活习性：</h3> ${pest.habit }<br /> <br />
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<h3>主要危害：</h3> ${pest.damage }<br /> <br />
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<h3>分布状况：</h3> ${pest.distribution }<br /> <br />
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<h3>防治措施：</h3> ${pest.prevention }<br /> <br />
			</td>
		</tr>
	</table>
</body>
</html>
