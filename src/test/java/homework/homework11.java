package homework;

import base_urls.GorestBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.goRestHomework11.ResponsePojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;

public class homework11 extends GorestBaseUrl {

    @Test
    public void test01() {
        // Endpoint ve query parametreleri düzenleme
        spec.pathParams("first", "posts")
                .queryParam("id", 149129);

        // set the data
        String expectedStr = """
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
                        "id": 149129,
                      "user_id": 7352086,
                      "title": "Vinco caritas quo ustulo virgo sunt depono.",
                  "body": "Bene cubicularis vapulus. Venustas thermae cognomen. Degusto calcar vir. Aetas alioqui varius. Molestias allatus convoco. Nulla adaugeo addo. Advenio careo acervus. Adficio deputo soluta. Bestia quo alveus. Ambitus repellat vel."
                                                                                                                                                                                                                                                                        
                             }
                        ]
                    }""";

        ResponsePojo expectedData = ObjectMapperUtils.convertJsonStrToJava(expectedStr, ResponsePojo.class);
        //ObjectMapperUtils.convertJsonStrToJava: Bu method, String formatındaki JSON verisini Java nesnesine (POJO) dönüştürüyor.
        System.out.println("Expected Data = " + expectedData);

        // send request and get response
        Response response = given(spec)
                .when()
                .get("/{first}");
        response.prettyPrint();

        // do assertions
        response.then().statusCode(200);

        ResponsePojo actualData = ObjectMapperUtils.convertJsonStrToJava(response.asString(), ResponsePojo.class);
        System.out.println("Actual Data = " + actualData);

        // Meta assertion
        Assert.assertEquals(actualData.getMeta().getPagination().getTotal(), expectedData.getMeta().getPagination().getTotal());
        Assert.assertEquals(actualData.getMeta().getPagination().getPages(), expectedData.getMeta().getPagination().getPages());
        Assert.assertEquals(actualData.getMeta().getPagination().getPage(), expectedData.getMeta().getPagination().getPage());
        Assert.assertEquals(actualData.getMeta().getPagination().getLimit(), expectedData.getMeta().getPagination().getLimit());
        Assert.assertEquals(actualData.getMeta().getPagination().getLinks().getPrevious(), expectedData.getMeta().getPagination().getLinks().getPrevious());
        Assert.assertEquals(actualData.getMeta().getPagination().getLinks().getCurrent(), expectedData.getMeta().getPagination().getLinks().getCurrent());
        Assert.assertEquals(actualData.getMeta().getPagination().getLinks().getNext(), expectedData.getMeta().getPagination().getLinks().getNext());

        // Data assertion
        Assert.assertEquals(actualData.getData().get(0).getId(), expectedData.getData().get(0).getId());
        Assert.assertEquals(actualData.getData().get(0).getUserId(), expectedData.getData().get(0).getUserId());
        Assert.assertEquals(actualData.getData().get(0).getTitle(), expectedData.getData().get(0).getTitle());
        Assert.assertEquals(actualData.getData().get(0).getBody(), expectedData.getData().get(0).getBody());
    }
}