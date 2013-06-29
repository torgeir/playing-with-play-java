package services;

import config.Config;
import play.Logger;
import redis.clients.jedis.Jedis;

class Redis {

    static final String host = Config.getString("redis.host");
    static final int port    = Config.getInt("redis.port");
    static final String pass = Config.getString("redis.pass");

    static Jedis jedis;

    static {
        jedis = new Jedis(host, port);
        if (pass != null)
            jedis.auth(pass);
        Logger.info(String.format("Connecting to Redis on %s:%s", host, port));
    }

    public static Long incr(String key) {
        return jedis.incr(key);
    }

    public static String get(String key) {
        return jedis.get(key);
    }
}
