package es.lavandadelpatio.auto.service;

import com.ibm.watson.developer_cloud.conversation.v1.model.Entity;
import com.ibm.watson.developer_cloud.conversation.v1.model.Intent;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import es.lavandadelpatio.auto.TelegramModels.Message;
import es.lavandadelpatio.auto.TelegramModels.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by raulm on 30/06/2017.
 */
@Service
public class MessageService {

    private static final String FILTRO_ACTIVACION = "@lavanda_chat_bot";

    private static final String REEMPLAZAR_POR_USER = "{}";

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    Map<Long, Map<String, Object>> contextData = new HashMap<>();

    Set<String> listaConfianza = new HashSet<>(Arrays.asList("54567045"));

    // Para debug
    List<Entity> entidades =  new ArrayList<>();
    List<Intent> intenciones = new ArrayList<>();

    @Autowired
    WatsonConversationService wcs;

    public Optional<String> processMessage(Message message){

        if(!debemosProcesador(message))
            return Optional.empty();

        String entrada = preProcesado(message.getText().get()).trim();
        String respuesta;

        if(entrada.startsWith("/")){
            logger.info("Procesando como comando");
            respuesta = processAsCommand(entrada.substring(1).split(" "), message);
        } else {
            logger.info("Enviando mensaje para procesar a Watson");
            respuesta = processAsWatson(entrada, message.getChat().getId());
        }

        return Optional.of(postProcesado(respuesta, message.getFrom().get().getUsername().get()));
    }

    private String processAsCommand(String[] params, Message message){

        StringBuilder sb;
        switch(params[0]){

            case "ayuda":
                return "No me apetece mucho ayudarte la verdad. Es broma, esta en construcción";

            case "resetcontext":
                if(esDeConfianza(message.getFrom().get())){
                    this.contextData =  new HashMap<>();
                    return "Contexto destruido, empezando de 0";
                }
                return "Tu no eres mi amigo, no confio en ti.";

            case "desactivar":
                return "Pendiente de implementacion";

            case "activar":
                return "Pendiente de implementacion";

            case "getId":
                return "Tu codigo de usuario es :" +Long.toString(message.getFrom().get().getId());

            case "ping":
                return "pong";

            case "entidades":
                sb = new StringBuilder().append("Posibles entidades detectadas en el ultimo mensaje: ");
                entidades.forEach(e -> sb.append(e.getEntity()).append(":").append(e.getValue()).append(" "));
                return sb.toString();

            case "intenciones":
                sb = new StringBuilder().append("Intenciones del ultimo mensaje: ");
                intenciones.forEach(i -> sb.append(i.getIntent()).append(" - ").append(i.getConfidence()).append(" "));
                return sb.toString();

            default:
                return "Comando no reconocido, para ver la lista de comandos pon /ayuda";
        }
    }

    /**
     * Send the message to Watson Conversation for further processing.
     * @param message The message to be sent
     * @param id The key that will be used in order to identify a context, both for retrieving it and updating it.
     * @return Watson response
     */
    private String processAsWatson(String message, long id){

        MessageResponse mr = wcs.sendMessage(message, getContextData(id));

        entidades = mr.getEntities();
        intenciones = mr.getIntents();

        //logger.info("Entidades: {}, Intenciones: {}", entidades, intenciones);

        saveContextData(mr.getContext(), id);

        if(mr.getText().isEmpty())
            return generateResponse(mr);

        return String.join("\n", mr.getText());
    }

    /**
     * Genera la respuesta si Watson no lo ha hecho.
     * @param mr
     * @return
     */
    private String generateResponse(MessageResponse mr) {

        if(mr.getIntents().isEmpty())
            throw new IllegalArgumentException("Cannot generate the response without intent data");


        switch (mr.getIntents().get(0).getIntent()){

            case "pregunta":

                return "";

            default:
                return "No implementado";

        }
    }

    private void saveContextData(Map<String, Object> context, long id){
        this.contextData.put(id, context);
    }

    private Map<String, Object> getContextData(long id){
        return this.contextData.get(id);
    }

    /**
     * Comprueba si cumple los requisitos para ser procesado
     * @param message Mensaje a ser procesado
     * @return Verdadero si lo ignoramos, falso en caso contrario
     */
    private boolean debemosProcesador(Message message){

        return message.getText() != null
                && message.getText().isPresent()
                && message.getText().get().contains(FILTRO_ACTIVACION)
                && message.getFrom().isPresent();
    }

    /**
     * Operaciones a realizar sobre la entrada antes de enviarla a Watson
     * @param s String a procesar antes de enviar
     * @return String procesado
     */
    private String preProcesado(String s){
        return s.replace(FILTRO_ACTIVACION, "");
    }

    /**
     * Operaciones a realizar una vez que tenemos la respuesta de Watson, por ahora solo inyectar el
     * nombre del usuario si es necesario
     * @param s1 String base
     * @param s2 String para reemplazar
     * @return String procesado
     */
    private String postProcesado(String s1, String s2){
        return s1.replace(REEMPLAZAR_POR_USER, s2);
    }

    private boolean esDeConfianza(User user){
        return listaConfianza.contains(Long.toString(user.getId()));
    }
}
