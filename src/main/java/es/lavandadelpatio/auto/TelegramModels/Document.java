package es.lavandadelpatio.auto.TelegramModels;

import javax.persistence.Entity;
import java.util.Optional;

/**
 * Created by raulm on 07/07/2017.
 */
public class Document {

    /**
     * Unique file identifier
     */
    String file_id;


    /**
     * Document thumbnail as defined by sender
     */
    Optional<PhotoSize> thumb;


    /**
     * Original filename as defined by sender
     */
    Optional<String> file_name;


    /**
     * MIME type of the file as defined by sender
     */
    Optional<String> mime_type;


    /**
     * File size
     */
    Optional<Integer> file_size;
}
