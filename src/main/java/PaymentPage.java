import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PaymentPage extends base{
    @FindBy(xpath = "//*[@id=\"payment-frame\"]/div/main/div/aside/div/div/div/div[2]/button")
    WebElement proceedButton;
    @FindBy(xpath = "//*[@id=\"OFFLINE\"]")
    WebElement bankDepositRadioButton;
    @FindBy(xpath = "//*[@id=\"payment-frame\"]/div/main/div/main/div/div/ul/li[1]/label/div/div/span")
    WebElement bankDepositText;
    public PaymentPage()
    {
        PageFactory.initElements(driver,this);
    }
    public void paymentOption()
    {
        Assert.assertTrue(bankDepositRadioButton.isSelected());
        Assert.assertEquals(bankDepositText.getText(),"Bank Deposit");
    }
    public void navigateToConfirmationPage() throws InterruptedException {
        proceedButton.click();
        Thread.sleep(10000);
    }
}
