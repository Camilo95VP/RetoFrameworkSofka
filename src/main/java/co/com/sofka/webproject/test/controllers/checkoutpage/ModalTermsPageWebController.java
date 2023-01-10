package co.com.sofka.webproject.test.controllers.checkoutpage;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import co.com.sofka.webproject.test.page.procesodecompra.ModalTermsPage;

public class ModalTermsPageWebController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }
    public String obtenerMensaje(){
        String texto="";
        try {
            ModalTermsPage modalPage = new ModalTermsPage(webAction.getDriver());
            texto = webAction.getText(modalPage.getModalErrorTerms(), 2, true);
            System.out.println(texto);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrió un error al intentar validar el mensaje", e);
        }
        return texto;
    }
}
