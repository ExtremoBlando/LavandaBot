package es.lavandadelpatio.auto.controller;

/**
 * Created by raulm on 05/07/2017.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bot")
public class BotController {

    @RequestMapping("/")
    public String defaultBotPage(){
        return "defaultbotpage";
    }
}
