package es.lavandadelpatio.auto.service;

import es.lavandadelpatio.auto.TelegramModels.FullUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by raulm on 06/07/2017.
 */
@RestController
@RequestMapping("${lavanda.botURL}")
public class TelegramBotController {

    private static final Logger logger = LoggerFactory.getLogger(FilmService.class);

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
        HashMap<String, String> webhookConfig = new HashMap<>();
        webhookConfig.put("url", webhookURL);
        apiCall("setWebhook", webhookConfig);
    }

    @RequestMapping("${lavanda.webhookToken}")
    public void processUpdate(@RequestBody String updates){
        logger.info("Mensaje recibido de la API de Telegram --> {}", updates);
    }

    private void apiCall(String methodName, Map<String, ?> params){
        logger.info("Llamada a la Api de Telegram --> Metodo: {}, Parametros: {}, Resultado {}", methodName, params,
        new RestTemplate().postForEntity(apiURL+methodName, params, String.class));
    }
}
