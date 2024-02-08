package reqres.stepdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import reqres.exceptions.PortalReqresError;
import reqres.tasks.ConsultarUsuario;
import reqres.tasks.ObtenerListadoUsuarios;
import reqres.tasks.UsuarioInexistente;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class ObtenerUsuariosStepDefinitions {

    //Actor ronald;
    @Cuando("^consulta el listado de usuarios$")
    public void consultaElListadoDeUsuarios() {
        theActorInTheSpotlight().attemptsTo(ObtenerListadoUsuarios.conListado());
    }

    @Entonces("^debe ver cada usuario con sus caracteristicas$")
    public void debeVerCadaUsuarioConSusCaracteristicas() {
        theActorInTheSpotlight().should(seeThatResponse("El código de respuesta es 200",
                response -> {
                    response.statusCode(200)
                            .body("page", equalTo(2))
                            .body("per_page", equalTo(6))
                            .body("total",equalTo(12));
                    response.log().all();
                })
                .orComplainWith(PortalReqresError.class, PortalReqresError.STATUS_NO_OBTENIDO));
    }

    @Cuando("^consulta un usuario$")
    public void consultaUnUsuario() {
        theActorInTheSpotlight().attemptsTo(ConsultarUsuario.paraDatosBasicos());
    }

    @Entonces("^debe ver los datos del usuario consultado$")
    public void debeVerLosDatosDelUsuarioConsultado() {
        theActorInTheSpotlight().should(seeThatResponse("El código de respuesta es 200",
                response -> {
                    response.statusCode(200)
                            .body("data.id", equalTo(2))
                            .body("data.email", equalTo("janet.weaver@reqres.in"))
                            .body("data.first_name",equalTo("Janet"))
                            .body("data.last_name",equalTo("Weaver"));
                    response.log().all();
                })
                .orComplainWith(PortalReqresError.class, PortalReqresError.STATUS_NO_OBTENIDO));
    }

    @Cuando("^consulta un usuario que no existe en el portal$")
    public void consultaUnUsuarioQueNoExisteEnElPortal() {
        theActorInTheSpotlight().attemptsTo(UsuarioInexistente.enElPortal());
    }

    @Entonces("^el usuario no debe existir y no muestra datos del mismo$")
    public void elUsuarioNoDebeExistirYNoMuestraDatosDelMismo() {
        theActorInTheSpotlight().should(seeThatResponse("El código de respuesta es 404",
                response -> {
                    response.statusCode(404);
                    response.log().all();
                })
                .orComplainWith(PortalReqresError.class, PortalReqresError.STATUS_NO_OBTENIDO));
    }
}
