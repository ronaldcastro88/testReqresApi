package reqres.stepdefinitions;

import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import reqres.utils.SitioTest;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hooks {

    private String urlBase;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        urlBase = SitioTest.URLBASEAPI.getUrl();
        theActorCalled("actor");
        theActorInTheSpotlight().whoCan(CallAnApi.at(urlBase));
    }
}