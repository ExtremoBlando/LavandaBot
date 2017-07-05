package es.lavandadelpatio.auto;

import es.lavandadelpatio.auto.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by raulm on 29/06/2017.
 */

public interface FilmRepository extends JpaRepository<Film, Long> {}
