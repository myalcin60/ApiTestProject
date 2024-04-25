package testdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyRestApiTestData {
   /*
   Then
    Assert that Status Code is "200"
    And
    User verifies that the last employee's name is "Doris Wilder"
    And
    User verifies that employee 6's salary is 372000
    And
    User verifies that the ages of employees includes 21, 23 and 59
    */

    public List<Map<String, Object>> expectedDataList= new ArrayList<>();

    public List<Map<String, Object>> setUpTestData(){

        //1.ExpectedData StatusCode Setleme
        HashMap<String, Object> expectedDataStatusCode= new HashMap<>();
        expectedDataStatusCode.put("StatusCode", 200);

        //2.ExpectedData employee_name
        HashMap<String, Object> expectedDataName= new HashMap<>();
        expectedDataName.put("employee_name", "Doris Wilder");

        //3.ExpectedData employee_salary
        HashMap<String, Object> expectedDataSalary= new HashMap<>();
        expectedDataSalary.put("employee_salary", 372000);

        //4.ExpectedData employee_age User verifies that the ages of employees includes 21, 23 and 59*/
       List<Integer> expectedDataAges = new ArrayList<>();
       expectedDataAges.add(21);
       expectedDataAges.add(23);
       expectedDataAges.add(59);

       HashMap<String, Object> expectedDataMapAges= new HashMap<>();

       expectedDataMapAges.put("EmployeeAges", expectedDataAges);

        expectedDataList.add(expectedDataStatusCode);
        expectedDataList.add(expectedDataName);
        expectedDataList.add(expectedDataSalary);
        expectedDataList.add(expectedDataMapAges);

       return expectedDataList;

    }public  HashMap<String, Object> setUpdeleteData(String status, String data, String message) {

        HashMap<String, Object> expectedBodyData=new HashMap<String, Object>();
        expectedBodyData.put("status", status);
        expectedBodyData.put("data", data);
        expectedBodyData.put("message", message);

        return expectedBodyData;
    }



}
