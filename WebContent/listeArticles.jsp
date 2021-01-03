<%@page import="ma.ensias.bookshop.persistance.Article"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collection"%>
<%
	List<Article> list = (List<Article>) request.getSession().getAttribute("listeArticles");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booky Shop Web</title>
</head>
<body>
<h1>listeArticles</h1>
	<table border="1">
		<tr>
			<th>numeroArticle</th>
			<th>libelle</th>
			<th>prix</th>
			<th>Action</th>
		</tr>
		<%
			for (Article art : list) {
		%>
		<tr>
			<td><%=art.getNumeroArticle()%></td>
			<td><%=art.getLibelle()%></td>
			<td><%=art.getPrix()%></td>
			<td><a href="/bookyShopWeb/ListeArticlesServlets?action=delete&id=<%=art.getNumeroArticle()%>">delete</a></td>
		</tr>
		<%} %>
	</table>
	<br>
	<form action="/bookyShopWeb/ListeArticlesServlets" method="post">
	<table>
	<tr><td>Libelle</td><td><input type="text" name="libelle"></td></tr>
	<tr><td>Prix</td><td><input type="text" name="prix"/></td></tr>
	<tr><td><input type="submit"  value="Ajouter"/></td></tr>
	</table>
	</form>

</body>
</html>