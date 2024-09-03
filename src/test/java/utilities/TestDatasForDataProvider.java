package utilities;

import org.testng.annotations.DataProvider;

public class TestDatasForDataProvider {

    @DataProvider(name = "queryParams")
    public Object[][] createQueryParams(){
        return new Object[][]{
            {"2022-02-03","2022-02-05"},
            {"2022-03-29","2022-04-01"},
            {"2023-11-03","2023-11-09"},
            {"2024-02-03","2024-02-12"},
            {"2024-07-03","2024-07-28"}
        };
    }
}
