import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PdpPage extends base{
    Util obj=new Util();
    @FindBy(xpath = "//span[text()='Add to cart']")
    WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/header[1]/div/div[4]/ul/li[7]/span[1]/a/span")
    WebElement cartLink;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/div/div[2]/div[2]/div[1]/div/span")
    WebElement price;
    @FindBy(xpath = "//button[text()='+']")
    WebElement plusSign;
    @FindBy(xpath = "//input[@value='2']")
    WebElement quantity;
    public PdpPage()
    {
        PageFactory.initElements(driver,this);
    }
    public void priceDisplay()
    {
        Assert.assertTrue(price.isDisplayed());
    }
    public void updateQuantity() throws InterruptedException {
        Util.scrollTillElement(plusSign);
        Thread.sleep(10000);
        plusSign.click();
        Thread.sleep(10000);
        String productQuantity=quantity.getAttribute("value");
        Assert.assertEquals(productQuantity,"2");
    }
    public CartPage addItemToCart() throws InterruptedException {
        Util.scrollTillElement(addToCartButton);
        addToCartButton.click();
        Thread.sleep(10000);
        cartLink.click();
        Thread.sleep(10000);
        return new CartPage();
    }
}
