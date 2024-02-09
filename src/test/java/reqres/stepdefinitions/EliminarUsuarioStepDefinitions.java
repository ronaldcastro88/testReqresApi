package reqres.stepdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import reqres.exceptions.PortalReqresError;
import reqres.tasks.EliminaElUsuario;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class EliminarUsuarioStepDefinitions {
    @Cuando("^elimina el usuario$")
    public void eliminaElUsuario() {
        theActorInTheSpotlight().attemptsTo(EliminaElUsuario.delSistema());

    }

    @Entonces("^debe ver el status (\\d+) confirmando que el usuario fue eliminado$")
    public void debeVerElStatusConfirmandoQueElUsuarioFueEliminado(int status) {
        theActorInTheSpotlight().should(seeThatResponse("El código de respuesta es 204",
                response -> {
                    response.statusCode(status);
                    response.log().all();
                })
                .orComplainWith(PortalReqresError.class, PortalReqresError.STATUS_NO_OBTENIDO));
    }
}
