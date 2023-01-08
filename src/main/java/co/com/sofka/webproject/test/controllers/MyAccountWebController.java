package co.com.sofka.webproject.test.controllers;

import co.com.sofka.webproject.test.page.MyAccountPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class MyAccountWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerNombreDeNuevoUsuario(){
        String label = "";
        String email = "";
        try {
            MyAccountPage myAccountPage = new MyAccountPage(webAction.getDriver());
            label = webAction.getText(myAccountPage.getRegisterCompletedLabel(), 2, true);
            email = webAction.getText(myAccountPage.getRegistredEmail(),2,true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrió un error al intentar validar el mensaje", e);
        }
        return label;
    }
}
