package controllers;

import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import services.VisitorService;

public class Application extends Controller {

    public Application() {
        Logger.info("Application constructor");
    }

    public Result index() {
        VisitorService.increaseNumberOfVisits();

        Long visits = VisitorService.numberOfVisits();
        return ok(views.html.index.render(visits));
    }

}
