<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Editar Producto</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  </head>
  <body>
    <div class="container">
    	<div class="col-md-6  mx-auto">
    		<h1>Editar Producto</h1>
    		<form action="products" method="post">
    			<c:set var="product" value="${product }"></c:set>
    			<input name="opcion" type="hidden" class="form-control" value="editar">
    			<input name="id" type="hidden" class="form-control" value="${product.id }">
    			<div class="input-group my-2">
  					<div class="input-group-prepend">
    					<span class="input-group-text">Nombre:</span>
  					</div>
  					<input name="name" type="text" class="form-control" value="${product.name }">
				</div>
				<div class="input-group mb-2">
  					<div class="input-group-prepend">
    					<span class="input-group-text">Cantidad:</span>
  					</div>
  					<input name="stock" type="text" class="form-control" value="${product.stock }">
				</div>
				<div class="input-group mb-2">
  					<div class="input-group-prepend">
    					<span class="input-group-text">Precio:</span>
  					</div>
  					<input name="price" type="text" class="form-control" value="${product.price }">
				</div>

    			<input type="submit" value="Guardar" class="btn btn-primary">
    		</form>
    	</div>
    </div> 
  </body>
</html>