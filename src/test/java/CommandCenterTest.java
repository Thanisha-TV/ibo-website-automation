import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class CommandCenterTest extends base{
    CommandCenter commandCenter;
    public CommandCenterTest()
    {
        super();
    }
    @BeforeMethod
    public void setUp()
    {
        initialization("Command Center");
        commandCenter=new CommandCenter();
    }
    @Test(description = "Validate Add Money To Wallet")
    @Severity(SeverityLevel.CRITICAL)
    public void addMoneyToWallet() throws InterruptedException {
        Thread.sleep(5000);
        commandCenter.loginToCommandCenter(prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("customer_Id"));
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
}
