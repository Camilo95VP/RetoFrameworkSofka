package co.com.sofka.webproject.test.stepdefinition;

import co.com.sofka.webproject.test.controllers.LoginPageWebController;
import co.com.sofka.webproject.test.controllers.MyAccountWebController;
import co.com.sofka.webproject.test.controllers.RegisterPageWebController;
import co.com.sofka.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.sofka.webproject.test.data.objects.TestInfo;
import co.com.sofka.webproject.test.models.Customer;
import co.com.sofka.webproject.test.stepdefinition.stup.GeneralSetUp;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import static co.com.sofka.webproject.test.helpers.Dictionary.*;
import static co.com.sofka.webproject.test.helpers.Helper.generateCustomer;

public class CrearNuevaCuentaStepDefinition extends GeneralSetUp {

    private WebAction webAction;
    private Customer customer;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
        customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
    }

    @Dado("que el cliente navegó a la página de inicio")
    public void queElClienteNavegoALaPaginaDeInicio() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
    }

    @Cuando("el cliente registra sus datos para una cuenta en línea de forma exitosa")
    public void elClienteRegistraSusDatosParaUnaCuentaEnLineaDeFormaExitosa() {
        LoginPageWebController loginPageWebController = new LoginPageWebController();
        loginPageWebController.setWebAction(webAction);
        loginPageWebController.irHaciaRegisterPage();

        RegisterPageWebController registerPageWebController = new RegisterPageWebController();
        registerPageWebController.setCustomer(customer);
        registerPageWebController.setWebAction(webAction);
        registerPageWebController.llenarCamposDeRegistro();
    }

    @Entonces("como resultado el usuario quedará logueado dentro de su respectiva sesión per se")
    public void comoResultadoElUsuarioQuedaraLogueadoDentroDeSuRespectivaSesionPerSe() {
        MyAccountWebController myAccountWebController = new MyAccountWebController();
        myAccountWebController.setWebAction(webAction);

        //Assert.Hard.thatString(myAccountWebController.obtenerNombreDeNuevoUsuario()).isEqualTo(customer.getEmail());
        Assert.Hard.thatString(myAccountWebController.obtenerNombreDeNuevoUsuario()).isEqualTo("Your registration completed");
        //Assert.Hard.thatString(myAccountWebController.obtenerNombreDeNuevoUsuario()).contains("registration");
    }

    @After
    public void tearDown() throws WebActionsException {
        webAction.pause(5, false);
        // Cerrar el driver
        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }


}
