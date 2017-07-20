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
import java.util.Set;
import java.util.function.Predicate;
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

    private final Set<String> nombresPeliculas = new HashSet<>();

    private final Set<String> listaExclusion = new HashSet<>(Arrays.asList(("un una unos unas el la los las a con " +
            "cual cuan de del en entre para por so tras al de a algo mas asi aun a ir me tu muy nada ni no nos os " +
            "por qué que si sí sin sino tan te ti tú tu tus y yo ya mas más no como cómo porque porqué").split(" ")));

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

        String shortName = m.group(2).trim().replace(" ", "-");
        if(shortName.length()>64)
            shortName = shortName.substring(0, 64);

        if(nombresPeliculas.contains(shortName)) {
            logger.warn("Ignorando  pelicula {}. MOTIVO: DUPLICADO", s);
            return null;
        }
        nombresPeliculas.add(shortName);

        Predicate<String> palabraEnListaExclusion = listaExclusion::contains;
        Predicate<String> noIgnorar = palabraEnListaExclusion.or(String::isEmpty).negate();

        return new Film(
                s,
                shortName,
                Extension.valueOf(m.group(5).toUpperCase()),
                Integer.parseInt(m.group(3)),
                Arrays.stream(m.group(2).replace("(", "").replace(")", "")
                        .replace(":", "").replace(".", "")
                        .replace(",", "").replace("!", "")
                        .replace("-", "").replace("&", "")
                                .split(" ")).map(String::toLowerCase).map(String::trim).filter(noIgnorar).collect(Collectors.toSet())
        );
    }

    public void saveFilm(Film m){
        if(m == null)
            logger.warn("Ignorando pelicula con valor null");
        //else if(m.getName().length() >=64)
        //    logger.warn("La pelicula {} tiene mas de 64 caracteres", m.getName());
        else
            fp.save(m);
    }

    public void createAndSaveFilm(String s){
        Film film = createFilm(s);
        if(s != null)
            saveFilm(film);
    }
}
