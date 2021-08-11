package com.shaja.springjwt.bezkoderbackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@Controller
@RequestMapping("/api/auth/")
public class LoginController {

    @RequestMapping(method = RequestMethod.POST,value = "/signup")
    @RequestMapping(method = RequestMethod.POST,value = "/signin")

}
