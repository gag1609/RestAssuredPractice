package Practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssured_1 {

	//@Test(priority = 0)
	public void Getmethod() throws MalformedURLException {
		URL get_url = new URL("https://reqres.in/api/users?page=2");

		Response res = get(get_url);

		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		System.out.println(res.getBody().asString());

		Assert.assertEquals(res.getStatusCode(), 200);
	}

	//@Test(priority = 1)
	public void Getmethod_BDD() throws MalformedURLException 
	{
		baseURI = "https://reqres.in/api/";
		
		when().
			get("users?page=2").
		then().
			statusCode(200).
		and().
			body("data.id", hasItem(8));
	}
	
	//@Test(priority = 2)
	public void Postmethod_BDD() throws MalformedURLException 
	{
		baseURI = "https://reqres.in/api/";
		
		JSONObject body = new JSONObject();
		body.put("name", "Gagan");
		body.put("job", "Engineer");
		
		given().
			body(body.toJSONString()).
		when().
			post("users").
		then().
			statusCode(201).
		and().
			log().all();
	}

}
