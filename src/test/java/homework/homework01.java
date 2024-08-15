package homework;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Set;

import static io.restassured.RestAssured.given;

public class homework01 {

     /*
   Given
       https://reqres.in/api/users/3
   When
       User sends a GET Request to the url
   Then
       HTTP Status Code should be 200
   And
       Content Type should be JSON
   And
       Status Line should be HTTP/1.1 200 OK
*/

    @Test
    public void homework01(){
//        Steps to follow in API Testing:

//        1. Set the URL
        String url = "https://reqres.in/api/users/3";

//        2. Set the expected data
//        3. Send the request and get the response

        Response response = given().when().get(url);
        response.prettyPrint();

//        4. Do Assertion
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");

    }
}