package api.endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;

import java.util.Locale;
import java.util.ResourceBundle;

import api.payload.User;

//Created for perform CRUD operations (Create, Read,Update and Delete requests for user API)

public class UserEndPoints2 {
	
	//additional method created for getting urls in properties file
	public static ResourceBundle  getURL()
	
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");//load properties file	
		return routes;
		
	}

	
	public static Response createUser(User payload) {
		
		String post_url=getURL().getString("post_url");
		RestAssured.useRelaxedHTTPSValidation();
		Response res =given()
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON)
		      .body(payload)		
		.when()
		      .post(post_url);
		return res;
			
	}
	
	
	public static Response  readUser(String userName) 
	{
		String get_url =getURL().getString("get_url");
		RestAssured.useRelaxedHTTPSValidation();
		Response res =given()
		      .pathParam("username", userName)
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON)
		
		.when()
		      .get(get_url);
		return res;	
	}
	
	public static Response updateUser(String userName, User payload) 
	
	{
		String update_url=getURL().getString("update_url");
		RestAssured.useRelaxedHTTPSValidation();
		Response res =given()
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON)
		      .body(payload)
		      .pathParam("username", userName)
			
		.when()
		      .put(update_url);
		return res;
		
	}

  public static Response deleteUser(String userName) 
  
  {
	  String delete_url =getURL().getString("delete_url");
	  RestAssured.useRelaxedHTTPSValidation();
	 Response res = given()
	        .pathParam("username", userName)
	  
	  .when()
	        .delete(delete_url);
	  
	  return res;
	  
  }	  

}
