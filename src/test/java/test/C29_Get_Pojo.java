package test;

import baseURL.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.POJODummyData;
import pojos.POJODumyExpectedBody;

import static io.restassured.RestAssured.given;

public class C29_Get_Pojo extends DummyRestApiBaseUrl {

/*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
     gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
    Response Body
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully!Record has been fetched."
    }
     */

    @Test
    public void get01(){

        //1-url hazirla

        specDummy.pathParams("pp1","employee","pp2",3);

        //2-expected data hazirla

        POJODummyData data=new POJODummyData(3,"Ashton Cox",86000,66,"");


        POJODumyExpectedBody expBody=new POJODumyExpectedBody("success",data,"Successfully! Record has been fetched.");


        //3-Response'i kaydet

        Response response=given().
                                spec(specDummy).
                         when().
                                get("/{pp1}/{pp2}");

        POJODumyExpectedBody resPOJO=response.as(POJODumyExpectedBody.class);

        //4-Assertion

        Assert.assertEquals(expBody.getStatus(),resPOJO.getStatus());
        Assert.assertEquals(expBody.getMessage(),resPOJO.getMessage());

        Assert.assertEquals(expBody.getData().getId(),resPOJO.getData().getId());
        Assert.assertEquals(expBody.getData().getEmployee_name(),resPOJO.getData().getEmployee_name());
        Assert.assertEquals(expBody.getData().getEmployee_salary(),resPOJO.getData().getEmployee_salary());
        Assert.assertEquals(expBody.getData().getEmployee_age(),resPOJO.getData().getEmployee_age());
        Assert.assertEquals(expBody.getData().getProfile_image(),resPOJO.getData().getProfile_image());

    }

}
