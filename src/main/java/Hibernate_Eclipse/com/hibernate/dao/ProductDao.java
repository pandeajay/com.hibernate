package Hibernate_Eclipse.com.hibernate.dao;

import java.util.List;

import Hibernate_Eclipse.com.hibernate.model.ProductTable;

public interface ProductDao {
	public ProductTable getProduct(int id);
	public void addProduct(ProductTable product);
	public void removeProduct(int id);
	public void editProduct(ProductTable product);
	public List listAllProducts();
}
