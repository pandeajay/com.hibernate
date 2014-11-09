package Hibernate_Eclipse.com.hibernate.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import Hibernate_Eclipse.com.hibernate.dao.ProductDao;
import Hibernate_Eclipse.com.hibernate.model.Product;

/**
 * @author Admin
 *
 */


public class ProductDaoImpl implements ProductDao{	

	private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	public Product getProduct(int id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}

	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}

	public void removeProduct(int id) {
		sessionFactory.getCurrentSession().delete(getProduct(id));

	}

	public void editProduct(Product product) {
		sessionFactory.getCurrentSession().update(product);		
	}

	public List<?> listAllProducts() {
		return sessionFactory.openSession().createQuery("from Product").list();
	}	
}