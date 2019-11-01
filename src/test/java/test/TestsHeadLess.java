package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PageFactoryLogin;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageReservation;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestsHeadLess {

    //-----------------------------------Global Variables-----------------------------------
    //Declare a Webdriver variable
    private WebDriver driver;
    private ArrayList<String> tabs;

    //Declare a test URL variable
    private String testURL = "http://newtours.demoaut.com/";

    //-----------------------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest () {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        //Chrome Options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("--whitelist-ips 0.0.0.0");
        //chromeOptions.addArguments("--port=9515");

        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to(testURL);
    }

    //-----------------------------------Tests-----------------------------------
    @Test(enabled = true, description = "Login Incorrecto")
    public void loginIncorrecto () {
        //CambiarTabs cambiarTabs = new CambiarTabs(driver); cambiarTabs.intercalarTabs();

        PageFactoryLogin pageLogin = new PageFactoryLogin(driver);
        PageLogon pageLogon = new PageLogon(driver);
        pageLogin.login("user","user");
        pageLogon.assertPage();
    }

    @Test(enabled = false, description = "Login Correcto")
    public void loginCorrecto () {
        PageLogin pageLogin = new PageLogin(driver);
        PageReservation pageReservation = new PageReservation(driver);
        pageLogin.login("mercury","mercury");
        pageReservation.assertPage();
    }

    @Test(enabled = false, description = "Seleccionando combos")
    public void seleccionCombos () {
        PageLogin pageLogin = new PageLogin(driver);
        PageReservation pageReservation = new PageReservation(driver);
        pageLogin.login("mercury","mercury");

        pageReservation.selectPassengers(2);
        pageReservation.selectFromPort(3);
        pageReservation.selectToPort("London");
    }

    @Test(enabled = false, description = "Prueba cantidad de campos 'input'")
    public void pruebaCantidadDeCampos () {
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.verifyFields();
    }

    @Test(enabled = true, description = "Verificar titulo correcto en el login")
    public void pruebaVerificarTitulo () {
        PageFactoryLogin pageLogin = new PageFactoryLogin(driver);
        pageLogin.verifyTitle();
    }

    //-----------------------------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest (ITestResult result){
        System.out.println("El test > "+ result.getMethod().getDescription() + " resultó: "+result.getStatus());
        //if(!result.isSuccess()){ System.out.println("Fallo el test > "+ result.getMethod().getDescription()); }
        driver.quit();
    }

}
