package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.models.dto.binding.UserLoginBindingModel;
import bg.softuni.pathfinder.models.dto.binding.UserRegisterBindingModel;
import bg.softuni.pathfinder.models.dto.view.UserProfileViewModel;
import bg.softuni.pathfinder.services.AuthenticationService;
import bg.softuni.pathfinder.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    public UsersController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(UserLoginBindingModel userLoginBindingModel){
        boolean isLogged = this.authenticationService.login(userLoginBindingModel);

        if(isLogged){
            return new ModelAndView(("redirect:/"));
        }
        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(UserRegisterBindingModel userRegisterBindingModel){
        this.authenticationService.register(userRegisterBindingModel);
        return new ModelAndView("redirect:login");
    }

    @GetMapping("/logout")
    public ModelAndView logout(){
        this.authenticationService.logout();
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/details")
    public ModelAndView profile(){
        UserProfileViewModel userProfileViewModel = userService.getUserProfile();
        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("userProfileViewModel", userProfileViewModel);

        return modelAndView;
    }
}
