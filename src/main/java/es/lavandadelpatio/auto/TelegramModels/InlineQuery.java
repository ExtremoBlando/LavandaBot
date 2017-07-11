package es.lavandadelpatio.auto.TelegramModels;

import java.util.Optional;

/**
 * Created by raulm on 11/07/2017.
 */
public class InlineQuery {

    /**
     * 	Unique identifier for this query
     */
    String id;

    /**
     * Sender
     */
    User from;

    /**
     * Sender location, only for bots that request user location
     */
    Optional<Location> location;

    /**
     * Text of the query (up to 512 characters)
     */
    String query;

    /**
     * Offset of the results to be returned, can be controlled by the bot
     */
    String offset;
}
