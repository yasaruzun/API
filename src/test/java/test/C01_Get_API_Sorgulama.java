package test;

import io.restassured.response.Response;
import org.junit.Test;

import java.lang.annotation.Target;

import static io.restassured.RestAssured.given;

public class C01_Get_API_Sorgulama {


    //        https://restful-booker.herokuapp.com/booking/15295 url’ine
    //        bir GET request gonderdigimizde donen Response’un,
    //        status code’unun 200,
    //        ve content type’inin application/json; charset=utf-8,
    //        ve Server isimli Header’in degerinin Cowboy,
    //        ve status Line’in HTTP/1.1 200 OK
    //        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.



    // 1- gonderecegimiz request icin gerekli olan URL i ve ihtiyacimiz varsa body'i hazirliyoruz
    // 2- eger soruda bize verilmisse expected data'yi hazirliyorum
    // 3- Bize donen reponse'i actual data olarak kaydet
    // 4- expected data ile actual data'nin karsilastirilmasi---Assertion



    @Test
    public void get01(){
        // 1- gonderecegimiz request icin gerekli olan URL i ve ihtiyacimiz varsa body'i hazirliyoruz

        String  url="https://restful-booker.herokuapp.com/booking/1335";

        // 2- eger soruda bize verilmisse expected data'yi hazirliyorum
        // 3- Bize donen reponse'i actual data olarak kaydet

        Response response= given().when().get(url);
        response.prettyPrint();
    /*
    {
    "firstname": "John",
    "lastname": "Smith",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
     */

        System.out.println("status code :"+response.getStatusCode());
        System.out.println("content type :"+response.getContentType());
        System.out.println("header server name :"+response.getHeader("Server"));
        System.out.println("status line :"+response.getStatusLine());
        System.out.println("responce time :"+response.getTime());

        // 4- expected data ile actual data'nin karsilastirilmasi---Assertion






    }


}
