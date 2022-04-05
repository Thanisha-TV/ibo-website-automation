import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.WeakHashMap;

public class CommandCenter extends base{
     @FindBy(xpath = "//input[@id='basic_username']")
     WebElement usernameField;
     @FindBy(xpath = "//input[@id='basic_password']")
     WebElement passwordField;
     @FindBy(xpath = "//*[@id=\"basic\"]/div[3]/div/div/div/button/span")
     WebElement submitButton;
     @FindBy(xpath = "//*[@id='root']/div/section/aside/div/ul/li[8]/div/span")
     WebElement wallet;
     @FindBy(xpath = "//a[text()='Wallet Update']")
     WebElement walletUpdate;
     @FindBy(id = "action")
     WebElement actionDropdown;
     @FindBy(xpath = "//div[text()='Advance Addition to Wallet']")
     WebElement advanceAdditionToWallet;
     @FindBy(id = "customer_id")
     WebElement customerId;
     @FindBy(id = "customer_id_confirm")
     WebElement confirmCustomerId;
     @FindBy(id = "amount")
     WebElement amount;
     @FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div[2]/div/div/div/div/form/div[3]/div[2]/div/div[2]/div/div/div/div/span[2]")
     WebElement reasonDropdown;
    @FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/div[1]/div/div/div[2]/div")
    WebElement advanceText;
     @FindBy(id = "advance_reference_number")
     WebElement advanceReferenceNumber;
     @FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div[2]/div/div/div/div/form/div[5]/div[2]/div/div/div/div/button")
     WebElement saveButton;
     @FindBy(xpath = "/html/body/div[4]/div/div[2]/div/div[2]/div/div/div[1]/div/h4/mark/p/span[3]")
     WebElement totalAmt;
     @FindBy(xpath = "//span[text()='Confirm']")
     WebElement confirmButton;
     @FindBy(xpath = "//span[text()='Ok']")
     WebElement okButton;
     public CommandCenter()
     {
         PageFactory.initElements(driver,this);
     }
     public void loginToCommandCenter(String user,String pass,String cusId) throws InterruptedException {
         usernameField.sendKeys(user);
         passwordField.sendKeys(pass);
         submitButton.click();
         Thread.sleep(5000);
         wallet.click();
         walletUpdate.click();
         Thread.sleep(5000);
         actionDropdown.click();
         advanceAdditionToWallet.click();
         customerId.sendKeys(cusId);
         confirmCustomerId.sendKeys(cusId);
         amount.sendKeys("1");
         Thread.sleep(5000);
         reasonDropdown.click();
         advanceText.click();
         advanceReferenceNumber.sendKeys("1234");
         saveButton.click();
         Thread.sleep(5000);
         String text=totalAmt.getText();
         Assert.assertNotNull(text);
         confirmButton.click();
         Thread.sleep(5000);
         okButton.click();
     }
}
