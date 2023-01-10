package co.com.sofka.webproject.test.controllers.contact;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import co.com.sofka.webproject.test.models.Customer;
import co.com.sofka.webproject.test.page.contact.ContactPage;
import co.com.sofka.webproject.test.page.procesodecompra.ModalTermsPage;
import co.com.sofka.webproject.test.page.procesodecompra.ProductosPage;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import static co.com.sofka.webproject.test.helpers.Seconds.TWENTY_SECONDS;
import static org.openqa.selenium.By.xpath;

public class ContactPageWebController {
    private WebAction webAction;
    private Customer customer;
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void diligenciarContactoExitoso(){
        try {
            ContactPage contactPage = new ContactPage(webAction.getDriver());
            webAction.click(contactPage.getBtn_contact_us(), TWENTY_SECONDS.getValue(), true);

            webAction.sendText(contactPage.getEnquiry(),customer.getEnquiry(),TWENTY_SECONDS.getValue(),true);
            webAction.click(contactPage.getBtn_submit(),TWENTY_SECONDS.getValue(),true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al agregar los productos al carrito",e);
        }
    }

    public void diligenciarContactoNoExitoso(){
        try {
            ContactPage contactPage = new ContactPage(webAction.getDriver());
            webAction.click(contactPage.getBtn_contact_us(), TWENTY_SECONDS.getValue(), true);
            webAction.click(contactPage.getBtn_submit(),TWENTY_SECONDS.getValue(),true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al agregar los productos al carrito",e);
        }
    }

    public String obtenerMensaje(){
        String texto="";
        try {
            ContactPage contactPage = new ContactPage(webAction.getDriver());
            texto = webAction.getText(contactPage.getMessage_successfull(), 2, true);
            System.out.println(texto);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrió un error al intentar validar el mensaje", e);
        }
        return texto;
    }

    public String obtenerMensajeFallido(){
        String texto="";
        try {
            ContactPage contactPage = new ContactPage(webAction.getDriver());
            texto = webAction.getText(contactPage.getMessage_unsuccessfull(), 2, true);
            System.out.println(texto);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrió un error al intentar validar el mensaje", e);
        }
        return texto;
    }
}
