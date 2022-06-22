package com.spotify.oauth2.Utils;

import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        properties = PropertyUtils.propertyLoader("src/test/resources/Config.properties");

        }

    public static ConfigLoader getConfigLoader(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getClientId(){
        String prop = properties.getProperty("client_id");
        if(prop != null) return prop;
        else throw new RuntimeException("property not found in the config file");
    }

    public String getClientSecrete(){
        String prop = properties.getProperty("client_secret");
        if(prop != null) return prop;
        else throw new RuntimeException("property not found in the config file");
    }

    public String getRefreshToken(){
        String prop = properties.getProperty("refresh_token");
        if(prop != null) return prop;
        else throw new RuntimeException("property not found in the config file");
    }

    public String getGrantType(){
        String prop = properties.getProperty("grant_type");
        if(prop != null) return prop;
        else throw new RuntimeException("property not found in the config file");
    }

    public String getUserId(){
        String prop = properties.getProperty("user_id");
        if(prop != null) return prop;
        else throw new RuntimeException("property not found in the config file");
    }
}
