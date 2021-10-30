package sdet21.RMGY.CRUD.Practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
	@Test
	public void createProject()
	{
		//create the json data before request
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Sanjeeb");
		jobj.put("projectName", "Accenture");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 25);
		
		//set the request specification before request
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jobj);
		
		//Send the request
		Response res = req.post("http://localhost:8084/addProject");
		res.then().assertThat().statusCode(201);
		//print the response
		System.out.println(res.asString());
		System.out.println(res.prettyPrint());
		System.out.println(res.prettyPeek());
		
		
	}

}
