package pages.properties;

public enum TestProperties {
    LOGIN_PAGE("login.page.properties"),
    LOGOUT_PAGE("logout.page.properties"),
    ADMIN_PAGE("addUser.page.properties");
    private final String fileName;

    TestProperties(String fileName){
        this.fileName = fileName;
    }

    public String getTestPropertiesFileName(){
        return fileName;
    }

    
}
