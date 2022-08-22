package Practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class LocalAPITest {

	//@Test
	public void get()
	{
		baseURI="http://localhost:3000/";
		
		when().get("users").then().statusCode(200);
		
	}
	
	//@Test
	public void post()
	{
		baseURI="http://localhost:3000/";
		
		JSONObject body = new JSONObject();
		body.put("firstname", "Issac");
		body.put("lastname", "Newton");
		body.put("subjectId", 2);
		
		given().
			body(body.toJSONString()).
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
		when().
			post("users").
		then().
			statusCode(201);
	}
	
	//@Test
	public void put()
	{
		baseURI="http://localhost:3000/";
		
		JSONObject body = new JSONObject();
		body.put("firstname", "Issac");
		body.put("lastname", "Newton");
		body.put("subjectId", 4);
		
		given().
			body(body.toJSONString()).
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
		when().
			put("users/4").
		then().
			statusCode(200);	
	}
	
	//@Test
	public void patch()
	{
		baseURI="http://localhost:3000/";
		
		JSONObject body = new JSONObject();
		//body.put("firstname", "Issac");
		//body.put("lastname", "Newton");
		body.put("subjectId", 1);
		
		given().
			body(body.toJSONString()).
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
		when().
			patch("users/4").
		then().
			statusCode(200);	
	}
	
	
}
