package threescale.v3.api.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import threescale.v3.api.HttpResponse;
import threescale.v3.api.ServerAccessor;
import threescale.v3.api.ServerError;

/**
 * Unit Test class for the Service Api.
 */

public class ServiceAccessorDriverTest {
	private static String expectedMvenVersion="3.1.0";
	
	private ServerAccessorDriver underTest = new ServerAccessorDriver();;

		
    @Before
    public void setup() {
        
    }

    @Test
    public void testClientHeader() {
    	String actualClientHeader = underTest.getPluginHeaderValue();
    	String expectedHedaer = ServerAccessor.X_3SCALE_USER_CLIENT_HEADER_JAVA_PLUGIN+expectedMvenVersion;
    	assertEquals(actualClientHeader, expectedHedaer);
    }

    //@Test
    public void testGet() throws ServerError {
    	String testUrl = "http://requestb.in/1k27m9c1"; //inspect the headers at http://requestb.in/1k27m9c1?inspect
    	
    	HttpResponse response = underTest.get(testUrl);
    	int status = response.getStatus();
    	assertEquals(status, 200);
    }

    //@Test
    public void testPost() throws ServerError {		
    	String testUrl = "http://requestb.in/1k27m9c1"; //inspect the headers at http://requestb.in/1k27m9c1?inspect
    	
    	HttpResponse response = underTest.post(testUrl, "");
    	int status = response.getStatus();
    	assertEquals(status, 200);
    }
}
