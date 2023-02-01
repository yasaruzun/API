package test;

import baseURL.HerokuappBaseUrl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlHerokuappQueryParam extends HerokuappBaseUrl {

    // Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin


@Test
    public void get01(){
       /*
        1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response’un status code’unun 200 oldugunu
        ve Response’ta 33071 id'ye sahip bir booking oldugunu test edin
     */


    //1-url ve varsa body hazirla

    spec.pathParam("pp1","booking");


  //2-expected data hazirlamak
  //3- response'i kaydet

    Response response=given().
                            spec(spec).
                     when().
                            get("/{pp1}");


    //4-Assertion

    response.
            then().
            assertThat().
            statusCode(200).
            body("bookingid", Matchers.hasItem(6331));


}
    @Test
    public void get02(){
       /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response’un
        status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
    */

    //1-url hazırla

        spec.pathParam("pp1","booking").queryParam("firstname","Eric");

        //2-expected data hazirla
        //3-Response'i hazirla

        System.out.println("kontrol noktasi 1");

        Response response= given().
                spec(spec).
                when().
                get("/{pp1}");//query parametre icin yapmaya gerek yok burda. direk alıyor

        System.out.println("kontrol noktasi 2");
        response.prettyPrint();

        //4-Assertion



        response.
                then().
                assertThat().
                statusCode(200).
                body("bookingid",Matchers.hasSize(1));





    }
    @Test
    public void get03(){  /*
        3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
         parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri
         “Jackson” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
         donen response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip
         en az bir booking oldugunu test edin.
    */

    //1-url hazirla

        spec.pathParam("pp1","booking").queryParams("firstname","Jim","lastname","Jackson");

        //2-expected data hazır
        //3- Responsu kaydet

        Response response=given().spec(spec).when().get("/{pp1}");

        response.
                then().
                assertThat().
                statusCode(200).
                body("bookingid",Matchers.hasSize(1));


}

}
