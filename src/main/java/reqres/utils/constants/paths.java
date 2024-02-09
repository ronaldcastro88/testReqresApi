package reqres.utils.constants;

public enum paths {
    USERS("users/2");

    private String path;

    paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
