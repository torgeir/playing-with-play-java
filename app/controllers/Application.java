package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import services.VisitorService;

public class Application extends Controller {
  
    public static Result index() {
        VisitorService.increaseNumberOfVisits();

        Long visits = VisitorService.numberOfVisits();
        return ok(views.html.index.render(visits));
    }
  
}
