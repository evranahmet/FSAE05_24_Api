package case_study;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import pojos.CMEpojo.CMEPojo;
import pojos.CMEpojo.CmeAnalysesItem;
import pojos.CMEpojo.InstrumentsItem;

import java.util.List;
import java.util.Map;

public class ValidateFieldByPojo {
    public static void validateFieldsByPojo(Response response){
       List<CMEPojo> actualCMElist =  response.as(new TypeRef<>() {});
        for (CMEPojo CME : actualCMElist) {
            String CMEStr = CME.toString();
            Assert.assertTrue(CMEStr.contains("activityID"));
            Assert.assertTrue(CMEStr.contains("catalog"));
            Assert.assertTrue(CMEStr.contains("startTime"));
            Assert.assertTrue(CMEStr.contains("instruments"));
            Assert.assertTrue(CMEStr.contains("activeRegionNum"));
        }
    }

    public static void validateDataTypesOfFields(Response response) {
        List<CMEPojo> actualCMEList = response.as(new TypeRef<>() {});
        for (CMEPojo CME : actualCMEList){
            Assert.assertTrue(CME.getActivityID() instanceof String);
            Assert.assertTrue(CME.getCatalog() instanceof String);
            Assert.assertTrue(CME.getStartTime() instanceof String);
            Assert.assertTrue(CME.getInstruments() instanceof List<InstrumentsItem>);
            Assert.assertTrue(CME.getSourceLocation() instanceof String);
            Assert.assertTrue(CME.getCmeAnalyses() instanceof List<CmeAnalysesItem>);
        }
    }
}
