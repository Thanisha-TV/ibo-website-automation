import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    public static WebDriver driver;
    public static Properties prop;
    public base() {
        try{
            prop = new Properties();
            FileInputStream file = new FileInputStream("/Users/thanisha/IdeaProjects/ibo-website-automation/src/main/java/config.properties");
            prop.load(file);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initialization(){
        System.setProperty("webdriver.chrome.driver","//Users//thanisha//Documents//chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }


}
