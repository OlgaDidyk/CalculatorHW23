import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest {

    @BeforeMethod
    public void preconditions() {
        System.out.println("Preconditions");
    }

    @DataProvider(name = "sum")
    public Object[][] calculator() {
        return new Object[][]{
                {1.0, 0.1, 1.1, "Incorrect result 1.0+0.1"},
                {2, 3, 5, "Incorrect result 2+3"},
                {0, 0, 0, "Incorrect result 0+0"},
                {0, -1, -1, "Incorrect result 0+(-1)"},
        };
    }

    @Test(dataProvider = "sum", description = "Description for SumTest", priority = 1)
    public void sumTest(double a, double b, double actualResult, String message) {
        double result = Calculator.sum(a, b);
        System.out.println(result);
        Assert.assertEquals(result, actualResult, message);
    }

    @AfterMethod
    public void postConditions() {
        System.out.println("PostConditions");
    }


}
