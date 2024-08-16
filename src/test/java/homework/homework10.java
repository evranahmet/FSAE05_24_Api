package homework;

import base_urls.SpaceXBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertTrue;

public class homework10 extends SpaceXBaseUrl {

     /*
Given
    https://api.spacexdata.com/v3/launches
When
    User sends GET request
Then
    HTTP Status Code should be 200
And
    There are more than 100 launches
And
    "FalconSat" and "Starlink 4" are among the mission names
And
    The earliest launch year is 2006
And
    The latest launch year is 2020
And
    The number of successful launches is greater than 50
 */

    @Test
    public void test() {
        // Set Url
        spec.pathParam("first", "launches");

        // Send Request Get
        Response response = given(spec)
                .when()
                .get("{first}")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Do Assertions
        JsonPath json = response.jsonPath();

        //There are more than 100 launches
        List<Integer> launches = json.getList("flight_number");
        System.out.println("launches = " + launches);

        assertTrue(launches.size()>100);

        //"FalconSat" and "Starlink 4" are among the mission names
        List<Integer> missionName = json.getList("mission_name");
        System.out.println("missionName = " + missionName);

        Assert.assertTrue(missionName.contains("FalconSat") && missionName.contains("Starlink 4"));

        //The earliest launch year is 2006
        List<Integer> earliestLaunchYear = json.getList("launch_year",Integer.class);
        System.out.println("earliestLaunchYear = " + earliestLaunchYear);

        int earliestYear =2020;
        for (Integer year: earliestLaunchYear){
            if (year<earliestYear){
                earliestYear=year;
            }
        }
        System.out.println("earliestYear = " + earliestYear);
        Assert.assertEquals(earliestYear,2006);

        //The latest launch year is 2020
        int latestYear =0;
        for (Integer year: earliestLaunchYear){
            if (year>latestYear){
                latestYear=year;
            }
        }
        System.out.println("latestYear = " + latestYear);
        Assert.assertEquals(latestYear,2020);

        //The number of successful launches is greater than 50
        List<Boolean> launchSuccess = json.getList("launch_success",Boolean.class);
        System.out.println("launchSuccess = " + launchSuccess);

        int successfulLaunches =0;
        for (Boolean success: launchSuccess){
            if (success!=null && success==true){
                successfulLaunches++;
            }
        }
        System.out.println("successfulLaunches = " + successfulLaunches);
        Assert.assertTrue(successfulLaunches>50);
    }
}
