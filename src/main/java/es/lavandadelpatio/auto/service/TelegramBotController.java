package es.lavandadelpatio.auto.service;

import es.lavandadelpatio.auto.TelegramModels.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by raulm on 06/07/2017.
 */
@RestController
@RequestMapping("${lavanda.botURL}")
@ConditionalOnProperty(name="lavanda.useDefaultWebhook", havingValue="true")
public class TelegramBotController {

    private static final Logger logger = LoggerFactory.getLogger(TelegramBotController.class);

    @Autowired
    MessageService ms;

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
        logger.info("Usando controlador webhook por defecto");
        apiURL = API_ENDPOINT + "/bot" + AUTH_TOKEN + "/";
        webhookURL = HOSTNAME + BOT_URL + WEBHOOK_TOKEN;
        HashMap<String, String> webhookConfig = new HashMap<>();
        webhookConfig.put("url", webhookURL);
        apiCall("setWebhook", webhookConfig);
    }

    @RequestMapping("${lavanda.webhookToken}")
    public void processUpdate(@RequestBody Update update){
        logger.info("Mensaje recibido de la API de Telegram --> {}", update);

        // Revisar compatibilidad de Jackson con Optional<>, sin el null check da npe
        if(update.getMessage() == null || !update.getMessage().isPresent()){
            logger.info("No es un mensaje, ignoramos update");
            return;
        }

        Message message = update.getMessage().get();
        ms.processMessage(message).ifPresent(respuesta -> sendAnswer( respuesta, message.getChat().getId(), message.getMessage_id() ));

    }

    private void sendAnswer(String text, long chat_id, int reply_to_message_id) {
        Map<String, Object> params = new HashMap<>();
        params.put("chat_id", chat_id);
        params.put("text", text);
        params.put("reply_to_message_id", reply_to_message_id);
        apiCall("sendMessage", params);
    }

    private void apiCall(String methodName, Map<String, ?> params){
        logger.info("Llamada a la Api de Telegram --> Metodo: {}, Parametros: {}, Resultado {}", methodName, params,
                new RestTemplate().postForEntity(apiURL+methodName, params, String.class));
    }

    private void apiCall(String methodName, Object params){
        logger.info("Llamada a la Api de Telegram --> Metodo: {}, Objeto: {}, Resultado {}", methodName, params,
                new RestTemplate().postForEntity(apiURL+methodName, params, String.class));
    }
}
