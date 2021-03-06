package es.lavandadelpatio.auto.service;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.*;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import es.lavandadelpatio.auto.FilmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raulm on 14/07/2017.
 */


@Service
public class WatsonConversationService {


    private static final Logger logger = LoggerFactory.getLogger(WatsonConversationService.class);

    public static final String API_VERSION = "2017-05-26";

    @Value("${watson.conversation.username}")
    private String username;

    @Value("${watson.conversation.password}")
    private String password;

    @Value("${watson.conversation.workspaceid}")
    private String workspace;

    @Value("${watson.conversation.apiEndpoint}")
    private String apiEndpoint;

    ConversationService service;

    @Autowired
    FilmRepository filmRepository;

    //Map<Long, Context>

    @PostConstruct
    public void initializeWatsonAPI(){
        service = new ConversationService(ConversationService.VERSION_DATE_2017_04_21);
        service.setUsernameAndPassword(username, password);
        service.setEndPoint(apiEndpoint);

        //HashMap<String, String> defaultHeaders = new HashMap<>();
        //defaultHeaders.put("Content-Type", "application/json; charset=utf-8");
        //service.setDefaultHeaders(defaultHeaders);
    }

    public void uploadMovieEntities(){

        CreateEntityOptions.Builder ceob = new CreateEntityOptions.Builder(workspace, "Pelicula");

        //EntityExportResponse geo = service.getEntity(new GetEntityOptions.Builder(workspace, "Pelicula").build()).execute();
        logger.info("Eliminando entidad Pelioula para reconstruirla....");
        service.deleteEntity(new DeleteEntityOptions.Builder(workspace, "Pelicula").build()).execute();
        logger.info("Entidad pelicula eliminada, reconstruyendo...");
        filmRepository.findAll().forEach(p -> ceob.addValue(new CreateValue.Builder(p.getName()).synonyms(p.getSinonimos()).build()));
        service.createEntity(ceob.build()).execute();
        logger.info("Entidad pelicula actualizada con exito");
    }

    public MessageResponse sendMessage(String message, Map<String, Object> context){
        MessageRequest newMessage = new MessageRequest.Builder().inputText(message).context(context).build();
        return service.message(workspace, newMessage).execute();
        //InputData input = new InputData.Builder("Hi").build();
        //MessageOptions options = new MessageOptions.Builder(workspaceId).input(input).build();
        //MessageResponse response = service.message(options).execute();
    }
}
