package es.lavandadelpatio.auto.TelegramModels;

import javax.persistence.Entity;
import java.util.Optional;

/**
 * Created by raulm on 08/07/2017.
 */
public class PhotoSize {

    /**
     * Unique identifier for this file
     */
    String file_id;


    /**
     * Photo width
     */
    int width;


    /**
     * Photo height
     */
    int height;


    /**
     * File size
     */
    Optional<Integer> file_size;
}
