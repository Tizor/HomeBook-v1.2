package app.controller;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;


    @Qualifier(value = "userService")
    @GetMapping("/ListPage")
    public String ListPage(Model model){
        model.addAttribute("ListOfUsers", userService.AllUsers());
        return "ListPage";
    }

}
