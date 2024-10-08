package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import static utilities.AuthenticationBooker.generateToken;

public class RestFullBookerBaseUrl {

    protected RequestSpecification spec;  // Şu an spec null dır. Her methoddan önce spec objeme değer atamak (kurmak) istiyorum

    public static String token;
    @BeforeMethod
    public void setUp(){
        if (token == null){
            token = generateToken();
        }
        spec = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .addHeader("Cookie","token="+ token)
                .setContentType(ContentType.JSON)
                .build();
    }
}
