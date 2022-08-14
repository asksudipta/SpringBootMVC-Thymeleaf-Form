package se.lexicon.springbootmvcthymeleafform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.lexicon.springbootmvcthymeleafform.model.dto.User;
import se.lexicon.springbootmvcthymeleafform.model.dto.UserView;
import se.lexicon.springbootmvcthymeleafform.service.UserService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {


    //Injecting the user service interface to controller
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register") // localhost:9090/register
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        List<String> listPurpose = Arrays.asList("Visitor", "Investor", "TeamOuting");
        model.addAttribute("listPurpose", listPurpose);

        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        System.out.println("User " + user);
        if(bindingResult.hasErrors()){
            return "register_form";
        }
        return "register_success";
    }


    @GetMapping("/view/{id}")
    public String findById(@PathVariable("id") Integer id, Model model) {
        System.out.println("ID:" + id);

        model.addAttribute("userView", userService.findById(id));

        return "user/user-View";
    }
    @PostMapping("/view")
    public String findByIdPost(@RequestParam("id") Integer id, Model model) {
        UserView categoryView = userService.findById(id);
        model.addAttribute("userView", categoryView);

        return "user/user-View";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        System.out.println("ID:" + id);
        boolean result = userService.delete(id);
        if (result) {
            redirectAttributes.addFlashAttribute("message", "User Id " + id + " was successfully deleted");
            redirectAttributes.addFlashAttribute("alertClass", "alert alert-info");
        } else {
            // display error message
        }

        return "redirect:/User/list";
    }
}
