package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.PageFactoryLogin;
import pages.PageLogon;
import pages.PageReservation;

public class Login extends CommonConditions{
    private static final Logger LOGGER = LogManager.getLogger(Login.class);

    @Test(enabled = true, description = "Login Incorrecto")
    public void loginIncorrecto () {                                                                                    LOGGER.info("Estoy en método LoginIncorrecto");
        //CambiarTabs cambiarTabs = new CambiarTabs(driver); cambiarTabs.intercalarTabs();

        PageFactoryLogin pageLogin = new PageFactoryLogin(driver);
        //PageLogin pageLogin = new PageLogin(driver);
        PageLogon pageLogon = new PageLogon(driver);
        pageLogin.login("user","user");
        pageLogon.assertPage();
    }

    @Test(enabled = false, description = "Login Correcto")
    public void loginCorrecto () {
        PageFactoryLogin pageLogin = new PageFactoryLogin(driver);
        //PageLogin pageLogin = new PageLogin(driver);
        PageReservation pageReservation = new PageReservation(driver);
        pageLogin.login("mercury","mercury");
        pageReservation.assertPage();
    }

    @Test(enabled = false, description = "Prueba cantidad de campos 'input'")
    public void pruebaCantidadDeCampos () {
        PageFactoryLogin pageLogin = new PageFactoryLogin(driver);
        //PageLogin pageLogin = new PageLogin(driver);
        pageLogin.verifyFields();
    }

    @Test(enabled = false, description = "Verificar titulo correcto en el login")
    public void pruebaVerificarTitulo () {
        PageFactoryLogin pageLogin = new PageFactoryLogin(driver);
        //PageLogin pageLogin = new PageLogin(driver);
        pageLogin.verifyTitle();
    }

}
