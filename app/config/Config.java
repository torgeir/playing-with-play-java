package config;

import play.Configuration;
import play.Play;

public class Config {

    Configuration configuration;

    public Config() {
        configuration = Play.application().configuration();
    }

    public String getString(String key) {
        return configuration.getString(key);
    }

    public int getInt(String key) {
        return configuration.getInt(key);
    }
}
