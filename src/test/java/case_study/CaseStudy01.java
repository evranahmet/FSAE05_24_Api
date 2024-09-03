package case_study;

import base_urls.CMEBaseUrl;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestDatasForDataProvider;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CaseStudy01 extends CMEBaseUrl {
    /*
    Vaka Çalışması

NASA Uzay Hava Durumu API Uç Noktasının Test Edilmesi

Dünyadaki hava durumu bizi ve kullandığımız teknolojileri birçok yönden etkileyebilir,
ancak hava durumu yalnızca gezegenimize özgü bir olgu değildir. Uyduların yörüngesinde
döndüğü uzayda atmosfer olmamasına rağmen, güneşimiz uzay havası olaylarına neden olur.
Bu uzay havası olayları, jeomanyetik fırtınalardan güneş patlamalarına kadar uzanır ve iletişim
 sistemlerini bozarak ya da değerli donanımlarını yok ederek yörüngedeki uzay araçlarını
 olumsuz etkileyebilir.

Bu olasılığa daha iyi hazırlanmak için consteller, NASA tarafından sağlanan uzay hava
durumu verilerini kullanmaya başlamak istiyor. Daha spesifik olarak, koronal kütle püskürtüleri
 (CME) verileriyle ilgileniyoruz ve bu verilere aşağıdaki genel API'den erişilebiliyor:

https://kauai.ccmc.gsfc.nasa.gov/DONKI/WS/get/CME?startDate=yyyy-MM-dd&endDate=yyyy-MM-dd

Bu API uç noktasının işlevselliğini doğrulamak istiyoruz.


Aşağıda test edilebilecek bazı fikirler yer alıyor. Bunların alakalı olup olmadığına
ve zamanınız olup olmadığına bağlı olarak uygun gördüklerinizi seçebilirsiniz. Testler
için istediğiniz araçları seçmekte özgürsünüz.

    Yanıt formatının doğru olup olmadığını ve JSON'un geçerli olup olmadığını doğrulayın.

    Beklenen tüm alanların mevcut olup olmadığını ve doğru veri türlerini içerip içermediğini
    kontrol edin.

    Uç noktanın beklenen sonuçları döndürdüğünden emin olmak için sorgu parametrelerinin
    farklı kombinasyonlarını test edin.

    Uç noktanın hataları ve geçersiz girdileri uygun HTTP hata kodları ve mesajları ile
    zarifçe ele alıp almadığını kontrol edin.

    Geniş zaman aralıkları için uç noktanın performansını test ederek makul bir sürede yanıt
    verdiğinden emin olun.


https://api.nasa.gov/
https://ccmc.gsfc.nasa.gov/tools/DONKI/
*/

    @Test
    public void testValidResponseFormat(){
    spec.pathParams("first","get","second","CME")
            .queryParams("startDate","2017-01-03","endDate","2017-01-03");

    Response response = given(spec).when().get("{first}/{second}");
    response.prettyPrint();

    response
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON);

    // Validate response has valid Json format
        try {
            JsonPath json = response.jsonPath();
        } catch (Exception e) {
            Assert.fail("Response is not a valid JSON"); // Eğer Json yapısına dönüştüremezzsem testim fail olur
        }
  }

  @Test
    public void testExpectedFieldsAndDataTypes(){
      spec.pathParams("first","get","second","CME")
              .queryParams("startDate","2017-01-03","endDate","2017-01-03");

      Response response = given(spec).when().get("{first}/{second}");
      response.prettyPrint();

      // Validate all fields present
      ValidateFieldsByMap.validateFields(response);
      ValidateFieldByPojo.validateFieldsByPojo(response);

      // Validate All fields have expected Data Types
      ValidateFieldsByMap.validateDataTypesOfFields(response);
      ValidateFieldByPojo.validateDataTypesOfFields(response);

}
    @Test
    public void testDefaultValues(){
        LocalDate currentDate = LocalDate.now();
        LocalDate expectedDate = currentDate.minusDays(30);

        System.out.println("expectedDate = " + expectedDate);
        spec.pathParams("first","get","second","CME");

        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

         String startTimeStr = response.jsonPath().getString("[0].startTime");
         String startTime = startTimeStr.split("T")[0];
         LocalDate startDate = LocalDate.parse(startTime);

         Assert.assertEquals(expectedDate,startDate);
         ValidateFieldsByMap.validateFields(response);
 }

    @Test(dataProvider = "queryParams",dataProviderClass = TestDatasForDataProvider.class)
    public void testQueryParamsCombinations(String startDate,String endDate){
        spec.pathParams("first","get","second","CME")
                .queryParams("startDate",startDate,"endDate",endDate);

        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        LocalDate startDateLocal = LocalDate.parse(startDate);
        LocalDate endDateLocal = LocalDate.parse(endDate);

        //String startTimeStr = response.jsonPath().getString("[0].startTime");
       // String startTime = startTimeStr.split("T")[0];
        List<Map<String,Object>> actualCMEList = response.as(new TypeRef<>() {});
        String startTime =(String) actualCMEList.getFirst().get("startTime");
        startTime = startTime.split("T")[0];

        String endTime = (String) actualCMEList.getLast().get("startTime");
        endTime = endTime.split("T")[0];

     //   Assert.assertEquals(startTime,startDate);
     //   Assert.assertEquals(endTime,endDate);

        for (Map<String,Object> CME : actualCMEList){
            String startTime1 = (String)CME.get("startTime");
            startTime1 = startTime1.split("T")[0];
            LocalDate CMEDate = LocalDate.parse(startTime1);

            Assert.assertTrue(CMEDate.isAfter(startDateLocal) ||CMEDate.isEqual(startDateLocal) );
            Assert.assertTrue(CMEDate.isBefore(endDateLocal) ||CMEDate.isEqual(endDateLocal) );
        }
  }

}
