package testBase;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

public class BaseClass {

    public static WebDriver driver;
    public Logger logger;
    public ResourceBundle bundle;

   @BeforeClass(groups = {"Master","Sanity","Regression"})
   @Parameters("browser")
    public void setup(String br){
       if(br.equals("chrome")){
           driver = new ChromeDriver();
       }else if(br.equals("edge")){
           driver = new EdgeDriver();
       }else{
           driver= new FirefoxDriver();
       }
        bundle=ResourceBundle.getBundle("config");
        //driver.get("AppURL");

        logger = LogManager.getLogger(this.getClass());
       logger.info("Opening the URL");
       driver.get(bundle.getString("AppURL"));
        //driver.get("https://demo.guru99.com/insurance/v1/index.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    public String randomRegistrationEmail(){
        String registrationEmail = RandomStringUtils.randomAlphabetic(5);
        return (registrationEmail);
    }
    public String randomRegistrationUserFirstName(){
        String randomUser = RandomStringUtils.randomAlphabetic(8);
        return (randomUser);
    }
    public String randomRegistrationSirName(){
        String randomSirName = RandomStringUtils.randomAlphabetic(4);
        return (randomSirName);
    }

    public String randomRegistrationPhone(){
        String randomPhone = RandomStringUtils.randomNumeric(9);
        return (randomPhone);
    }
    public String randomPassword(){
        String str = RandomStringUtils.randomAlphabetic(5);

        String num = RandomStringUtils.randomAlphanumeric(4);
        return (str+"@"+num);
    }
    @AfterClass(groups = {"Master","Sanity","Regression"})
    public void tearDown() throws InterruptedException {
        logger.info("Tearing down. Test finished");
       Thread.sleep(15000);
        driver.quit();
    }
    public String captureScreen(String testName){
       String timesStamp = new SimpleDateFormat("dd.MM.yyy.hh.mm.ss").format(new Date());
        TakesScreenshot shot = (TakesScreenshot) driver;
        File source = shot.getScreenshotAs(OutputType.FILE);
        String destination =System.getProperty("user.dir")+"\\screenshots\\"+testName+"-"+timesStamp+".png";
        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (IOException e) {
            e.getMessage();
        }
        return destination;

    }
}