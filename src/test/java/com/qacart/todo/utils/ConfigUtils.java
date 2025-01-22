package com.qacart.todo.utils;

import java.util.Properties;

// Utility class for managing configuration properties
public class ConfigUtils {

    private Properties properties;

    private static ConfigUtils configUtils;

    // Get environment variable
    private ConfigUtils() {
        String env = System.getProperty("env", "PRODUCTION");

        switch (env) {
            case "PRODUCTION":
                properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
                break;
            case "LOCAL":
                properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/local.properties");
                break;
            default:
                throw new RuntimeException("The environment is not supported.");
        }

    }

    public static ConfigUtils getInstance() {
        if(configUtils == null) {
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    // Retrieve the base URL from the properties file
    public String getBaseURL() {
        String prop = properties.getProperty("baseURL");
        if(prop != null) return prop;
        throw new RuntimeException("Could not find the base URL in the properties file");
    }

    // Retrieve the email from the properties file
    public String getEmail() {
        String prop = properties.getProperty("email");
        if(prop != null) return prop;
        throw new RuntimeException("Could not find the email in the properties file");
    }

    // Retrieve the password from the properties file
    public String getPassword() {
        String prop = properties.getProperty("password");
        if(prop != null) return prop;
        throw new RuntimeException("Could not find the password in the properties file");
    }

}
