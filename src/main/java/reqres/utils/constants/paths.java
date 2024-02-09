package reqres.utils.constants;

public enum paths {
    USUARIOS("users/2"),
    REGISTRO("register");

    private String path;

    paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
