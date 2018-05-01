package rio.it.App.Control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by chien on 26/04/2018.
 */
@Controller
public class HomeControl {

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
