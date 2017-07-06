package es.lavandadelpatio.auto.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by raulm on 05/07/2017.
 */
@Controller
public class DefaultController {

    @RequestMapping("/")
    public String defaultPage(){
        return "index";
    }
}
