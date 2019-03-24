package app.controller;
import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Qualifier(value = "userService")
    @GetMapping("/ListPage")
    public String listPage(Model model){
        model.addAttribute("ListOfUsers", userService.allUsers());
        return "ListPage";
    }

    @GetMapping("/CreateUser")
    public ModelAndView addUser(ModelAndView model) {
        User NewUser = new User();
        model.addObject("user",NewUser);
        model.setViewName("MakeUser");
        return model;
    }

    @PostMapping("/SaveUser")
    public ModelAndView saveUser(@ModelAttribute User user){
        userService.addUser(user);
        return new ModelAndView("redirect:/ListPage");
    }

    @GetMapping("/DeleteUser")
    public String deleteUser(int id){
        userService.deleteUser(id);
        return "redirect:/ListPage";
    }

    @GetMapping("/UpdateUser")
    public ModelAndView editUser(@ModelAttribute ModelAndView model, int id) {
        User user = userService.getId(id);
        model.setViewName("UpdateUser");
        model.addObject("user", user);
        return model;
    }

    @PostMapping("/SaveUpdateUser")
    public ModelAndView saveUpdateUser(@ModelAttribute User user){
        userService.updateUser(user);
        return new ModelAndView("redirect:/ListPage");
    }



}
