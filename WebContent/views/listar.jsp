<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listar Productos</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  </head>
  <body>
  	<div class="container">
  		<div class="col-md-10 mx-auto">
  			<h1 class="text-center my-5">Listar Productos</h1>
  			<table class="table table-hover">
  				<thead>
    				<tr>
      					<th>Id</th>
      					<th>Nombre</th>
      					<th>Cantidad</th>
      					<th>Precio</th>
      					<th>Fecha Creación</th>
      					<th>Fecha Actualización</th>
      					<th>Acción</th>
    				</tr>
  				</thead>
  				<tbody>
  					<c:forEach var="product" items="${list}">
    					<tr>
    						<th scope="row"><c:out value="${product.id }"></c:out></th>
    						<td><c:out value="${product.name }"></c:out></td>
    						<td><c:out value="${product.stock }"></c:out></td>
    						<td><c:out value="${product.price }"></c:out></td>
    						<td><c:out value="${product.date_create }"></c:out></td>
    						<td><c:out value="${product.date_update }"></c:out></td>
    						<td class="text-center">
    							<a href="products?opcion=meditar&id=<c:out value="${product.id }"></c:out>"><i class="far fa-edit" style="color:#4799eb"></i></a>
    							<a href="products?opcion=eliminar&id=<c:out value="${product.id }"></c:out>"><i class="far fa-trash-alt" style="color:#c54040"></i></a>
    						</td>
    					</tr>
    				</c:forEach>
  				</tbody>
			</table>
  		</div>
  	</div>
  </body>
</html>