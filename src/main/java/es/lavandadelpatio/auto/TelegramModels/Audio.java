package es.lavandadelpatio.auto.TelegramModels;

import javax.persistence.Entity;
import java.util.Optional;

/**
 * Created by raulm on 07/07/2017.
 */
@Entity
public class Audio {

    /**
     * Unique identifier for this file
     */
    String file_id;

    /**
     * Duration of the audio in seconds as defined by sender
     */
    int duration;

    /**
     * Performer of the audio as defined by sender or by audio tags
     */
    Optional<String> performer;

    /**
     * Title of the audio as defined by sender or by audio tags
     */
    Optional<String> title;

    /**
     * MIME type of the file as defined by sender
     */
    Optional<String> mime_type;

    /**
     * File size
     */
    Optional<Integer> file_size;

}
