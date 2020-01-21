package grupo.prueba.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CommonConditions {
    //-----------------------------------Global Variables-----------------------------------
    //Declare a Webdriver variable
    private boolean headLessSelected = false;
    WebDriver driver;
    ArrayList<String> tabs;

    //Declare a test URL variable
    private String testURL = "http://newtours.demoaut.com/";

    //-----------------------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest () {

        DesiredCapabilities caps = new DesiredCapabilities(); //since selenium 3.0
        //We have selected the driver in System Path

        //Driver selected by OS
        String driverByOS;
        if(System.getProperty("os.name").equals("Windows 10")){
            driverByOS = "E:\\Software Repository\\Drivers Selenium\\Widnows10\\chromedriver.exe"; System.out.println("Driver selected: "+System.getProperty("os.name"));
        }
        else driverByOS = "drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver",driverByOS);

        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^HEADLESS
        if(headLessSelected){
            System.out.println("HEADLESS selected!");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            /*
            //chromeOptions.addArguments("--whitelist-ips 0.0.0.0");
            //chromeOptions.addArguments("--port=9515");
             */
            driver = new ChromeDriver(chromeOptions);
        }
        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^NORMAL
        else {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            /*
            //driver.manage().window().fullscreen();
            //driver.manage().window().setSize(new Dimension(800,700));
            //driver.manage().window().setPosition(new Point(50,50));
             */
        }


        /* //With Firefox
        System.setProperty("webdriver.gecko.driver", "E:\\Software Repository\\Drivers Selenium\\Widnows10\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette",true);
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        */

        driver.navigate().to(testURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    //-----------------------------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest (ITestResult result){
        System.out.println("El test > "+ result.getMethod().getDescription() + ", resultó: "+result.getStatus());
        //if(!result.isSuccess()){ System.out.println("Fallo el test > "+ result.getMethod().getDescription()); }
        driver.quit();
    }

}
