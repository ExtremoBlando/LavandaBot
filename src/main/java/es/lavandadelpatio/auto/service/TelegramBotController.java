package es.lavandadelpatio.auto.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

/**
 * Created by raulm on 06/07/2017.
 */
@Controller
@RequestMapping("${lavanda.botURL}")
public class TelegramBotController {

    @Value("${telegram.bot.apiEndpoint}")
    private String API_ENDPOINT;

    @Value("${telegram.bot.authToken}")
    private String AUTH_TOKEN;

    @Value("${lavanda.hostname}")
    private String HOSTNAME;

    @Value("${lavanda.botURL}")
    private String BOT_URL;

    @Value("${lavanda.webhookToken}")
    private String WEBHOOK_TOKEN;

    // Inicializado por initTelegramBotService()
    private String apiURL;
    private String webhookURL;

    @PostConstruct
    public void initTelegramBotService(){
        apiURL = API_ENDPOINT + "/bot" + AUTH_TOKEN + "/";
        webhookURL = HOSTNAME + BOT_URL + WEBHOOK_TOKEN;
    }

    @RequestMapping("${lavanda.webhookToken}")
    public void processUpdate(){

    }
}
