package day08;

import base_urls.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.JsonPlaceHolderPojo;
import utilities.ObjectMapperUtils;

import java.util.List;

import static io.restassured.RestAssured.given;

public class C29_PojoListGroovy extends JsonPlaceHolderBaseUrl {
            /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
            I send a GET request to the Url
        Then
            HTTP Status Code should be 200
        And
            There must be a todo like:
                {
                    "userId": 1,
                    "id": 4,
                    "title": "et porro tempora",
                    "completed": true
                }
     */
    @Test
    public void test() throws JsonProcessingException {
        // Set Url
        spec.pathParam("first","todos");

        // Set Expected Data
        String expectedStr = """
                {
                                    "userId": 1,
                                    "id": 4,
                                    "title": "et porro tempora",
                                    "completed": true
                                }""";

        JsonPlaceHolderPojo expectedTodo = ObjectMapperUtils.convertJsonStrToJava(expectedStr, JsonPlaceHolderPojo.class);

        // Send Request And Get Response
        Response response = given(spec).when().get("{first}");
       // response.prettyPrint();

        // Do Assertions
        JsonPath json = response.jsonPath();
        List<JsonPlaceHolderPojo> actualData = json.getList("findAll{it.id==4}"); // getList metodu bize responsu List<Object> olarak döndürüyor



        String StringJson = new ObjectMapper().writeValueAsString(actualData.getFirst()); // Object bize lazım olan Json formatındaki String dataya dönüştürür
        String actualString2 = actualData.toString(); // Oluşan String Json Formatında olmadığı için Pojoya dönüştüremiyoruz

        System.out.println("StringJson = " + StringJson);
        System.out.println("actualString2 = " + actualString2);

        JsonPlaceHolderPojo actualTodo = ObjectMapperUtils.convertJsonStrToJava(StringJson, JsonPlaceHolderPojo.class);

        Assert.assertEquals(actualTodo.getUserId(),expectedTodo.getUserId());
        Assert.assertEquals(actualTodo.getTitle(),expectedTodo.getTitle());
        Assert.assertEquals(actualTodo.getCompleted(),expectedTodo.getCompleted());

        // 2. Yöntem

        Object actualTitle = json.getList("findAll{it.id==4}.title").getFirst();
        Object actualuserId = json.getList("findAll{it.id==4}.userId").getFirst();
        Object actualcompleted = json.getList("findAll{it.id==4}.completed").getFirst();

        Assert.assertEquals(actualuserId,expectedTodo.getUserId());
        Assert.assertEquals(actualTitle,expectedTodo.getTitle());
        Assert.assertEquals(actualcompleted,expectedTodo.getCompleted());
    }
}
