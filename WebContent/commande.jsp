<%@page import="ma.ensias.bookshop.persistance.Commande"%>
<%@page import="java.util.List"%>
<%@page import="ma.ensias.bookshop.persistance.Article"%>
<%@page import="java.util.Collection"%>
<%
	List<Commande> list = (List<Commande>) request.getSession().getAttribute("Commandes");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>shoppingCart</title>
</head>
<body>
<nav>
<h1>Commande</h1>
	<table border="1">
		<tr>
			<th>numero Commande</th>
			<th>LC size</th>
			
		</tr>
		<%
			for (Commande com : list) {
		%>
		<tr>
			<td><%=com.getNumeroCommande()%></td>
			<td><%=com.getLigneCommande().size()%></td>
		</tr>
		<%} %>
	</table>
</nav>
</body>
</html>