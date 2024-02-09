package reqres.stepdefinitions;

import reqres.exceptions.PortalReqresError;
import reqres.questions.CodigoRespuesta;
import reqres.tasks.RegistrarUsuario;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static reqres.utils.SitioTest.URLBASEAPI;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearUsuarioStepDefinitions {

    @Dado("^(.*) ingresa al sitio de reqres$")
    public void ronaldIngresaAlSitioDeReqres(String actor) {
        theActorCalled(actor).whoCan(CallAnApi.at(URLBASEAPI.getUrl()));
    }

    @Cuando("^el envia los datos de creacion$")
    public void elEnviaLosDatosDeCreacion() {
        String datosBasicos = "{\"email\":\"eve.holt@reqres.in\",\"password\":\"pistol\"}";
        theActorInTheSpotlight().attemptsTo(RegistrarUsuario.ConLosDatos(datosBasicos));
    }

    @Entonces("^debe ver el status (\\d+)$")
    public void debeVerElStatus(int status) {
        theActorInTheSpotlight().should(seeThat("El código de respuesta", new CodigoRespuesta(), equalTo(status))
                .orComplainWith(PortalReqresError.class, PortalReqresError.STATUS_NO_OBTENIDO));
    }
}
