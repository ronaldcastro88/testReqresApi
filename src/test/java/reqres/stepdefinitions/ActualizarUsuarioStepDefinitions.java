package reqres.stepdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import reqres.exceptions.PortalReqresError;
import reqres.tasks.ActualizarUsuario;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class ActualizarUsuarioStepDefinitions {
    @Cuando("^el envia los datos de actualizacion$")
    public void elEnviaLosDatosDeActualizacion() {
        String datosNuevos = "{\"name\":\"morpheus\",\"job\":\"zion resident\"}";
        theActorInTheSpotlight().attemptsTo(ActualizarUsuario.conInfoNueva(datosNuevos));
    }

    @Entonces("^debe ver el status (\\d+) con los datos nuevos del usuario$")
    public void debeVerElStatusConLosDatosNuevosDelUsuario(int status) {
        theActorInTheSpotlight().should(seeThatResponse("El código de respuesta es 200",
                response -> {
                    response.statusCode(200)
                            .body("name", equalTo("morpheus"))
                            .body("job", equalTo("zion resident"));
                    response.log().all();
                })
                .orComplainWith(PortalReqresError.class, PortalReqresError.STATUS_NO_OBTENIDO));
    }
}
