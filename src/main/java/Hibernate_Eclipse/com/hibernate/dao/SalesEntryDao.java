package Hibernate_Eclipse.com.hibernate.dao;

import java.util.List;

import Hibernate_Eclipse.com.hibernate.model.SalesEntry;



public interface SalesEntryDao {	
	public SalesEntry getSalesEntry(int salesId);
	public void addSalesEntry(SalesEntry salesEntry);
	public void removeSalesEntry(int salesId);
	public void editSalesEntry(SalesEntry salesEntry);
	public List listAllSalesEntry();
}
