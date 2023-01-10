package co.com.sofka.webproject.test.runners.contact;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        features ={"src/main/resources/features/contact/contactoNoExitoso.feature"},
        glue={"co.com.sofka.webproject.test.stepdefinition.contact"},
        tags=""
)
public class ContactoNoExitosoRunner {
}
