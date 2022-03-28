import org.openqa.selenium.support.FindBys;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class LoginPage extends base{
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
    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }
    public HomePage login(String mobileNumber) throws InterruptedException {
        loginLink.click();
        //Thread.sleep(10000);
        //Set<String> allWindowHandles = driver.getWindowHandles();
        //driver.switchTo().window(String.valueOf(1));
        number.sendKeys(mobileNumber);
        termsAndConditionsCheckbox.click();
        continueButton.click();
        otp.sendKeys("1234");
        Thread.sleep(10000);
        finalContinueButton.click();
        Thread.sleep(10000);
        return new HomePage();
    }
    public void validateHomePageTitle()
    {
        String title=driver.getTitle();
        Assert.assertEquals(title,"IBO - Home building – all under one roof");
    }
}
