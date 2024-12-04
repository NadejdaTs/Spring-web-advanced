package bg.softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserLoginController {

//    private final UserService userService;
//    private final ModelMapper mapper;
//
//    @Autowired
//    public UserLoginController(UserService userService) {
//        this.userService = userService;
//        this.mapper = new ModelMapper();
//    }
//
//    @GetMapping("/login")
//    public String login(Model model){
//        if (!model.containsAttribute("userLoginDTO")) {
//            model.addAttribute("userLoginDTO", new UserLoginDTO());
//        }
//        return "/login";
//    }
//
//    @PostMapping("/login")
//    public String login(UserLoginDTO userLoginDTO) {
//        boolean isExisting = this.userService.loginUser(userLoginDTO);
//        if(isExisting) {
//            return "redirect:/home";
//        }else{
//            return "redirect:/users/login";
//        }
//    }
//
//    @GetMapping("/register")
//    public String loadRegisterForm(Model model) {
//
//        if (!model.containsAttribute("userRegistrationDTO")) {
//            model.addAttribute("userRegistrationDTO", new UserRegistrationDTO());
//        }
//
//        return "register";
//    }

    /*@GetMapping("/register")
    public String register(UserRegisterBindingModel userRegisterBindingModel){
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes
                    .addAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                            bindingResult);
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            return "redirect:register";
        }
        userService.registerUser(mapper.map(userRegisterBindingModel, UserServiceModel.class));
        return "redirect:login";
    }*/

//    @PostMapping("/register")
//    public String registerUser(UserRegistrationDTO userRegistrationDTO){
//        boolean isRegisteredUser = this.userService.registerUser(userRegistrationDTO);
//        return "redirect:/users/login";
//    }

}
