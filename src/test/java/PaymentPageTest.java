import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PaymentPageTest extends base{
    LoginPage loginPage;
    public PaymentPageTest()
    {
        super();
    }
    @BeforeMethod
    public void setUp()
    {
        initialization();
        loginPage=new LoginPage();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
}
