package petstore;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C03_CreatepetPojo extends PetStoreBaseUrl {
    /*
    Given
    https://petstore.swagger.io/v2/pet
    And
     "id": 6464,
              "category": {
                "id": 0,
                "name": "Kedi"
              },
              "name": "Pamuk",
              "photoUrls": [
                "url1", "url2", "url3"
              ],
              "tags": [
                {
                  "id": 0,
                  "name": "Beyaz"
                },
                {
                  "id": 1,
                  "name": "Yavru"
                },
                {
                  "id": 2,
                  "name": "Sevimli"
                }

              ],
              "status": "available"
            }'
       When
       User send POST request
       Then
       Status code should be 200
       And
       Response body should be like:
        "id": 6464,
              "category": {
                "id": 0,
                "name": "Kedi"
              },
              "name": "Pamuk",
              "photoUrls": [
                "url1", "url2", "url3"
              ],
              "tags": [
                {
                  "id": 0,
                  "name": "Beyaz"
                },
                {
                  "id": 1,
                  "name": "Yavru"
                },
                {
                  "id": 2,
                  "name": "Sevimli"
                }

              ],
              "status": "available"
            }'
     */

    @Test
    void creatPetTest(){
        //Set the Url
        spec.pathParam("first","pet");

        //Set the expected data
        String strExpectedData = """
                        {
                              "id": 6464,
                              "category": {
                                "id": 0,
                                "name": "Kedi"
                              },
                              "name": "Pamuk",
                              "photoUrls": [
                                "url1", "url2", "url3"
                              ],
                              "tags": [
                                {
                                  "id": 0,
                                  "name": "Beyaz"
                                },
                                {
                                  "id": 1,
                                  "name": "Yavru"
                                },
                                {
                                  "id": 2,
                                  "name": "Sevimli"
                                }

                              ],
                              "status": "available"
                            }
                """;

        PetPojo expectedData = ObjectMapperUtils.convertJsonStrToJava(strExpectedData, PetPojo.class);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(strExpectedData).post("{first}");
        response.prettyPrint();

        //Do assertion
        PetPojo actualData = ObjectMapperUtils.convertJsonStrToJava(response.asString(), PetPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(),200);
        assertEquals(actualData.getCategory().getName(),expectedData.getCategory().getName());
        assertEquals(actualData.getId(),expectedData.getId());
        assertEquals(actualData.getPhotoUrls(),expectedData.getPhotoUrls());
        assertEquals(actualData.getPhotoUrls().get(0),expectedData.getPhotoUrls().get(0));
        assertEquals(actualData.getPhotoUrls().get(1),expectedData.getPhotoUrls().get(1));
        assertEquals(actualData.getPhotoUrls().get(2),expectedData.getPhotoUrls().get(2));
        assertEquals(actualData.getTags().get(0).getName(),expectedData.getTags().get(0).getName());;
        assertEquals(actualData.getTags().get(1).getName(),expectedData.getTags().get(1).getName());;
        assertEquals(actualData.getTags().get(2).getName(),expectedData.getTags().get(2).getName());;
        assertEquals(actualData.getStatus(),expectedData.getStatus());;



    }

}
