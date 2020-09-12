package com.selenium.utilities;

public final class TestConstants {

    public static final String CONFIG_DIR;
    public static final String OR_DIR;
    public static final String TARGET_ENV;
    public static final String Path_TestData = System.getProperty("user.dir")+"\\config\\data.xlsx";

    public static final int PAUSE_MILLIS;

    static {
        if (System.getProperty("config.dir") == null) {
            CONFIG_DIR = "config";
        } else {
            CONFIG_DIR = System.getProperty("config.dir");
        }
        
        if (System.getProperty("OR.dir") == null) {
            OR_DIR = "OR";
        } else {
            OR_DIR = System.getProperty("OR.dir");
        }
        
        if (System.getProperty("test.env") == null) {
            TARGET_ENV = "qa";
        } else {
            TARGET_ENV = System.getProperty("test.env");
        }
        if (System.getProperty("test.pause.millis") == null) {
            PAUSE_MILLIS =3000;
        } else {
            PAUSE_MILLIS = Integer.parseInt(System.getProperty("test.pause.millis"));
        }
    }

    /**
     * Singleton class - hide constructor
     */
    private TestConstants() {
    }
    
    public static final String getRandom(){
    	return Long.valueOf((long) (Math.random() * Long.MAX_VALUE)).toString();
    }

}
