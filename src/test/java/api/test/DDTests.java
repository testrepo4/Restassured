package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	Logger logger=LogManager.getLogger(this.getClass());
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String UserID, String userName, String fname,String lname,String useremail,String pwd, String ph) 	
	{	

		User userPayload = new User();
		userPayload.setId(Integer.parseInt(UserID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		logger.info("******************Creating Users Using Data Driven Testing******************");
		Response response =UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("********************** Users Created Successfully*************************");
	}
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String userName) {
		
		logger.info("******************Deleting Users Using Data Driven Testing******************");
		Response response =UserEndPoints.deleteUser(userName);
	    Assert.assertEquals(response.getStatusCode(),405);
	    logger.info("****************** Users Deleted Using Data Driven Testing******************");
	}
		
	}


