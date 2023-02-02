package testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataJsonPlaceHolder {

    public int basariliStatusKodu=200;
    public String basariliContentType="application/json; charset=utf-8";
    public String connectionHeaderDegeri="keep-alive";

    public JSONObject expectedBodyOlusturJson(){

        JSONObject expBodyJson=new JSONObject();

        expBodyJson.put("userId",3);
        expBodyJson.put("id",22);
        expBodyJson.put("title","dolor sint quo a velit explicabo quia nam");
        expBodyJson.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear" +
                "um mollitia molestiae aut atque rem suscipit\nnam impedit esse");



       return expBodyJson;
    }

/*
Request Body
        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
 */

    public JSONObject requestBodyOlusturJson(){

        JSONObject reqBodyJson=new JSONObject();

        reqBodyJson.put("userId",10);
        reqBodyJson.put("id",70);
        reqBodyJson.put("title","Ali");
        reqBodyJson.put("body","Merhaba");



        return reqBodyJson;
    }

    /*
      Map<String,Object> reqBodyMap=new HashMap<>();
        reqBodyMap.put("title","Ahmet");
        reqBodyMap.put("body","Merhaba");
        reqBodyMap.put("userId",10);
        reqBodyMap.put("id",70);
     */
    public HashMap requestBodyOlusturMap(){

        HashMap<String,Object> reqBodyMap=new HashMap<>();

        reqBodyMap.put("title","Ahmet");
        reqBodyMap.put("body","Merhaba");
        reqBodyMap.put("userId",10.0);
        reqBodyMap.put("id",70.0);



        return reqBodyMap;
    }

}
