package co.com.sofka.webproject.test.controllers.checkoutpage;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import co.com.sofka.webproject.test.page.procesodecompra.ConfirmationPage;

public class ConfirmationPageWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }
    public String obtenerMensaje(){
        String texto="";
        try {
            ConfirmationPage confirmationPage = new ConfirmationPage(webAction.getDriver());
            texto = webAction.getText(confirmationPage.getMensajeCompraExitosa(), 2, true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrió un error al intentar validar el mensaje", e);
        }
        return texto;
    }
}
