import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.mvc.Action;
import play.mvc.Http.Request;
import redis.clients.jedis.JedisPool;

import java.lang.reflect.Method;

public class Global extends GlobalSettings {

    static Injector injector = Guice.createInjector(new PlayingWithPlayModule());

    @Inject
    JedisPool jedisPool;

    public void onStart(Application app) {
        Logger.info("Application has started");
    }

    @Override
    public void onStop(Application app) {
        Logger.info("Application shutdown...");

        Logger.info("Destroying jedis pool");
        jedisPool.destroy();
    }

    @Override
    public Action onRequest(Request request, Method actionMethod) {
        System.out.println("before each request..." + request.toString());
        return super.onRequest(request, actionMethod);
    }

    @Override
    public <A> A getControllerInstance(Class<A> clazz) throws IllegalAccessException, InstantiationException {
        return injector.getInstance(clazz);
    }

}