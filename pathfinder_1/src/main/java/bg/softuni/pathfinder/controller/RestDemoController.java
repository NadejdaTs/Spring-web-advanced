package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.models.User;
import bg.softuni.pathfinder.services.RestDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/users")
public class RestDemoController {
    private RestDemoService userService;

    @Autowired
    public RestDemoController(RestDemoService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
//    @GetMapping("/users/all")
    public List<User> getAll(){
        return this.userService.getAll();
//        return "test!";
    }

    @Autowired
    public void setRestDemoService(RestDemoService restDemoService){
        this.userService = restDemoService;
    }

   /* @GetMapping("/login")
    public String login(){
        return "login";
    }*/

    /*@PostMapping("/login")
    public String login(@RequestParam String userName, @RequestParam String password){
        boolean isLoggedIn = this.userService.loginUser(userName);
//        if(isLoggedIn){
            return "redirect:/";
//        }
    }*/
}
