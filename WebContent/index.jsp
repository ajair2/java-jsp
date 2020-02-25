<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Menú de Opciones</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>

<body>
	<div class="container">
		<div class="col-md-6  mx-auto">
			<h1 class="text-center my-5">Menú de Opciones</h1>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>Producto</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td><a href="products?opcion=crear">Crear</a></td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td><a href="products?opcion=listar">Listar</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>

</html>