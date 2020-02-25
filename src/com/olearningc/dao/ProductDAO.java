package com.olearningc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.olearningc.conexion.Conexion;
import com.olearningc.model.Product;

public class ProductDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private boolean estadoOperacion;
	
	// Guardar producto
	public boolean save(Product product) throws SQLException {
		
		String sql = null;
		estadoOperacion = false;
		con = obtenerConexion();
		
		try {
			con.setAutoCommit(false);
			sql = "INSERT INTO products (id, name, stock, price, date_create, date_update) VALUES(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, null);
			ps.setString(2, product.getName());
			ps.setDouble(3, product.getStock());
			ps.setDouble(4, product.getPrice());
			ps.setDate(5, product.getDate_create());
			ps.setDate(6, product.getDate_update());
			
			estadoOperacion = ps.executeUpdate() > 0;
			
			con.commit();
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			
			con.rollback();
			e.printStackTrace();
			
		}
		
		return estadoOperacion;
	}
	
	// Editar producto
	public boolean edit(Product product) throws SQLException {	
		
		String sql = null;
		estadoOperacion = false;
		con = obtenerConexion();
		
		try {
			con.setAutoCommit(false);
			sql = "UPDATE products SET name = ?, stock = ?, price = ?, date_update = ? WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setDouble(2, product.getStock());
			ps.setDouble(3, product.getPrice());
			ps.setDate(4, product.getDate_update());
			ps.setInt(5, product.getId());
			
			estadoOperacion = ps.executeUpdate() > 0;
			con.commit();
			ps.close();
			con.close();
			
			
		} catch (SQLException e) {
			con.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}
	
	// Eliminar producto
	public boolean delete(int idProduct) throws SQLException {	
		String sql = null;
		estadoOperacion = false;
		con = obtenerConexion();
		
		try {
			con.setAutoCommit(false);
			sql = "DELETE FROM products WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idProduct);
						
			
			estadoOperacion = ps.executeUpdate() > 0;
			con.commit();
			ps.close();
			con.close();
			
			
		} catch (SQLException e) {
			con.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
		
	}
	
	// Obtener todos los productos de la DB
	public List<Product> obtenerProducts() throws SQLException {	
		ResultSet rs = null;
		List<Product> listProdcuts = new ArrayList<>();
		
		String sql = null;
		estadoOperacion = false;
		con = obtenerConexion();
		
		try {
			sql = "SELECT * FROM products";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setStock(rs.getDouble(3));
				p.setPrice(rs.getDouble(4));
				p.setDate_create(rs.getDate(5));
				p.setDate_update(rs.getDate(6));
				
				listProdcuts.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		
		return listProdcuts;
	}
	
	// Obtener un producto de la DB
	public Product obtenerProduct(int idProduct) throws SQLException {		
		
		ResultSet rs = null;
		Product p = new Product();
		
		String sql = null;
		estadoOperacion = false;
		con = obtenerConexion();
		
		try {
			sql = "SELECT * FROM products WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idProduct);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {				
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setStock(rs.getDouble(3));
				p.setPrice(rs.getDouble(4));
				p.setDate_create(rs.getDate(5));
				p.setDate_update(rs.getDate(6));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		
		return p;
		
	}
	
	// Obtener conexion pool
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}

}
