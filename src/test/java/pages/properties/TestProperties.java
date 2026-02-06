package pages.properties;

public enum TestProperties {
    LOGIN_PAGE("login.config.properties"),

    HOME_PAGE("homepage.config.properties");

    private final String fileName;

    TestProperties(String fileName){
        this.fileName = fileName;
    }

    public String getTestPropertiesFileName(){
        return fileName;
    }

}
