package reqres.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/CrearUsuario.feature",
        glue = {"reqres/stepdefinitions"},
        tags = {"@CreacionExitosaUsuario"},
        snippets = SnippetType.CAMELCASE
)
public class CrearUsuarioRunner {
}