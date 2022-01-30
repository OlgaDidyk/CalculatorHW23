import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubtractionTest {

    @BeforeMethod
    public void preconditions() {
        System.out.println("Preconditions");
    }

    @DataProvider(name = "subtraction")
    public Object[][] calculator() {
        return new Object[][]{
                {1.1, 0.1, 1, "Incorrect result 1.1-0.1"},
                {2.0, 3, -1, "Incorrect result 2.0-3"},
                {0, 1, -1, "Incorrect result 0-1"},
                {5, -2, 7, "Incorrect result 5-(-2)"},
        };
    }

    @Test(dataProvider = "subtraction")
    public void subtractionTest(double a, double b, double actualResult, String message) {
        double result = Calculator.subtraction(a, b);
        System.out.println(result);
        Assert.assertEquals(result, actualResult, message);
    }

    @AfterMethod
    public void postConditions() {
        System.out.println("PostConditions");
    }

}
