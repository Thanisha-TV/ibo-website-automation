import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage extends base{
    @FindBy(xpath = "//span[text()='Proceed to buy']")
    WebElement proceedButtonToAddressPage;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/aside/div[1]/div/div/div[1]/div[3]/div[2]")
    WebElement totalPrice;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/main/div/div/div[2]/div[1]/button/span[2]")
    WebElement removeButton;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/main/div/h5/span")
    WebElement emptyCartText;
    public CartPage()
    {
        PageFactory.initElements(driver,this);
    }
    public void totalPriceCheck()
    {
        Assert.assertNotNull(totalPrice);
    }
    public void deleteProduct() throws InterruptedException {
        removeButton.click();
        Thread.sleep(10000);
        Assert.assertTrue(emptyCartText.isDisplayed());

    }
    public AddressPage navigateToAddressPage() throws InterruptedException {
        proceedButtonToAddressPage.click();
        Thread.sleep(10000);
        return new AddressPage();
    }
}
