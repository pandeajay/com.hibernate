package Hibernate_Eclipse.com.hibernate;

import java.util.Map;

import Hibernate_Eclipse.com.hibernate.report.ReportBuilder;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
		ReportBuilder reportBuilder = new ReportBuilder();
		Map map = reportBuilder.buildReport();
        assertTrue( map.size() > 0 );
    }
}
