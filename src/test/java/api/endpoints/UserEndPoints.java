package api.endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;

import api.payload.User;

//Created for perform CRUD operations (Create, Read,Update and Delete requests for user API)

public class UserEndPoints {
	
	
	public static Response createUser(User payload) {
		RestAssured.useRelaxedHTTPSValidation();
		Response res =given()
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON)
		      .body(payload)		
		.when()
		      .post(Routes.post_url);
		return res;
			
	}
	
	
	public static Response  readUser(String userName) 
	{
		RestAssured.useRelaxedHTTPSValidation();
		Response res =given()
		      .pathParam("username", userName)
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON)
		
		.when()
		      .get(Routes.get_url);
		return res;	
	}
	
	public static Response updateUser(String userName, User payload) {
		RestAssured.useRelaxedHTTPSValidation();
		Response res =given()
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON)
		      .body(payload)
		      .pathParam("username", userName)
			
		.when()
		      .put(Routes.update_url);
		return res;
		
	}

  public static Response deleteUser(String userName) {
	  RestAssured.useRelaxedHTTPSValidation();
	 Response res = given()
	        .pathParam("username", userName)
	  
	  .when()
	        .delete(Routes.delete_url);
	  
	  return res;
	  
  }	  

}
