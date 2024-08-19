package day10_booker_test;

import base_urls.RestFullBookerBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;
import utilities.BookingResponseValidator;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;

public class C01_CreateBooking extends RestFullBookerBaseUrl {

    public static Integer bookingId;  // public --> projede herhangi bir yerden ulaşılacak,
                                 // static --> object oluşturmaya gerek kalmayacak
    public static BookingPojo payload;
    @Test
    public void createBookingTest(){
        // Set Url
        spec.pathParam("first","booking");

        // Set Expected Date
        String payloadStr = """
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
                }""";
        payload = ObjectMapperUtils.convertJsonStrToJava(payloadStr, BookingPojo.class);

        // Sent Request and Get Response
        Response response = given(spec).
                                 body(payload).
                                 when().
                                 post("{first}");

        response.prettyPrint();

        // Do Assertions
        BookingResponsePojo actualData = ObjectMapperUtils.convertJsonStrToJava(response.asString(), BookingResponsePojo.class);

        Assert.assertEquals(response.statusCode(),200);

        BookingResponseValidator.validateResponse(actualData.getBooking(),payload);

        bookingId = actualData.getBookingid();

    }
}
