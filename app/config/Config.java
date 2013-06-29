package config;

import play.Configuration;
import play.Play;

public class Config {

    private static Configuration configuration;

    static {
        configuration = Play.application().configuration();
    }

    public static String getString(String key) {
        return configuration.getString(key);
    }

    public static int getInt(String key) {
        return configuration.getInt(key);
    }
}
