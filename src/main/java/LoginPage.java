import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class LoginPage extends base{
    @FindBy(xpath = "//div[text()='Shop by Category']")
    WebElement shopByCategoryText;
    @FindBy(xpath = "//div[text()='Top Brands']")
    WebElement topBrandsText;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/header[1]/div/div[1]/a/img")
    WebElement logo;
    @FindBy(xpath = "(//span[contains(@class,'text-13px text-center text-white leading-none lg:pt-1 hidden lg:block')])[4]")
    WebElement loginLink;
    @FindBy(name="mobileNumber")
    WebElement number;
    @FindBy(id="AcceptTermsConditions")
    WebElement termsAndConditionsCheckbox;
    @FindBy(xpath="//button[text()='Continue']")
    WebElement continueButton;
    @FindBy(name="otp")
    WebElement otp;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement finalContinueButton;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/header[1]/div/div[4]/ul/li[5]/button/span")
    WebElement myAccountText;
    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }
    public void logoCheck()
    {
        Assert.assertTrue(logo.isDisplayed());
    }
    public void displayOfShopByCategorySection()
    {
        Util.scrollTillElement(shopByCategoryText);
        Assert.assertTrue(shopByCategoryText.isDisplayed());
    }
    public void displayOfTopBrandsSection()
    {
        Util.scrollTillElement(topBrandsText);
        Assert.assertTrue(topBrandsText.isDisplayed());
    }
    public HomePage login(String mobileNumber) throws InterruptedException {
        loginLink.click();
        number.sendKeys(mobileNumber);
        termsAndConditionsCheckbox.click();
        continueButton.click();
        otp.sendKeys("1234");
        Thread.sleep(10000);
        finalContinueButton.click();
        Thread.sleep(10000);
        Assert.assertTrue(myAccountText.isDisplayed());
        return new HomePage();
    }

}
