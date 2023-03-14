package POJOFiles;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;
/*@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"employee_name",
"employee_salary",
"employee_age",
"profile_image",

})*/

public class UserDataResponse {
	private Integer id;
    private String employeeName;
    private Integer employeeSalary;
    private Integer employeeAge;
    private String profileImage;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public Integer getEmployeeSalary() {
        return employeeSalary;
    }
    public void setEmployeeSalary(Integer employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
    public Integer getEmployeeAge() {
        return employeeAge;
    }
    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }
    public String getProfileImage() {
        return profileImage;
    }
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }



}
