package co.com.sofka.webproject.test.controllers;

import co.com.sofka.webproject.test.models.Customer;
import co.com.sofka.webproject.test.page.RegisterPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class RegisterPageWebController {
    private WebAction webAction;
    private Customer customer;

    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setWebAction(WebAction webAction){
        this.webAction = webAction;
    }

    public void llenarCamposDeRegistro(){
        try{
            RegisterPage registerPagePage = new RegisterPage(webAction.getDriver());
            webAction.click(registerPagePage.getGenderMale(),true);
            webAction.sendText(registerPagePage.getFirstName(),customer.getFirstName(),2,true);
            webAction.sendText(registerPagePage.getLastName(),customer.getLastName(),2,true);
            webAction.sendText(registerPagePage.getEmail(),customer.getEmail(),true);
            webAction.sendText(registerPagePage.getPassword(),customer.getPassword(),true);
            webAction.sendText(registerPagePage.getConfirmPassword(),customer.getPassword(),true);
            webAction.click(registerPagePage.getRegisterButton(),2,true);
        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar crear la cuenta",e);
        }
    }

}
