package com.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Daniel on 17/10/2016.
 */

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "crud up and running! ";
    }
}
