package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
	Faker faker;
	User userPayload;
	public Logger logger;
	@BeforeClass
	public void setup()
	{
		
		faker = new Faker();
		userPayload = new User();
		
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger=LogManager.getLogger(this.getClass());
		//logger.debug("debbugging");
		
	}
	  
	@Test(priority=1)
	public void testPostUser() {
		
		logger.info("********************Creating User*********************");
		Response response =UserEndPoints2.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("********************User is Created *********************");
	
	}
	
	@Test(priority=2)
	public void testGetUserByName() {
		
		logger.info("********************Getting User Info*********************");
		Response response =UserEndPoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("********************User info is displayed  *********************");
		
	}
	
	@Test(priority=3)
	public void testUpdateUserByName() {
		//update data using payload
		logger.info("********************Updating User*********************");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		logger.info("********************User is updated*********************");
		
		
		Response response =UserEndPoints2.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//checking data after updating 
		logger.info("********************Getting Updated User Info*********************");
		Response responseAfterUpdate =UserEndPoints.readUser(this.userPayload.getUsername());
		//responseAfterUpdate.then().log().all();
		//responseAfterUpdate.then().log().body().statusCode(200);
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		logger.info("******************** Updated User Info is Displayed*********************");
	}
	
	@Test(priority=4)
	public void testDeleteUserByName() {
		logger.info("********************Deleting User*********************");
		Response response =UserEndPoints2.deleteUser(this.userPayload.getUsername());
		//response.then().log().all();
	    Assert.assertEquals(response.getStatusCode(),405);
	    logger.info("********************User is Deleted*********************");
	}

	}

