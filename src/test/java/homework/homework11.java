package homework;

import base_urls.GorestBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.goRestHomework11.ResponsePojo;
import utilities.ObjectMapperUtils;

import javax.xml.crypto.Data;

import static io.restassured.RestAssured.given;

public class homework11 extends GorestBaseUrl {
        /*
Given
    https://gorest.co.in/public/v1/posts?id=148697
When
    User sends GET request
Then
    HTTP Status Code should be 200
And
    Response body should be like:
        {
    "meta": {
        "pagination": {
            "total": 1,
            "pages": 1,
            "page": 1,
            "limit": 10,
            "links": {
                "previous": null,
                "current": "https://gorest.co.in/public/v1/posts?page=1",
                "next": null
            }
        }
    },
     "data": [
        {
            "id": 148697,
            "user_id": 7347444,
            "title": "Defetiscor adeptio verbum victoria subito.",
            "body": "Tondeo absens circumvenio. Autem trucido possimus. Fuga conforto concedo. Commodi adsuesco aestus. Confido aestas summisse. Videlicet altus custodia. Vulariter adeo aegrotatio. Stipes sustineo delibero. Carus statua careo. Qui cibo aperte. Impedit canis denuo. Culpa taceo cattus. Tamisium asperiores tardus. Consequatur vester ut. Terreo defessus stultus. Contabesco censura conculco."
        }
    ]
}
 */

    @Test
    public void test() {
        // Set Url
        spec.pathParam("first", "posts")
                .queryParam("id", 148697);

        // Set ExpectedData
        String expectedStr = """
         {
             "meta":{
        "pagination": {
            "total": 1,
            "pages": 1,
            "page": 1,
            "limit": 10,
            "links": {
                "previous": null,
                "current": "https://gorest.co.in/public/v1/posts?page=1",
                "next": null
            }
        }
    },
     "data": [
        {
            "id": 148697,
            "user_id": 73047444,
            "title": "Defetiscor adeptio verbum victoria subito.",
            "body": "Tondeo absens circumvenio. Autem trucido possimus. Fuga conforto concedo. Commodi adsuesco aestus. Confido aestas summisse. Videlicet altus custodia. Vulariter adeo aegrotatio. Stipes sustineo delibero. Carus statua careo. Qui cibo aperte. Impedit canis denuo. Culpa taceo cattus. Tamisium asperiores tardus. Consequatur vester ut. Terreo defessus stultus. Contabesco censura conculco."
        }
    ]
     """;
//
//        ResponsePojo expecterData = ObjectMapperUtils.convertJsonStrToJava(expectedStr,ResponsePojo.class);
//        System.out.println("expecterData = " + expecterData);




}
}
