package test;

import static io.restassured.RestAssured.*;

public class Testgerkin {
	
	static String Username="siddeswara";
	static String Password="0valEdge!1992";
	
	public static void main(String[] args) {
		System.out.println("hello world api");
		//build/compose the request
		// send the request
		//validate the response 
		
		//Rest assured follows BDD way of writing
		//Behavior driven development
		//TDD - F --> P --> 
		/*Gerkin
		 * Given I launch https://google.com
		 * When i entered keyword as a iphone
		 * And i click on search
		 * Then i should see only suggestions related to Iphone
		 * And i should see Iphone images
		 */
		
		// Employee GET Test
		
		//Given I have URI as https://oneauto.herokuapp.com
		//And I have a path as employees
		//And I have a valid oauth token "hfghijk" 
		//And I set http method to GET
		//When I click on send button
		//Then I should see 200 response status code
		// And I should see all the details under response body
		//And I should see response time less than second
		
		given()
		.baseUri("https://qa2.ovaledge.net")
		.basePath("/api/connections/all")
		.header("authorization","Basic Auth")
		.header("authorization","Username")
		.header("authorization","Password")
		.when()
		.get("/api/connections/all")
		.then()
		.statusCode(200);
		
		
	}

}
