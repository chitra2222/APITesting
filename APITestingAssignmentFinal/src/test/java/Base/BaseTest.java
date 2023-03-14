package Base;

import static org.hamcrest.Matchers.is;

import org.testng.annotations.BeforeMethod;

import Constants.EndPoints;
import POJOFiles.CreateData;
import Utility.PropertiesUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseTest {
	PropertiesUtility propertyutility = new PropertiesUtility();
	
	@BeforeMethod
	public void init() {
		propertyutility.loadFile();
		String uri = propertyutility.getPropertyValue("baseURl");
		RestAssured.baseURI=uri;
	}
	
	public Response gotoAPI() {
		String Employees = EndPoints.EMPLOYEES;
		
		Response res = RestAssured.when().get(Employees);
		return res;
	}
	
	public Response createdata() {
		String create = EndPoints.CREATE;
		propertyutility.loadFile();
		CreateData ob = new CreateData();
		String name = propertyutility.getPropertyValue("name");
		String salary = propertyutility.getPropertyValue("salary");
		String age = propertyutility.getPropertyValue("age");
		ob.setName(name);
		ob.setSalary(salary);
		ob.setAge(age);
		
		Response res = RestAssured.given()
				.log().headers()
				.contentType(ContentType.JSON)
				.body(ob)
				//.body("{\"name\":\"tests\",\"salary\":\"123\",\"age\":\"23\"}")
				.when().post(create);
		return res;
	}
	public Response deleteData(String idvalue) {
		String delete = EndPoints.DELETE;
		
		Response res = RestAssured.given().log().headers().pathParam("id", idvalue)
						.when().delete(delete);
		return res;
	}
	
	public Response getData() {
		String emp = EndPoints.EMPLOYEE;
		Response res = RestAssured.given().log().headers().pathParam("id", "2")
				.when().get(emp);
		return res;
		
	}
	
	public void statusCodeValidation(Response res, int code) {
		res.then().statusCode(code);	
	}
	
	public void pretty(Response res) {
		res.prettyPrint();	
	}
	
	public void successValidation(Response res) {
		res.then().body("status", is("success"));
		}
	
	public void errorValidation(Response res) {
		res.then().body("status", is("error"));

	}

}
