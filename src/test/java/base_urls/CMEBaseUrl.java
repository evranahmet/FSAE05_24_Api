package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class CMEBaseUrl {

    protected RequestSpecification spec;

    @BeforeMethod
    public void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://kauai.ccmc.gsfc.nasa.gov/DONKI/WS")
                .setContentType(ContentType.JSON)
                .build();
    }
}
