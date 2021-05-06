<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import="Dao.porderDao"
    import="java.util.List"
    import="Model.porder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<table width=750 align=center border=0>
	<tr>
		<td align=center>
		<h2>輸入刪除條件</h2>
		<form action="../porder/deleteId" method="post">
		ID:
		<input type="text" name="id" size="5" >
		
		
		<input type="submit" value="ok">
		
		</form>
	<tr>
		<td>
		<hr>
	<tr>
		<td>
		
		<% out.println("<table width=750 align=center border=1>");%>
		
		<%
		
		
			List<Object> l=new porderDao().queryAll();
			 porder[] P=l.toArray(new porder[l.size()]);
			 
	
		
		
		for(porder o:P)
		{
			out.println("<tr><td>id:"+o.getId()+
					"<td>名:"+o.getName()+
					"<td>p1:"+o.getProduct1()+
					"<td>p2:"+o.getProduct2()+
					"<td>p3:"+o.getProduct3()+
					"<td>折扣:"+o.getDiscountprice()+					
					"<td>金額:"+o.getSum()+
					"<td>日期:"+o.getDate());
		}
		
		
		
		%>
		
		<%out.println("</table>") ;%>

	

</table>
</body>
</html>