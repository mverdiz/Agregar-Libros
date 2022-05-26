<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!-- 	import="net.miguel.uf1845.modelos.*" -->
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>
	<h1>Principal</h1>

	<table class="table table-sm table-hover table-striped table-bordered">
		<thead>
			<tr>
				<th>Id</th>
				<th>Título</th>
				<th>Precio</th>
				<th>Descuento</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${libros}" var="libro">
				<tr>
					<th>${libro.id}</th>
					<td>${libro.titulo}</td>
					<td>${libro.precio}</td>
					<td>${libro.descuento}</td>
				</tr>
			</c:forEach>

			<%-- 		<% for(Libro libro: (Iterable<Libro>)request.getAttribute("libros")) { %> --%>

			<%-- 			<th><%=libro.getId() %></th> --%>
			<%-- 			<td><%=libro.getTitulo() %></td> --%>
			<%-- 			<td><%=libro.getAutor() %></td> --%>
			<%-- 			<td><%=libro.getIsbn() %></td> --%>
			<%-- 			<td><%=libro.getPrecio() %></td> --%>

			<%-- 		<% } %> --%>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td>
					<a class="btn btn-primary" href="admin/formulario">Añadir</a>
				</td>
				<td></td>
				<td></td>
			</tr>
		</tfoot>
	</table>
	
	<script>
		$(function () {
		    $('table').DataTable();
		} );
	</script>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>