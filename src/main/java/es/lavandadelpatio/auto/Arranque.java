package es.lavandadelpatio.auto;

import es.lavandadelpatio.auto.service.FilmService;
import es.lavandadelpatio.auto.service.WatsonConversationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by raulm on 29/06/2017.
 */
@Component
public class Arranque implements CommandLineRunner{

    private static final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);

    @Autowired
    ApplicationContext app;

    @Autowired
    FilmService fs;

    @Autowired
    WatsonConversationService wcs;

    @Override
    public void run(String... strings){

        List<String> args = Arrays.asList(strings);

        if(args.isEmpty()){
            logger.error("Tienes que pasar como argumento la ruta del archivo txt que contiene los datos de las peliculas. Ejemplo: java -jar programa.jar listapeliculas.txt. Si se pasan varios argumentos seran analizados secuencialmente..");
            SpringApplication.exit(app, () -> -1);
        }

        for(String s : args){
            try(
                    FileReader fr = new FileReader(s);
                    BufferedReader br = new BufferedReader(fr)

            ){ br.lines().forEach(line -> fs.createAndSaveFilm(line)); }

            catch(FileNotFoundException e){
                logger.error("La ruta {} no es una ruta valida. Saltamos a la siguiente.", s);
            } catch(IOException e){
                logger.error("Error de entrada salida leyendo el archivo {}", s);
            }
        }

        logger.info("Carga de peliculas terminada");


        logger.info("Conectando a conversation para entrenar un pokito al bot...");
        wcs.uploadMovieEntities();
        logger.info("Entrenamiento finalizado.");

    }
}
