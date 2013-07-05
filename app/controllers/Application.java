package controllers;

import play.data.Form;
import play.libs.F;
import play.libs.WS;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import static play.data.Form.form;

public class Application extends Controller {


    @Security.Authenticated(Secured.class)
    public Result index() {
        return ok(views.html.index.render());
    }

    @Security.Authenticated(Secured.class)
    public Result restart() {

        return async(
                WS.url("http://127.0.0.1:3000/")
                        .setAuth("", "") // password = apikey
                        .post("")
                        .map(
                                new F.Function<WS.Response, Result>() {
                                    public Result apply(WS.Response response) {
                                        return ok("ok");
                                    }
                                }
                        )
        );
    }

    public Result login() {
        return ok(views.html.login.render(form(Login.class)));
    }

    public Result logout() {
        session().clear();
        return redirect(routes.Application.login());
    }

    public Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(views.html.login.render(loginForm));
        } else {
            session().clear();
            session("email", loginForm.get().email);
            return redirect(routes.Application.index());
        }
    }

    public static class Login {

        public String email;
        public String password;

        public String validate() {

            if (email == null || password == null) {
                return "Feil epost eller passord";
            }

            if (!password.equals("TEST")) {
                return "Feil epost eller passord!";
            }

            return null;
        }
    }
}
