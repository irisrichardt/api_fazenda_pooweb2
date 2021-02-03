package br.com.ufsm.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Teste {
	
    @RequestMapping("/")
    @ResponseBody
    public String hello() {
       return "Hello Worlddd!";
    }

}