import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends base{
    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div[2]/div[2]/div[1]/div[1]/div/div/span[2]")
    WebElement orderNumber;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div[1]/div/div[2]/button")
    WebElement continueShoppingButton;
    public static String orderNum;
    public ConfirmationPage()
    {
        PageFactory.initElements(driver,this);
    }
    public HomePage navigateToHomePage() throws InterruptedException {
        Thread.sleep(5000);
        orderNum=orderNumber.getText();
        continueShoppingButton.click();
        Thread.sleep(5000);
        return new HomePage();
    }
}
