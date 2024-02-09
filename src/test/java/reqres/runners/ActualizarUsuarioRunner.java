package reqres.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/ActualizarUsuario.feature",
        glue = {"reqres/stepdefinitions"},
        tags = {"@ActualizacionExitosaUsuario"},
        snippets = SnippetType.CAMELCASE
)
public class ActualizarUsuarioRunner {
}