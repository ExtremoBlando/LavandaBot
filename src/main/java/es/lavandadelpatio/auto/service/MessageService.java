package es.lavandadelpatio.auto.service;

import org.springframework.stereotype.Service;

/**
 * Created by raulm on 30/06/2017.
 */
@Service
public class MessageService {

    public String processMessage(String message){

        if(message.startsWith("/"))
            return executeCommand(message);

        return sendToWatson(message);

        return "Hola caracola";
    }

    private String executeCommand(String command){

    }

    private String sendToWatson(String message){

    }
}
