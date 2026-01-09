package constants;

public enum ConfigFile {
    APP_CONFIG("app.config.properties"),
    TEST_CONFIG("test.config.properties");

    private final String fileName;

    ConfigFile(String fileName){
        this.fileName = fileName;
    }

    public String getConfigFileName(){
        return fileName;
    }

}
