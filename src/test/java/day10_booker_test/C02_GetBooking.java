package day10_booker_test;

import base_urls.JsonPlaceHolderBaseUrl;
import base_urls.RestFullBookerBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.BookingPojo;
import utilities.BookingResponseValidator;
import utilities.ObjectMapperUtils;

import static day10_booker_test.C01_CreateBooking.bookingId;
import static day10_booker_test.C01_CreateBooking.payload;
import static io.restassured.RestAssured.given;

public class C02_GetBooking extends RestFullBookerBaseUrl {

    @Test(dependsOnMethods = {"day10_booker_test.C01_CreateBooking.createBookingTest"})////C01 clasındaki payloada bağlı olduğu için dependsOnMethods kullanılır
    public void getBookingTest(){
        // Set Url
        spec.pathParams("first","booking",
                "second",bookingId);

        // Set expected data // Zaten createBooking classında payload var.

        // Send Request And Get Response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        // Do Assertions
        BookingPojo actualData = ObjectMapperUtils.convertJsonStrToJava(response.asString(), BookingPojo.class);
        BookingResponseValidator.validateResponse(actualData,payload);
}
}
