package reqres.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static reqres.utils.constants.paths.USUARIOS;

public class EliminaElUsuario implements Task {

    public static Performable delSistema() {
        return instrumented(EliminaElUsuario.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(USUARIOS.getPath()));
    }
}
