<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Crear Producto</title>
  </head>
  <body>
    
    <div class="container">
    	<div class="col-md-6  mx-auto">
    		<h1 class="text-center">Crear Producto</h1>
    		<form action="products" method="post">
    			<input name="opcion" type="hidden" class="form-control" value="guardar">
    			<div class="input-group my-2">
  					<div class="input-group-prepend">
    					<span class="input-group-text">Nombre:</span>
  					</div>
  					<input name="name" type="text" class="form-control">
				</div>
				<div class="input-group mb-2">
  					<div class="input-group-prepend">
    					<span class="input-group-text">Cantidad:</span>
  					</div>
  					<input name="stock" type="text" class="form-control">
				</div>
				<div class="input-group mb-2">
  					<div class="input-group-prepend">
    					<span class="input-group-text">Precio:</span>
  					</div>
  					<input name="price" type="text" class="form-control">
				</div>

    			<input type="submit" value="Guardar" class="btn btn-primary">
    		</form>
    	</div>
    </div>      
  </body>
</html>