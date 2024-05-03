package net.proselyte.springbootdemo_311.controllers;

import net.proselyte.springbootdemo_311.model.User;
import net.proselyte.springbootdemo_311.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/users/new")
    public String newUser(@ModelAttribute("user") User user){
        return "new";
    }

    @GetMapping(value = "/users")
    public String printUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/users{id}")
    public String getUsersById(@PathVariable("id") Long id, Model model){
        model.addAttribute(userService.getUserById(id));
        return "userId";
    }

    @GetMapping(value = "/users/{id}/update")
    public String update(Model model, @PathVariable("id") Long id){
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PatchMapping(value = "users/{id}")
    public String update1(@ModelAttribute("user") User user, @PathVariable("id") Long id){
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping(value = "users/{id}")
    public String delete(@PathVariable("id")Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
