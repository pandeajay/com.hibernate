package Hibernate_Eclipse.com.hibernate;

import java.util.Map;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import Hibernate_Eclipse.com.hibernate.dao.impl.ProductDaoImpl;
import Hibernate_Eclipse.com.hibernate.model.Product;
import Hibernate_Eclipse.com.hibernate.report.ReportBuilder;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */




/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("spring.xml")
@TransactionConfiguration
@Transactional */
public class AppTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	
	ApplicationContext ac;	
	ProductDaoImpl productdao ;	
	int numOfProducts  = 10;
	
	@Before
	public void setUp()
	{
		ac = new FileSystemXmlApplicationContext("E:\\media\\com.hibernate\\spring.xml");
		assertNotNull(ac);
		productdao = (ProductDaoImpl) ac.getBean(ProductDaoImpl.class);
		assertNotNull(productdao);
		productdao.deleteAllProducts();	
		addProducts();
	}
	
	public void addProducts(){
		for(int i = 0 ; i < numOfProducts; i++){
			Product prod = new Product();
			//prod.setProductId(i);
			prod.setProductName("Product"+i);
			productdao.addProduct(prod);
		}
	}
	
	
	public AppTest(){
		super( "AppTest" );
	}
	
	
	/* private ReportBuilder reportBuilder;
	
	@Autowired
	ProductDaoImpl productdao; */	


    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }


    public void testApp()
    {
		//ReportBuilder reportBuilder = new ReportBuilder();
		//Map map = reportBuilder.buildReport();
       // assertTrue( map.size() > 0 );   	
    	System.out.println("productdao.listAllProducts().size()===" + productdao.listAllProducts().size());
    	assertTrue(productdao.listAllProducts().size() == numOfProducts );
    }
}
