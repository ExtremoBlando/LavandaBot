package es.lavandadelpatio.auto.TelegramModels;

import javax.persistence.Entity;
import java.util.Optional;

/**
 * Created by raulm on 08/07/2017.
 */
public class VideoNote {

    /**
     * Unique identifier for this file
     */
    String file_id;


    /**
     * 	Video width and height as defined by sender
     */
    int length;


    /**
     * 	Duration of the video in seconds as defined by sender
     */
    int duration;


    /**
     * Video thumbnail
     */
    Optional<PhotoSize> thumb;


    /**
     * File size
     */
    Optional<Integer> file_size;
}
