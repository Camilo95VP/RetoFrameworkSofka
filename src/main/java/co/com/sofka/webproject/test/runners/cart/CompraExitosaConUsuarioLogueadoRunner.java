package co.com.sofka.webproject.test.runners.cart;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        features ={"src/main/resources/features/cart/compraExitosaConUsuarioLogueado.feature"},
        glue={"co.com.sofka.webproject.test.stepdefinition.cart"},
        tags=""
)
public class CompraExitosaConUsuarioLogueadoRunner {
}
