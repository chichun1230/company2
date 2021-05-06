<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5" import="Dao.porderDao" import="java.util.List"
	import="Model.porder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<table width=500 align=center>
		<tr>
			<td align=center>
				<form action="../porder/querySum" method="post">
					金額:從 <input type="text" name="start" size="5"> 到 <input
						type="text" name="end" size="5"> <input type="submit"
						value="ok">

				</form>
		<tr>
			<td>
				<hr>
		<tr>
			<td>
				<%out.println("<table width=750 align=center border=1>"); %>
				<%
					porder[] P = (porder[]) session.getAttribute("P");

				if (P == null) {
					List<Object> l = new porderDao().queryAll();
					P = l.toArray(new porder[l.size()]);
				}

				for (porder o : P) {
					out.println("<tr><td>id:" + o.getId() + 
							"<td>名稱:" + o.getName() + 
							"<td>p1:" + o.getProduct1() +
							"<td>p2:" + o.getProduct2() +
							"<td>p3:" + o.getProduct3() +
							"<td>總額:" + o.getSum() +
							"<td>折扣:" + o.getDiscountprice() +
							"<td>日期:" + o.getDate());
					session.removeAttribute("P");
				}
				%>
				
				<%out.println("</table>"); %>
			
	</table>
</body>
</html>