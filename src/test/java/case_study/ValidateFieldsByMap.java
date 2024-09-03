package case_study;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class ValidateFieldsByMap {
    public static void validateFields(Response response) {
        List<Map<String, Object>> actualCMEList = response.as(new TypeRef<>() {});
        for (Map<String, Object> CME : actualCMEList) {
            Assert.assertTrue(CME.containsKey("activityID"));
            Assert.assertTrue(CME.containsKey("catalog"));
            Assert.assertTrue(CME.containsKey("startTime"));
            Assert.assertTrue(CME.containsKey("instruments"));
            Assert.assertTrue(CME.containsKey("activeRegionNum"));
            Assert.assertTrue(CME.containsKey("cmeAnalyses"));
        }
    }

    public static void validateDataTypesOfFields(Response response) {
        List<Map<String, Object>> actualCMEList = response.as(new TypeRef<>() {});
        for (Map<String, Object> CME : actualCMEList) {
            Assert.assertTrue(CME.get("activityID") instanceof String );
            Assert.assertTrue(CME.get("catalog") instanceof String );
            Assert.assertTrue(CME.get("startTime") instanceof String );
            Assert.assertTrue(CME.get("instruments") instanceof List);
            if (CME.get("activeRegionNum")!=null){Assert.assertTrue(CME.get("activeRegionNum") instanceof String );}
            Assert.assertTrue(CME.get("cmeAnalyses") instanceof List);

        }
    }
}
