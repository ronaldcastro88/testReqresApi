package reqres.utils;

public enum SitioTest {

    URLBASEAPI ("https://reqres.in/api/");

    private final String url;

    SitioTest(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}