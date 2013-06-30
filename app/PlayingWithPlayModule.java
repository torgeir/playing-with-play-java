import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import config.Config;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class PlayingWithPlayModule implements Module {

    @Override
    public void configure(Binder binder) {

    }

    @Provides
    @Singleton
    public JedisPool jedisPool(Config config) {
        String host = config.getString("redis.host");
        int port    = config.getInt("redis.port");
        String pass = config.getString("redis.pass");

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        return new JedisPool(jedisPoolConfig, host, port, 300, pass);
    }
}
