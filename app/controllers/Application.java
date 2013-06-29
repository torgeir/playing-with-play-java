package controllers;

import com.google.inject.Inject;
import play.mvc.Controller;
import play.mvc.Result;
import services.VisitorService;

public class Application extends Controller {

    VisitorService visitorService;

    @Inject
    public Application(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    public Result index() {
        visitorService.increaseNumberOfVisits();

        Long visits = visitorService.numberOfVisits();
        return ok(views.html.index.render(visits));
    }

}
