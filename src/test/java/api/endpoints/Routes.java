package api.endpoints;

import io.restassured.RestAssured;

/*
 Swagger URI----> https://petstore.swagger.io
  Create user(Post):https://petstore.swagger.io/v2/user
  Get User(Get):https://petstore.swagger.io/v2/user/user/{username}
  Update User(Put):https://petstore.swagger.io/v2/user/{username}
  Delete User(Delete):https://petstore.swagger.io/v2/user/{username} 
 */

public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User Module 
	
	public static String post_url = base_url+"/user";
	public static String get_url =base_url+"/user/{username}";
	public static String update_url= base_url+"/user/{username}"; 
	public static String delete_url =base_url+"user/{username}";
	

}
