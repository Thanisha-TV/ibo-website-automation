import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class base {
    public static WebDriver driver;
    public static Properties prop;
    public base() {
        try{
            prop = new Properties();
            FileInputStream file = new FileInputStream("./src/main/java/config.properties");
            prop.load(file);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initialization(String browser,String reqUrl){
        /*System.setProperty("webdriver.chrome.driver","//Users//thanisha//Documents//chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);*/
        if(browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().browserVersion("77.0.3865.40").setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--start-maximized");
            options.addArguments("--enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }
        if (browser.equalsIgnoreCase("Firefox"))
        {
            WebDriverManager.firefoxdriver().browserVersion("93.0").setup();
            FirefoxOptions options=new FirefoxOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            driver = new FirefoxDriver(options);
        }
        if(browser.equalsIgnoreCase("Safari"))
        {
            WebDriverManager.safaridriver().browserVersion("15.4").setup();
            SafariOptions options=new SafariOptions();
            driver = new SafariDriver(options);
        }
        if(browser.equalsIgnoreCase("Chrome-headless"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
        }
        if(browser.equalsIgnoreCase("Firefox-headless"))
        {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
            driver = new FirefoxDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        if(reqUrl.equalsIgnoreCase("Website"))
            driver.get(prop.getProperty("url"));
        if(reqUrl.equalsIgnoreCase("Command Center"))
            driver.get(prop.getProperty("commandCenterUrl"));
    }


}
