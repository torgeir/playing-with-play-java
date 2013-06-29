package services;

import config.Config;
import play.Logger;
import redis.clients.jedis.Jedis;

public class Redis {

    final String host;
    final int port;
    final String pass;

    Jedis jedis;

    public Redis() {
        host = Config.getString("redis.host");
        port = Config.getInt("redis.port");
        pass = Config.getString("redis.pass");
    }

    private Jedis getInstance() {
        if (jedis == null) {
            jedis = new Jedis(host, port);
            if (pass != null) jedis.auth(pass);
            Logger.info(String.format("Connecting to Redis on %s:%s", host, port));
        }
        return jedis;
    }

    public Long incr(String visits) {
        return getInstance().incr(visits);
    }
}
