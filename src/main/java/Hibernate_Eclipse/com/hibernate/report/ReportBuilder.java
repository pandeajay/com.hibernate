package Hibernate_Eclipse.com.hibernate.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javassist.bytecode.Descriptor.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import Hibernate_Eclipse.com.hibernate.dao.impl.ProductDaoImpl;
import Hibernate_Eclipse.com.hibernate.dao.impl.SalesEntryDaoImpl;
import Hibernate_Eclipse.com.hibernate.model.Product;
import Hibernate_Eclipse.com.hibernate.model.SalesEntry;


public class ReportBuilder {
	
	String newLine = System.getProperty("line.separator");
	
	
	Map<String, AmountAndUnits> salesSummary ;
	Map<Integer, String> products ;
	
	public ReportBuilder(){
		salesSummary = new HashMap<String, AmountAndUnits>();
		products = new HashMap<Integer,String>();
	}
	
	public Map<String, AmountAndUnits> buildReport(){		
		
		ApplicationContext ctx = new FileSystemXmlApplicationContext("F:\\sample6\\com.hibernate\\spring.xml");
	//	ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:/**/spring.xml");
		SalesEntryDaoImpl salesDao = (SalesEntryDaoImpl) ctx.getBean(SalesEntryDaoImpl.class);	
		ProductDaoImpl productDao = (ProductDaoImpl) ctx.getBean(ProductDaoImpl.class);	
	
		List<SalesEntry> salesList = (List<SalesEntry>) salesDao.listAllSalesEntry();		
		List<Product> productList = (List<Product>) productDao.listAllProducts();
		
		for(Product prod : productList){
			products.put(prod.getProductId(), prod.getProductName());
		}
		
		for(SalesEntry salesItem : salesList){
			if(salesSummary.containsKey(products.get(salesItem.getProductId()))){
				AmountAndUnits amountUnits = salesSummary.get(products.get(salesItem.getProductId()));
				amountUnits.setAmount(amountUnits.getAmount() + salesItem.getSalesAmount());
				amountUnits.setUnits(amountUnits.getUnits()+ salesItem.getUnits());
				salesSummary.put(products.get(salesItem.getProductId()), amountUnits);
				
			}else{
				salesSummary.put(products.get(salesItem.getProductId()), new AmountAndUnits(salesItem.getSalesAmount(),salesItem.getUnits()));
			}		
		}
		
		System.out.println("Sales Summary :");		
		System.out.println("ProductName" +"\t\t"+"TotalAmount"+"\t\t"+"UnitsSold");		
		java.util.Iterator<Entry<String, AmountAndUnits>> it = salesSummary.entrySet().iterator();
		
		while(it.hasNext()){
			Entry<String, AmountAndUnits> entry = it.next();
			System.out.println(entry.getKey() + "\t\t"  + entry.getValue().getAmount() + "\t\t" + entry.getValue().getUnits());
		}
			
		return salesSummary;
		
	}
	
	public static void main(String[] args){
		ReportBuilder reportBuilder = new ReportBuilder();
		reportBuilder.buildReport();
	}
	
	public static class AmountAndUnits{
		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public int getUnits() {
			return units;
		}

		public void setUnits(int units) {
			this.units = units;
		}

		double amount ;
		int units;
		
		public AmountAndUnits(double amount, int units){
			this.amount = amount;
			this.units = units;
		}
		
	}

}
