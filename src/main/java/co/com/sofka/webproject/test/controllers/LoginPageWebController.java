package co.com.sofka.webproject.test.controllers;

import co.com.sofka.webproject.test.page.LandingPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class LoginPageWebController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;}

    public void irHaciaRegisterPage(){
        try{
            LandingPage landingPage = new LandingPage(webAction.getDriver());
            webAction.click(landingPage.getRegister(),2,true);
        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar ir a la pagina de registro",e);
        }
    }

}
