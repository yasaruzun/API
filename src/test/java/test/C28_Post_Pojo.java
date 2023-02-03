package test;

import baseURL.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.POJOHerokuappBooking;
import pojos.POJOHerokuappBookingDates;
import pojos.POJOHerokuappExpectedBody;

import static io.restassured.RestAssured.given;

public class C28_Post_Pojo extends HerokuappBaseUrl {

/*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body = Expected Data
                        {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                              }
                    }
         */

    @Test
    public void post01(){

        //1-url ve body hazirla


        spec.pathParam("pp1","booking");

        POJOHerokuappBookingDates bookingDates=new POJOHerokuappBookingDates("2021-06-01","2021-06-10");
        POJOHerokuappBooking reqBody=new POJOHerokuappBooking("Ahmet","Bulut",500,false,bookingDates,"wi-fi");

        //2-expected data hazirla

        POJOHerokuappExpectedBody expectedBody=new POJOHerokuappExpectedBody(24,reqBody);

        //3-Responsu'i kaydet

        Response response=given().
                                    spec(spec).
                                    contentType(ContentType.JSON).
                         when().
                                    body(reqBody).
                                    post("/{pp1}");


        //4-Assertion

        POJOHerokuappExpectedBody respPOJO=response.as(POJOHerokuappExpectedBody.class);

        Assert.assertEquals(expectedBody.getBooking().getFirstname(),respPOJO.getBooking().getFirstname());
        Assert.assertEquals(expectedBody.getBooking().getLastname(),respPOJO.getBooking().getLastname());
        Assert.assertEquals(expectedBody.getBooking().getTotalprice(),respPOJO.getBooking().getTotalprice());
        Assert.assertEquals(expectedBody.getBooking().getAdditionalneeds(),respPOJO.getBooking().getAdditionalneeds());
        Assert.assertEquals(expectedBody.getBooking().isDepositpaid(),respPOJO.getBooking().isDepositpaid());

        Assert.assertEquals(expectedBody.getBooking().getBookingdates().getCheckin(),respPOJO.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(expectedBody.getBooking().getBookingdates().getCheckout(),respPOJO.getBooking().getBookingdates().getCheckout());



    }


}
