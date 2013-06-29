package services;

import com.google.inject.Inject;
import config.Config;
import play.Logger;
import redis.clients.jedis.Jedis;

class Redis {

    Jedis jedis;

    @Inject
    public Redis(Config config) {
        String host = config.getString("redis.host");
        int port = config.getInt("redis.port");
        String pass = config.getString("redis.pass");

        initJedis(host, port, pass);
    }

    private void initJedis(String host, int port, String pass) {
        Logger.info(String.format("Connecting to Redis on %s:%s", host, port));

        jedis = new Jedis(host, port);
        if (pass != null) {
            jedis.auth(pass);
        }
    }

    public Long incr(String key) {
        return jedis.incr(key);
    }

    public String get(String key) {
        return jedis.get(key);
    }
}
