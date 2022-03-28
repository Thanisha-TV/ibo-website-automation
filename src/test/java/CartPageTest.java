import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CartPageTest extends base{
    LoginPage loginPage;
    public CartPageTest()
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
