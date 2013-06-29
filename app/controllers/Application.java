package controllers;

import play.api.templates.Html;
import play.mvc.Controller;
import play.mvc.Result;
import redis.clients.jedis.Jedis;
import views.html.index;

public class Application extends Controller {
  
    public static Result index() {
        Jedis jedis = new Jedis("localhost");
        Long visits = jedis.incr("visits");
        Html html = views.html.index.render(visits);
        return ok(html);
    }
  
}
