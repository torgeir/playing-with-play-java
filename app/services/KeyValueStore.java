package services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

class KeyValueStore {

    JedisPool jedisPool;

    @Inject
    public KeyValueStore(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public Long incr(final String key) {
        return doWithResource(new Operation<Long>() {

            @Override
            public Long perform(Jedis jedis) {
                return jedis.incr(key);
            }
        });
    }

    public String get(final String key) {
        return doWithResource(new Operation<String>() {

            @Override
            public String perform(Jedis jedis) {
                return jedis.get(key);
            }
        });
    }

    private <T> T doWithResource(Operation<T> operation) {
        T result;
        Jedis jedis = jedisPool.getResource();
        try {
            result = operation.perform(jedis);
        } finally {
            jedisPool.returnResource(jedis);
        }
        return result;
    }

    interface Operation<T> {
        T perform(Jedis jedis);
    }
}
