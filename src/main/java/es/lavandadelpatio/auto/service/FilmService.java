package es.lavandadelpatio.auto.service;

import es.lavandadelpatio.auto.FilmRepository;
import es.lavandadelpatio.auto.model.Extension;
import es.lavandadelpatio.auto.model.Film;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by raulm on 29/06/2017.
 */
@Service
public class FilmService {

    @Autowired
    FilmRepository fp;

    private static final Logger logger = LoggerFactory.getLogger(FilmService.class);

    /**
     * La forma mas facil de extraer la info que necesitamos de cada linea, es primero, comprobar si el string
     * se ajusta a la expresion regular, y segundo, si se ajusta, extraer los datos mediante los grupos.
     */
    private final Pattern p = Pattern.compile("(.*)/(.*)\\(([0-9]+)\\)(.*)\\.(\\w+)");

    public Film createFilm(String s){

        Matcher m = p.matcher(s);

        if(!m.matches()) {
            logger.warn("Ignorando ruta {}. MOTIVO: No se ajusta al regex", s);
            return null;
        }
        return new Film(s, m.group(2), Extension.valueOf(m.group(5).toUpperCase()), Integer.parseInt(m.group(3)),
                Arrays.stream(m.group(2).split(" ")).filter(name -> name.length() >= 3).collect(Collectors.toSet()));
    }

    public void saveFilm(Film m){
        if(m == null)
            logger.warn("Ignorando pelicula con valor null");
        else if(m.getName().length() >=64)
            logger.warn("La pelicula {} tiene mas de 64 caracteres", m.getName());
        else
            fp.save(m);
    }

    public void createAndSaveFilm(String s){
        saveFilm(createFilm(s));
    }
}
