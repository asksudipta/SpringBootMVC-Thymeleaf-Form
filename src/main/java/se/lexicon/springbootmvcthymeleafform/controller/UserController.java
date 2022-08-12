package se.lexicon.springbootmvcthymeleafform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import se.lexicon.springbootmvcthymeleafform.model.dto.User;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {


    @GetMapping("/register") // localhost:9090/register
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        List<String> listPurpose = Arrays.asList("Visitor", "Investor", "TeamOuting");
        model.addAttribute("listPurpose", listPurpose);

        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") @Valid User user) {
        System.out.println("User " + user);
        return "register_success";
    }
}
