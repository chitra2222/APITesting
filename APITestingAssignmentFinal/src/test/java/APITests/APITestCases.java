package APITests;

import org.testng.annotations.Test;

import Base.BaseTest;
import POJOFiles.UserDataResponse;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import io.restassured.matcher.ResponseAwareMatcher;


public class APITestCases extends BaseTest {
	
	@Test

	public void TestCase1() {
		Response res = gotoAPI();
		statusCodeValidation(res, 200);
		pretty(res);
		successValidation(res);
		//UserDataResponse[] data=res.as(UserDataResponse[].class);
		//System.out.println("Number of records= "+data.length);
		
		//System.out.println(res.body().jsonPath().getList("$").size());
	}
	
	@Test
	public void TestCase2() {
		Response res = createdata();
		statusCodeValidation(res, 200);
		successValidation(res);
		pretty(res);
		//String idans = res.body().jsonPath().get("find { it -> it.name == 'tests'}.id");

		//System.out.println(idans);
		
		
	}
	
	@Test
	public void TestCase3() {
		Response res = deleteData("202");
		statusCodeValidation(res, 200);
		successValidation(res);
		pretty(res);	
		
	}
	
	@Test
	public void TestCase4() {
		Response res = deleteData("0");
		statusCodeValidation(res, 400);
		errorValidation(res);
		pretty(res);
		
	}
	
	@Test
	public void TestCase5() {
		Response res = getData();
		statusCodeValidation(res, 200);
		successValidation(res);
		pretty(res);
		
	}

}
