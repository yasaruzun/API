package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuappBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setup(){

        spec=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

    }
}
