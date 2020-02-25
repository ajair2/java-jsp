package com.olearningc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.olearningc.dao.ProductDAO;
import com.olearningc.model.Product;


@WebServlet(description = "Administra peticiones para la tabla productos", urlPatterns = { "/products" })
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		
		if (opcion.equals("crear")) {
			
			System.out.println("Usted a presionado la opción crear");
			RequestDispatcher rd = request.getRequestDispatcher("views/crear.jsp");
			rd.forward(request, response);
			
		} else if (opcion.equals("listar")) {
			
			ProductDAO productDAO = new ProductDAO();
			List<Product> list = new ArrayList<>();
			
			try {
				
				list = productDAO.obtenerProducts();
				
				for (Product product : list) {
					System.out.println(product);
				}
				
				request.setAttribute("list", list);
				
				RequestDispatcher rd = request.getRequestDispatcher("views/listar.jsp");
				rd.forward(request, response);
				
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			System.out.println("Usted a presionado la opción listar");
			
		} else if (opcion.equals("meditar")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("Editar id: " + id);
			
			ProductDAO productDAO = new ProductDAO();
			Product p = new Product();
			try {
				p = productDAO.obtenerProduct(id);
				System.out.println(p);
				request.setAttribute("product", p);
				RequestDispatcher rd = request.getRequestDispatcher("views/editar.jsp");
				rd.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} else if (opcion.equals("eliminar")) {
			
			ProductDAO productDAO = new ProductDAO();
			int id = Integer.parseInt(request.getParameter("id"));
			
			try {
				productDAO.delete(id);
				System.out.println("Registro eliminado satisfactoriamente!");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		Date fechaActual = new Date();
		
		if (opcion.equals("guardar")) {
			
			ProductDAO productDAO = new ProductDAO();
			Product product = new Product();
			product.setName(request.getParameter("name"));
			product.setStock(Double.parseDouble(request.getParameter("stock")));
			product.setPrice(Double.parseDouble(request.getParameter("price")));
			product.setDate_create(new java.sql.Date(fechaActual.getTime()));
			
			try {
				
				productDAO.save(product);
				System.out.println("Registro guardado satisfactoriamente!");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
			
		} else if (opcion.equals("editar")) {
			
			ProductDAO productDAO = new ProductDAO();
			Product product = new Product();
			
			product.setId(Integer.parseInt(request.getParameter("id")));
			product.setName(request.getParameter("name"));
			product.setStock(Double.parseDouble(request.getParameter("stock")));
			product.setPrice(Double.parseDouble(request.getParameter("price")));
			product.setDate_update(new java.sql.Date(fechaActual.getTime()));
			
			try {
				
				productDAO.edit(product);
				System.out.println("Registro editado satisfactoriamente!");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			
		}
						
	}

}
