import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplicationTest {

    @BeforeMethod
    public void preconditions() {
        System.out.println("Preconditions");
    }

    @DataProvider(name = "multiplication")
    public Object[][] calculator() {
        return new Object[][]{
                {1.1, 0.1, 0.11000000000000001, "Incorrect result 1.1*0.1"},
                {2.0, 3, 6, "Incorrect result 2.0*3"},
                {0, 0, 0, "Incorrect result 0*0"},
                {0, -1, 0, "Incorrect result 0*(-1)"},
        };
    }

    @Test(dataProvider = "multiplication", invocationCount = 3)
    public void multiplicationTest(double a, double b, double actualResult, String message) {
        double result = Calculator.multiplication(a, b);
        System.out.println(result);
        Assert.assertEquals(result, actualResult, message);
    }

    @AfterMethod
    public void postConditions() {
        System.out.println("PostConditions");
    }

}
