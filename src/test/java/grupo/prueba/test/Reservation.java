package grupo.prueba.test;

import grupo.prueba.test.CommonConditions;
import org.testng.annotations.Test;
import grupo.prueba.pages.PageFactoryLogin;
import grupo.prueba.pages.PageReservation;

public class Reservation extends CommonConditions {

    @Test(enabled = false, description = "Seleccionando combos en pagina de reservacion")
    public void seleccionCombos () {
        PageFactoryLogin pageLogin = new PageFactoryLogin(driver);
        //PageLogin pageLogin = new PageLogin(driver);
        PageReservation pageReservation = new PageReservation(driver);
        pageLogin.login("mercury","mercury");

        pageReservation.selectPassengers(2);
        pageReservation.selectFromPort(3);
        pageReservation.selectToPort("London");
    }

}

