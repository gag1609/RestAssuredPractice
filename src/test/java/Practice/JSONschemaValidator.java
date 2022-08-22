package Practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItem;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

public class JSONschemaValidator {

	@Test
	public void Getmethod_BDD() throws MalformedURLException {
		//System.out.println(System.getProperty("java.class.path"));

		baseURI = "https://reqres.in/api/";

		when().get("users?page=2").then().statusCode(200).log().all().assertThat()
				.body(matchesJsonSchemaInClasspath("C:\\Users\\gagan\\eclipse-workspace\\RestAssuredPractice\\target\\classes\\schema.json"));

	}

}
