package es.lavandadelpatio.auto.TelegramModels;

import javax.persistence.Id;
import java.util.Optional;

/**
 * Created by Carlos on 11/07/2017.
 */
public class Animation {

    /**
     * Unique file identifier
     */
    @Id
    String file_id;

    /**
     * Animation thumbnail as defined by sender
     */
    Optional<PhotoSize> thumb;

    /**
     * Original animation filename as defined by sender
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
