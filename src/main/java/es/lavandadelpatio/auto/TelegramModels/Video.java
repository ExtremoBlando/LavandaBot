package es.lavandadelpatio.auto.TelegramModels;

import javax.persistence.Entity;
import java.util.Optional;

/**
 * Created by raulm on 08/07/2017.
 */
public class Video {
    /**
     * 	Unique identifier for this file
     */
    String file_id;


    /**
     * Video width as defined by sender
     */
    int width;


    /**
     * Video height as defined by sender
     */
    int height;


    /**
     * Duration of the video in seconds as defined by sender
     */
    int duration;


    /**
     * Video thumbnail
     */
    Optional<PhotoSize> thumb;


    /**
     * Mime type of a file as defined by sender
     */
    Optional<String> mime_type;


    /**
     * File size
     */
    Optional<Integer> file_size;
}
