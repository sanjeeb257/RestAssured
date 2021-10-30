package sdet21.ComplexResponseValiadtion;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponse {
	
	@Test
	public void dynamicResponse()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		String expData = "Accenture";
		
		//store the response
		Response res = when().get("/projects");
		
		//capture all the project names and store it in astring
		List<String> pNames = res.jsonPath().get("projectName");
		
		for(String actData : pNames)
		{
			if(actData.equalsIgnoreCase(expData))
			{
				Assert.assertEquals(actData, expData);
				System.out.println(actData +" data present");
				break;
			}
		}
		//validation
		res.then().log().all();
	}

}
