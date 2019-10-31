package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class CambiarTabs {

    //-----------------------------------Global Variables-----------------------------------
    //Declare a Webdriver variable
    private WebDriver driver;
    private ArrayList<String> tabs;

    public CambiarTabs(WebDriver driver) {
        this.driver = driver;
    }

    public void intercalarTabs(){
        //Ejecuciones de codigo de JavaScript
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        String googleWindow = "window.open('http://www.google.com')";
        javascriptExecutor.executeScript(googleWindow);
        tabs = new ArrayList<>(driver.getWindowHandles());

        //Cambio entre tabs
        Helpers helper = new Helpers();                                                helper.waitSeconds(1);
        driver.switchTo().window(tabs.get(0));                                         helper.waitSeconds(1);
        driver.switchTo().window(tabs.get(1)).navigate().to("http://www.bbva.mx");  helper.waitSeconds(1);
        driver.switchTo().window(tabs.get(0));
    }

}
