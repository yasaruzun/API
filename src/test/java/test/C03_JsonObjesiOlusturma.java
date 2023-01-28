package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {
/*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
*/


@Test
        public void jsonObje01(){

    JSONObject jsonObject=new JSONObject();

    jsonObject.put("title","Ahmet");
    jsonObject.put("body","Merhaba");
    jsonObject.put("userId",1);

    System.out.println(jsonObject);


}
@Test
    public void jsonObje02(){

/*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */



    JSONObject innerJson=new JSONObject();

    innerJson.put("checkin","2018-01-01");
    innerJson.put("checkout","2019-01-01");

    JSONObject body=new JSONObject();

    body.put("firstname","Jim");
    body.put("additionalneeds","Breakfast");
    body.put("bookingdates",innerJson);
    body.put("totalprice",111);
    body.put("depositpaid",true);
    body.put("lastname","Brown");


    System.out.println(body);


}


}
