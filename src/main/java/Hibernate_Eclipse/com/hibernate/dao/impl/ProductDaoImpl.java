package Hibernate_Eclipse.com.hibernate.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import Hibernate_Eclipse.com.hibernate.dao.ProductDao;
import Hibernate_Eclipse.com.hibernate.model.ProductTable;

/**
 * @author Admin
 *
 */


public class ProductDaoImpl implements ProductDao{	

	private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	public ProductTable getProduct(int id) {
		return (ProductTable) sessionFactory.getCurrentSession().get(ProductTable.class, id);
	}

	public void addProduct(ProductTable product) {
		sessionFactory.getCurrentSession().save(product);
	}

	public void removeProduct(int id) {
		sessionFactory.getCurrentSession().delete(getProduct(id));

	}

	public void editProduct(ProductTable product) {
		sessionFactory.getCurrentSession().update(product);		
	}

	public List<?> listAllProducts() {
		return sessionFactory.openSession().createQuery("from producttable").list();
	}	
}