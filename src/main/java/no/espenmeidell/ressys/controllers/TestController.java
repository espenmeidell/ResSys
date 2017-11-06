package no.espenmeidell.ressys.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    String test(){
        return "OK!";
    }



}
