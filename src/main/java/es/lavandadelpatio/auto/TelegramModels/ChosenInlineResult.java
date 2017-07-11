package es.lavandadelpatio.auto.TelegramModels;

import java.util.Optional;

/**
 * Created by raulm on 11/07/2017.
 */
public class ChosenInlineResult {

    /**
     * The unique identifier for the result that was chosen
     */
    String result_id;

    /**
     * The user that chose the result
     */
    User from;

    /**
     *  Sender location, only for bots that require user location
     */
    Optional<Location> location;

    /**
     * Identifier of the sent inline message. Available only if there is an inline keyboard attached to the message. Will be also received in callback queries and can be used to edit the message.
     */
    Optional<String> inline_message_id;

    /**
     * The query that was used to obtain the result
     */
    String query;
}
