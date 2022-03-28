import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends base{
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/main/div/aside/div/div/div/div[2]/button")
    WebElement proceedButtonToPaymentPage;
    public AddressPage()
    {
        PageFactory.initElements(driver,this);
    }
    public PaymentPage navigateToPaymentPage() throws InterruptedException {
        proceedButtonToPaymentPage.click();
        Thread.sleep(10000);
        return new PaymentPage();
    }
}
