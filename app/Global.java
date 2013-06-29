import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.mvc.Action;
import play.mvc.Http.Request;

import java.lang.reflect.Method;

public class Global extends GlobalSettings {

    @Override
    public Action onRequest(Request request, Method actionMethod) {
        System.out.println("before each request..." + request.toString());
        return super.onRequest(request, actionMethod);
    }


    @Override
    public void onStart(Application app) {
        Logger.info("Application has started");
    }

    @Override
    public void onStop(Application app) {
        Logger.info("Application shutdown...");
    }

    @Override
    public <A> A getControllerInstance(Class<A> clazz) throws IllegalAccessException, InstantiationException {
        Logger.info(clazz.getCanonicalName());
        return clazz.newInstance();
    }

}