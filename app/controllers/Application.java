package controllers;

import play.api.templates.Html;
import play.mvc.Controller;
import play.mvc.Result;
import services.Redis;

public class Application extends Controller {
  
    public static Result index() {

        Redis redis = new Redis();
        Long visits = redis.incr("visits");
        Html html = views.html.index.render(visits);

        return ok(html);
    }
  
}
