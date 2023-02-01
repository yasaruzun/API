package test;

import baseURL.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class C18_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {

/*

https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
request yolladigimizda donen response'in status kodunun 200 ve
response body'sinin asagida verilen ile ayni oldugunu test ediniz

 Response body :
  {
  "userId":3,
  "id":22,
  "title":"dolor sint quo a velit explicabo quia nam",
  "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
  um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
  }
   */


    @Test
    public void get01(){

    //1- url hazirla

        specJsonPlace.pathParams("pp1","posts","pp2",22);

        //2-expected data hazirla

        TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();

       JSONObject expectedData= testDataJsonPlaceHolder.expectedBodyOlusturJson();


        //3-responsu kaydet

        Response response=given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");

        //4- Assertion

        JsonPath resJsonPath=response.jsonPath();

        Assert.assertEquals(testDataJsonPlaceHolder.basariliStatusKodu,response.getStatusCode());

        Assert.assertEquals(expectedData.get("userId"),resJsonPath.get("userId"));
        Assert.assertEquals(expectedData.get("id"),resJsonPath.get("id"));
        Assert.assertEquals(expectedData.get("title"),resJsonPath.get("title"));
        Assert.assertEquals(expectedData.get("body"),resJsonPath.get("body"));


    }









}
