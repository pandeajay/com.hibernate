package Hibernate_Eclipse.com.hibernate.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import Hibernate_Eclipse.com.hibernate.dao.SalesEntryDao;
import Hibernate_Eclipse.com.hibernate.model.SalesEntry;


/**
 * @author Admin
 *
 */
public class SalesEntryDaoImpl implements SalesEntryDao {
	

	private SessionFactory sessionFactory ;
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	public SalesEntryDaoImpl(){
		//ApplicationContext ctx = new FileSystemXmlApplicationContext("F:\\sample6\\com.hibernate\\spring.xml");
		//session = (SessionFactory) ctx.getBean("SessionFactory",SessionFactory.class);
		//session =  new Configuration().configure("F:\\sample6\\com.hibernate\\hibernate.cfg.xml").buildSessionFactory();
	}

	/* (non-Javadoc)
	 * @see com.mycompany.app.dao.SalesEntryDao#getSalesEntry(int)
	 */
	
	public SalesEntry getSalesEntry(int salesId) {
		return (SalesEntry) sessionFactory.openSession().get(SalesEntry.class, salesId);
	}

	/* (non-Javadoc)
	 * @see com.mycompany.app.dao.SalesEntryDao#addSalesEntry(com.mycompany.app.model.SalesEntry)
	 */
	
	public void addSalesEntry(SalesEntry salesEntry) {
		sessionFactory.openSession().save(salesEntry);

	}

	/* (non-Javadoc)
	 * @see com.mycompany.app.dao.SalesEntryDao#removeSalesEntry(int)
	 */
	
	public void removeSalesEntry(int salesId) {
		sessionFactory.openSession().delete(getSalesEntry(salesId));

	}

	/* (non-Javadoc)
	 * @see com.mycompany.app.dao.SalesEntryDao#editSalesEntry(com.mycompany.app.model.SalesEntry)
	 */
	
	public void editSalesEntry(SalesEntry salesEntry) {
		sessionFactory.openSession().update(salesEntry);	

	}

	/* (non-Javadoc)
	 * @see com.mycompany.app.dao.SalesEntryDao#listAllSalesEntry()
	 */
	
	public List<?> listAllSalesEntry() {
		 //return sessionFactory.getCurrentSession().createQuery("from SalesEntry").list();
		return sessionFactory.openSession().createQuery("from SalesEntry").list();
	}

	public void deleteAllSalesEntry() {
		List<SalesEntry> sales = (List<SalesEntry>) listAllSalesEntry();
		for(SalesEntry sale : sales){
			sessionFactory.openSession().delete(sale);
		}		
	}	
}