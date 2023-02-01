package test;

import baseURL.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import java.awt.geom.RectangularShape;

import static io.restassured.RestAssured.given;

public class C19_Put_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {

/*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT
    request yolladigimizda donen response’in
    status kodunun 200, content type’inin “application/json; charset=utf-8”,
    Connection header degerinin “keep-alive”
    ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Expected Data
        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
  */


    @Test
    public void put01(){

        TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();
        //1-url ve body hazirla

        specJsonPlace.pathParams("pp1","posts","pp2",70);

        JSONObject reqData=testDataJsonPlaceHolder.requestBodyOlusturJson();

        //2-expected Data Hazirla


        JSONObject expData=testDataJsonPlaceHolder.requestBodyOlusturJson();


        //3- Responsu Kaydet

        Response response= given().
                                    spec(specJsonPlace).
                                    contentType(ContentType.JSON).
                            when().
                                    body(reqData.toString()).
                                    put("/{pp1}/{pp2}");

        //4-Assertion
        Assert.assertEquals(testDataJsonPlaceHolder.basariliStatusKodu,response.getStatusCode());
        Assert.assertEquals(testDataJsonPlaceHolder.basariliContentType,response.contentType());
        Assert.assertEquals(testDataJsonPlaceHolder.connectionHeaderDegeri,response.getHeader("Connection"));

        JsonPath respJsonPath=response.jsonPath();


        Assert.assertEquals(expData.get("title"),respJsonPath.get("title"));
        Assert.assertEquals(expData.get("body"),respJsonPath.get("body"));
        Assert.assertEquals(expData.get("userId"),respJsonPath.get("userId"));
        Assert.assertEquals(expData.get("id"),respJsonPath.get("id"));

    }

}
