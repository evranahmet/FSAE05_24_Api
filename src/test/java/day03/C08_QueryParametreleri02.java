package day03;

import base_urls.RestFullBookerBaseUrl;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C08_QueryParametreleri02 extends RestFullBookerBaseUrl {

    @Test
    public void test01(){
        spec.pathParam("first","booking")
                .queryParam("checkin","2024-07-27");

        given(spec)
                .when()
                .get("{first}")
                .prettyPrint();
    }
}
