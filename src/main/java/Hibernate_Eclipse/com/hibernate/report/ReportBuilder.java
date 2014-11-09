package Hibernate_Eclipse.com.hibernate.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javassist.bytecode.Descriptor.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import Hibernate_Eclipse.com.hibernate.dao.impl.ProductDaoImpl;
import Hibernate_Eclipse.com.hibernate.dao.impl.SalesEntryDaoImpl;
import Hibernate_Eclipse.com.hibernate.model.Product;
import Hibernate_Eclipse.com.hibernate.model.SalesEntry;


public class ReportBuilder {
	
	String newLine = System.getProperty("line.separator");
	
	
	Map<String, Double> salesSummary ;
	Map<Integer, String> products ;
	
	public ReportBuilder(){
		salesSummary = new HashMap<String, Double>();
		products = new HashMap<Integer,String>();
	}
	
	public Map<String, Double> buildReport(){		
		ApplicationContext ctx = new FileSystemXmlApplicationContext("F:\\sample6\\com.hibernate\\spring.xml");
		SalesEntryDaoImpl salesDao = (SalesEntryDaoImpl) ctx.getBean(SalesEntryDaoImpl.class);	
		ProductDaoImpl productDao = (ProductDaoImpl) ctx.getBean(ProductDaoImpl.class);	
	
		List<SalesEntry> salesList = (List<SalesEntry>) salesDao.listAllSalesEntry();		
		List<Product> productList = (List<Product>) productDao.listAllProducts();
		
		for(Product prod : productList){
			products.put(prod.getProductId(), prod.getProductName());
		}
		
		for(SalesEntry salesItem : salesList){
			if(salesSummary.containsKey(products.get(salesItem.getProductId()))){
				double amount = salesSummary.get(products.get(salesItem.getProductId()));
				salesSummary.put(products.get(salesItem.getProductId()), amount + salesItem.getSalesAmount());
				
			}else{
				salesSummary.put(products.get(salesItem.getProductId()), salesItem.getSalesAmount());
			}		
		}
		
		System.out.println("Sales Summary :");
	//	System.out.println(newLine);
		
		System.out.println("ProductName		TotalAmount");
		//System.out.println(newLine);
		
		java.util.Iterator<Entry<String, Double>> it = salesSummary.entrySet().iterator();
		
		while(it.hasNext()){
			Entry<String, Double> entry = it.next();
			System.out.println(entry.getKey() + "		" + entry.getValue());
			//System.out.println(newLine);		
		}
			
		return salesSummary;
		
	}
	
	public static void main(String[] args){
		ReportBuilder reportBuilder = new ReportBuilder();
		reportBuilder.buildReport();
	}

}
