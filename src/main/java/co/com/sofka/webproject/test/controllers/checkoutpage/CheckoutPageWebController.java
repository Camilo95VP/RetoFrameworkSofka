package co.com.sofka.webproject.test.controllers.checkoutpage;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import co.com.sofka.webproject.test.models.Customer;
import co.com.sofka.webproject.test.page.procesodecompra.CheckoutPage;
import org.openqa.selenium.WebElement;

import static co.com.sofka.webproject.test.helpers.Seconds.TEN_SECONDS;
import static co.com.sofka.webproject.test.helpers.Seconds.TWO_SECONDS;


public class CheckoutPageWebController {

    private static WebAction webAction;
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
            webAction.sendText(checkoutPage.getCompany(), customer.getCompany(), TWO_SECONDS.getValue(), true);
            webAction.selectByPartialText(checkoutPage.getCountry(), customer.getCountry(), TWO_SECONDS.getValue(),true);
            webAction.sendText(checkoutPage.getCity(), customer.getCity(), TWO_SECONDS.getValue() , true);
            webAction.sendText(checkoutPage.getAdress(), customer.getAddress(), TWO_SECONDS.getValue() , true);
            webAction.sendText(checkoutPage.getPostalCode(), customer.getPostalCode(), TWO_SECONDS.getValue() ,true);
            webAction.sendText(checkoutPage.getPhoneNumber(), customer.getPhoneNUmber(), TWO_SECONDS.getValue(), true);
            webAction.click(checkoutPage.getContinuar(), TEN_SECONDS.getValue(), true);
            webAction.click(checkoutPage.getContinuar2(),TEN_SECONDS.getValue(),true);
            webAction.click(checkoutPage.getContinuar3(),TEN_SECONDS.getValue(),true);
            webAction.click(checkoutPage.getContinuar4(),TEN_SECONDS.getValue(),true);
            webAction.click(checkoutPage.getContinuar5(),TEN_SECONDS.getValue(),true);
            webAction.click(checkoutPage.getConfirmar(),TEN_SECONDS.getValue(),true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al realizar la compra",e);
        }


    }



}
