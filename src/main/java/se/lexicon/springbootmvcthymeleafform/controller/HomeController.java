package se.lexicon.springbootmvcthymeleafform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/") // localhost:9090/
    public String index(){
        System.out.println("Click here to Register");
        return "index"; // page name without .html
    }



}
