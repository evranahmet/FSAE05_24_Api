package petstore;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static petstore.C03_CreatePetPojo.expectedData;
import static petstore.C03_CreatePetPojo.petId;

public class C05_UpdatePet extends PetStoreBaseUrl {
    /*
    Given
        https://petstore.swagger.io/v2/pet
    And
            {
              "id": 56793,
              "category": {
                "id": 0,
                "name": "Köpek"
              },
              "name": "Çomar",
              "photoUrls": [
                "url1", "url2"
              ],
              "tags": [
                {
                  "id": 0,
                  "name": "Kara"
                }
              ],
              "status": "sold"
            }

       When
            User send PUT request
       Then
            Status code should be 200
       And
            Response body should be like:
             {
              "id": 56793,
              "category": {
                "id": 0,
                "name": "Köpek"
              },
              "name": "Çomar",
              "photoUrls": [
                "url1", "url2"
              ],
              "tags": [
                {
                  "id": 0,
                  "name": "Kara"
                }
              ],
              "status": "sold"
            }
     */

    @Test
    void updatePetTest() {
        //Set the url
        spec.pathParams("first", "pet");

        //Set the expected data
        String strExpectedData = """
                             {
                              "category": {
                                "id": 0,
                                "name": "Köpek"
                              },
                              "name": "Çomar",
                              "photoUrls": [
                                "url1", "url2"
                              ],
                              "tags": [
                                {
                                  "id": 0,
                                  "name": "Kara"
                                }
                              ],
                              "status": "sold"
                            }
                """;

        PetPojo expectedData = ObjectMapperUtils.convertJsonStrToJava(strExpectedData, PetPojo.class);
        expectedData.setId(petId);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).put("{first}");
        response.prettyPrint();

        //Do assertion
        PetPojo actualData = ObjectMapperUtils.convertJsonStrToJava(response.asString(), PetPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getCategory().getName(), expectedData.getCategory().getName());
        assertEquals(actualData.getName(), expectedData.getName());
        assertEquals(actualData.getPhotoUrls().get(0), expectedData.getPhotoUrls().get(0));
        assertEquals(actualData.getPhotoUrls().get(1), expectedData.getPhotoUrls().get(1));
        assertEquals(actualData.getTags().getFirst().getName(), expectedData.getTags().getFirst().getName());
        assertEquals(actualData.getStatus(), expectedData.getStatus());

    }
}
