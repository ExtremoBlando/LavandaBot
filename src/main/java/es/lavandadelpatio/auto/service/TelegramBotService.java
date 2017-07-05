package es.lavandadelpatio.auto.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import javax.annotation.PostConstruct;

/**
 * Created by raulm on 30/06/2017.
 */
@Service
public class TelegramBotService extends TelegramWebhookBot {

    private static final Logger logger = LoggerFactory.getLogger(TelegramBotService.class);

    @Autowired
    MessageService ms;

    TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

    @PostConstruct
    public void registerBot(){
        logger.info("Registrando bot.....");
        try {
            telegramBotsApi.registerBot(this);
            logger.info("Bot registrado con exito");
        } catch (TelegramApiRequestException e) {
            logger.error("No se ha podido registrar el bot");
            e.printStackTrace();
        }
    }

    @Override
    public BotApiMethod onWebhookUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            String mensaje = update.getMessage().getText();
            String sender =  update.getMessage().getFrom().getUserName();

            logger.info("Mensaje recibido {} de {} ", mensaje, sender);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId().toString());

            sendMessage.setText(ms.processMessage(mensaje,sender));
            return sendMessage;
        }
        return null;
    }

    @Override
    public String getBotUsername() {
        return "LavandaBOTijo";
    }

    @Override
    public String getBotToken() {
        return "438710363:AAHnTLpN6CoMv1yvDdZWc318uzBdj6juesM";
    }

    @Override
    public String getBotPath() {
        return "https://e37a9a7a.ngrok.io";
    }

}
