package day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class C02_HeaderAsserions {
    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
    And
        Print Connection and Date headers on console
    And
        Print all headers on console
*/

        /*
    Steps to follow in API Testing:
    1. Set the URL
    2. Set the expected data
    3. Send the request and get the response
    4. Do Assertion
*/

    @Test
    public void headerTest(){
        //    1. Set the URL
        String url = "https://restful-booker.herokuapp.com/booking";

        // 1. Yol: Assertionlar method chain şeklinde yapılabilir
        given().
                when().
                get(url).
                then().
                statusCode(200).
                contentType("application/json").
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");

        // 2. Yol : Basamak basamak ilerlemek...
        //    2. Set the expected data  -- > daha sonra uygulayacağız.
        //    3. Send the request and get the response
        Response response = given().when().get(url);
       // response.prettyPrint();
        //    4. Do Assertion

        // method chain olarak devam edilebilir...
        response.
                then().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                contentType(ContentType.JSON).
                header("Connection",equalTo("keep-alive")).
                header("Connection","keep-alive").
                header("Connection",is("keep-alive"));
        // TestNg Assertionları gibi yöntemler ile de devam edebiliriz.

        int statusCode = response.statusCode();
        String statusLine = response.statusLine();
        String contentType = response.contentType();
        String conn = response.header("connection");

        Assert.assertEquals(statusCode,200);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
        Assert.assertEquals(contentType,"application/json; charset=utf-8");
        Assert.assertEquals(conn,"keep-alive");


    }
}
