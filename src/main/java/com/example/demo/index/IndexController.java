package com.example.demo.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(path = "api/v1/home")

    @Controller
    public class IndexController {

        @GetMapping({ "/", "/index" })
        public String index(Model model) {
            model.addAttribute("name", "John"); // set 'John' value for 'name' attribute

            return "index"; // name of the View
        }
    }

