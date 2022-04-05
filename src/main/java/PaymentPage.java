import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PaymentPage extends base{
    @FindBy(xpath = "//*[@id=\"payment-frame\"]/div/main/div/aside/div/div/div/div[2]/button")
    WebElement proceedButton;
    @FindBy(xpath = "//*[@id=\"OFFLINE\"]")
    WebElement bankDepositRadioButton;
    @FindBy(xpath = "//span[text()='Bank Deposit']")
    WebElement bankDepositText;
    @FindBy(xpath = "//span[text()='Pay on Delivery']")
    WebElement payOnDeliveryText;
    @FindBy(xpath = "//*[@id=\"PAY-ON-DELIVERY\"]")
    WebElement payOnDeliveryRadioButton;
    @FindBy(id = "wallet")
    WebElement walletCheckbox;
    @FindBy(id = "NET-BANKING")
    WebElement netBankingRadioButton;
    public PaymentPage()
    {
        PageFactory.initElements(driver,this);
    }
    public void paymentOption() throws InterruptedException {
        walletCheckbox.click();
        bankDepositRadioButton.click();
        Thread.sleep(10000);
        Assert.assertTrue(bankDepositRadioButton.isSelected());
        Assert.assertEquals(bankDepositText.getText(),"Bank Deposit");
    }
    public ConfirmationPage navigateToConfirmationPage(String paymentMethod) throws InterruptedException {
        if(paymentMethod.equalsIgnoreCase("WALLET"))
        {
            Assert.assertTrue(walletCheckbox.isSelected());
        }
        if(paymentMethod.equalsIgnoreCase("BANK DEPOSIT")) {
            walletCheckbox.click();
            bankDepositRadioButton.click();
        }
        if(paymentMethod.equalsIgnoreCase("PAY ON DELIVERY"))
        {
            walletCheckbox.click();
            payOnDeliveryRadioButton.click();
        }
        if(paymentMethod.equalsIgnoreCase("NET BANKING"))
        {
            walletCheckbox.click();
            netBankingRadioButton.click();
        }
        Thread.sleep(10000);
        proceedButton.click();
        Thread.sleep(10000);
        return new ConfirmationPage();
    }
}
