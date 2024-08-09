package day03;

import base_urls.RestFullBookerBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C09_JsonPath extends RestFullBookerBaseUrl {
         /*
        Given
            https://restful-booker.herokuapp.com/booking/2
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
{
    "firstname" : "Süleyman",
    "lastname" : "Kahve",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2024-01-01",
        "checkout" : "2024-02-01"
    },
    "additionalneeds" : "Breakfast"
}
     */

    @Test
    public void test01(){
        // Set Url
        spec.pathParams("first","booking",
                "second",1387);

        // Set Expected Data

        // Send Request get Response
        Response response =  given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        // Do Assertions

        // !. Yol: Hamcrest Matchers ile
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Süleyman"))
                .body("lastname",equalTo("Kahve"))
                .body("totalprice",equalTo(111))
                .body("depositpaid",equalTo(true))
                .body("bookingdates.checkin",equalTo("2024-01-01"))
                .body("bookingdates.checkout",equalTo("2024-02-01"));



        // jsonpath() methodu response Jsonpath classına çevirir. Bu classtan get
        // methodları ile istenilen data kolaylıkla extract edilebilir.

        JsonPath json = response.jsonPath();
        String firstName = json.getString("firstname");
        String lastname = json.getString("lastname");
        int totalprice = json.getInt("totalprice");
        boolean depositpaid = json.getBoolean("firstname");
        String checkin = json.getString("bookingdates.checkin");
        String checkout = json.getString("bookingdates.checkout");
        String additionalneeds = json.getString("additionalneeds");

        // Hard Assertion
        Assert.assertEquals(firstName,"Süleyman");
        Assert.assertEquals(lastname,"Kahve");
        Assert.assertEquals(totalprice,111);
        Assert.assertEquals(depositpaid,false);
        Assert.assertEquals(checkin,"2024-01-01");
        Assert.assertEquals(checkout,"2024-02-01");
        Assert.assertEquals(additionalneeds,"Breakfast");

        // SoftAssertion
        SoftAssert softAssert= new SoftAssert();

        softAssert.assertEquals(firstName,"Süleyman");
        softAssert.assertEquals(lastname,"Kahve");
        softAssert.assertEquals(totalprice,111);
        softAssert.assertEquals(depositpaid,false);
        softAssert.assertEquals(checkin,"2024-01-01");
        softAssert.assertEquals(checkout,"2024-02-01");
        softAssert.assertEquals(additionalneeds,"Breakfast");

        softAssert.assertAll();

    }
}