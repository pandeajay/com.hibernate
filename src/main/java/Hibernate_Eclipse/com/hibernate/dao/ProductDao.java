package Hibernate_Eclipse.com.hibernate.dao;

import java.util.List;

import Hibernate_Eclipse.com.hibernate.model.Product;

public interface ProductDao {
	public Product getProduct(int id);
	public void addProduct(Product product);
	public void removeProduct(int id);
	public void editProduct(Product product);
	public List listAllProducts();
}
