package co.com.sofka.webproject.test.controllers.checkoutpage;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import co.com.sofka.webproject.test.models.Customer;
import co.com.sofka.webproject.test.page.procesodecompra.CheckoutPage;


public class CheckoutPageWebController {

    private WebAction webAction;
    private Customer customer;


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setWebAction(WebAction webAction){
        this.webAction = webAction;
    }

    public void llenarFormularioDeCompra(){

        try{
            CheckoutPage checkoutPage = new CheckoutPage(webAction.getDriver());
            webAction.sendText(checkoutPage.getCompany(), customer.getCompany(), 2, true);
            webAction.click(checkoutPage.getCountry(), 2, true);
            webAction.sendText(checkoutPage.getCity(), customer.getCity(), 2 , true);
            webAction.sendText(checkoutPage.getAdress(), customer.getAddress(), 2 , true);
            webAction.sendText(checkoutPage.getPostalCode(), customer.getPostalCode(), 2 ,true);
            webAction.sendText(checkoutPage.getPhoneNumber(), customer.getPhoneNUmber(), 2, true);
            webAction.click(checkoutPage.getContinuar(), 2, true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al realizar la compra",e);
        }


    }

    public void realizarCompraSinAceptarTerminos(){

    }
}
