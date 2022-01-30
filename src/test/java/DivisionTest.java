import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivisionTest {

    @BeforeMethod
    public void preconditions() {
        System.out.println("Preconditions");
    }

    @DataProvider(name = "division")
    public Object[][] calculator() {
        return new Object[][]{
                {1.1, 0.1, 11, "Incorrect result 1.1/0.1"},
                {2.0, 3, 0.6666666666666666, "Incorrect result 2.0/3"},
                {0, 1, 0, "Incorrect result 0/1"},
                {5, -2, -2.5, "Incorrect result 5/(-2)"},
        };
    }

    @Test(dataProvider = "division", threadPoolSize = 2)
    public void divisionTest(double a, double b, double actualResult, String message) {
        double result = Calculator.division(a, b);
        System.out.println(result);
        Assert.assertEquals(result, actualResult, message);
    }

    @AfterMethod
    public void postConditions() {
        System.out.println("PostConditions");
    }

}
