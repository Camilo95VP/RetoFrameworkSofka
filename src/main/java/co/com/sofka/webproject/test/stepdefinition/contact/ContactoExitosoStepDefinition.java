package co.com.sofka.webproject.test.stepdefinition.contact;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import co.com.sofka.webproject.test.controllers.LoginPageWebController;
import co.com.sofka.webproject.test.controllers.RegisterPageWebController;
import co.com.sofka.webproject.test.controllers.checkoutpage.ModalTermsPageWebController;
import co.com.sofka.webproject.test.controllers.contact.ContactPageWebController;
import co.com.sofka.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.sofka.webproject.test.data.objects.TestInfo;
import co.com.sofka.webproject.test.models.Customer;
import co.com.sofka.webproject.test.stepdefinition.stup.GeneralSetUp;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import static co.com.sofka.webproject.test.helpers.Dictionary.COUNTRY_CODE;
import static co.com.sofka.webproject.test.helpers.Dictionary.EMAIL_DOMAIN;
import static co.com.sofka.webproject.test.helpers.Dictionary.MESSAGE_ERROR_TERMS;
import static co.com.sofka.webproject.test.helpers.Dictionary.MESSAGE_SUCCESSFULL_CONTACT;
import static co.com.sofka.webproject.test.helpers.Dictionary.SPANISH_CODE_LANGUAGE;
import static co.com.sofka.webproject.test.helpers.Helper.generateCustomer;

public class ContactoExitosoStepDefinition extends GeneralSetUp {
    private Customer customer;
    private WebAction webAction;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
        customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
    }
    @Dado("que el cliente navegó hasta la sección principal")
    public void queElClienteNavegóHastaLaSecciónPrincipal() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
    }

    @Cuando("el cliente se registre para realizar una solicitud de contacto")
    public void elClienteDiligenciaLaSolicitudDeContacto() {
        LoginPageWebController loginPageWebController = new LoginPageWebController();
        loginPageWebController.setWebAction(webAction);
        loginPageWebController.irHaciaRegisterPage();

        RegisterPageWebController registerPageWebController = new RegisterPageWebController();
        registerPageWebController.setCustomer(customer);
        registerPageWebController.setWebAction(webAction);
        registerPageWebController.llenarCamposDeRegistro();

        ContactPageWebController contactPageWebController= new ContactPageWebController();
        contactPageWebController.setWebAction(webAction);
        contactPageWebController.setCustomer(customer);
        contactPageWebController.diligenciarContactoExitoso();
    }

    @Entonces("el cliente podrá observar que se realizo la solicitud de contacto")
    public void elClientePodráObservarQueSeRealizoLaSolicitudDeContacto() {
        ContactPageWebController contacPageWebController=new ContactPageWebController();
        contacPageWebController.setWebAction(webAction);
        Assert.Hard.thatString(contacPageWebController.obtenerMensaje()).isEqualTo(MESSAGE_SUCCESSFULL_CONTACT);
    }

    @After
    public void cerrarDriver() throws WebActionsException {
        // Cerrar el driver
        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }

}
