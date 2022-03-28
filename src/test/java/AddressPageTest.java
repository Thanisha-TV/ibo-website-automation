import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AddressPageTest extends base{
    LoginPage loginPage;
    public AddressPageTest()
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
