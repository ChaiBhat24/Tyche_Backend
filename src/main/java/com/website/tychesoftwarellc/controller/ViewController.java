package com.website.tychesoftwarellc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	@RequestMapping(value = {"/", "/{path:^(?!api$).*$}/**"})
    public String index() {
        return "index"; // Assuming "index" is the name of your HTML file for the React.js frontend
    }
}
