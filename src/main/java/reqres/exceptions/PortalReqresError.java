package reqres.exceptions;

public class PortalReqresError extends AssertionError {
    public static final String STATUS_NO_OBTENIDO = "El usuario no obtuvo el status esperado";

    public PortalReqresError(String message) {
        super(message);
    }

    public PortalReqresError(String message, Throwable cause) {
        super(message, cause);
    }
}
