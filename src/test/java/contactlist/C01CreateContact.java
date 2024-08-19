package contactlist;

import base_urls.ContactListBaseUrl;
import org.testng.annotations.Test;
import pojos.ContactlistPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;

public class C01CreateContact extends ContactListBaseUrl {

    @Test
    public void createContactTest(){
        spec.pathParam("first","contacts");

        String payloadStr = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "birthdate": "1970-01-01",
                    "email": "jdoe@fake.com",
                    "phone": "8005555555",
                    "street1": "1 Main St.",
                    "street2": "Apartment A",
                    "city": "Anytown",
                    "stateProvince": "KS",
                    "postalCode": "12345",
                    "country": "USA"
                }""";

        ContactlistPojo payload = ObjectMapperUtils.convertJsonStrToJava(payloadStr, ContactlistPojo.class);

        given(spec).body(payload).when().post("{first}").prettyPrint();







    }
}
