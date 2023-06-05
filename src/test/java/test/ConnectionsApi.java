package test;

import static io.restassured.RestAssured.given;

import java.util.Base64;

import org.testng.annotations.Test;

public class ConnectionsApi {
	
	static String Username="";
	static String Password="";
	String baseURI = ";
	
	String authString = Username + ":" + Password;
	String authCred = new String(Base64.getEncoder().encode(authString.getBytes()));
	
	
	
	@Test
	public void validateGetallconnection() {
		
		given()
		.baseUri(baseURI)
		.basePath("/api")
		.and()
		.header("authorization","Basic "+authCred)
		.when()
		.get("/connections/all")
		.then()
		.statusCode(200);	
		
	}
	
	@Test //annotations 
	public void validateGetconnectiondetails() {
		given()
		.pathParam("Connector ID", "1002")
		.baseUri(baseURI)
		.basePath("/api")
		.and()
		.header("authorization","Basic "+authCred)
		.when()
		.get("/connection/{Connector ID}")
		.then()
		.statusCode(200);
		
	}
	
	@Test
	public void validateGetconnectionparameters() {
		given()
		.queryParam("servertype", "SQLServer")
		.baseUri(baseURI)
		.basePath("/api")
		.and()
		.header("authorization","Basic "+authCred)
		.header("content-type","application/json")
		.when()
		.get("/connection/getConnectionParm")
		.then()
		.statusCode(200);	
		 
	}
	@Test
	public void validateUpdatepasswordconnectionPOST() {
		
		String Payload = "[\r\n"
				+ "  {\r\n"
				+ "    \"connectionId\": 1201,\r\n"
				+ "    \"password\": \"0valEdge!\"\r\n"
				+ "  }\r\n"
				+ "]";
		given()
		.baseUri(baseURI)
		.basePath("/api")
		.and()
		.header("authorization","Basic "+authCred)
		.header("content-type","application/json")
		.and()
		.body(Payload)
		.when()
		.post("/connection/updatePassword")
		.then()
		.statusCode(200);
	}

}
