package es.lavandadelpatio.auto.TelegramModels;

import java.util.Optional;

/**
 * Created by raulm on 08/07/2017.
 */
public class Sticker {
    /**
     * 	Unique identifier for this file
     */
    String file_id;


    /**
     *  Sticker width
     */
    int width;


    /**
     *  Sticker height
     */
    int height;


    /**
     *  Sticker thumbnail in .webp or .jpg format
     */
    Optional<PhotoSize> thumb;


    /**
     *  Emoji associated with the sticker
     */
    Optional <String> emoji;


    /**
     * File size
     */
    Optional<Integer> file_size;
}
