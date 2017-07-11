package es.lavandadelpatio.auto.TelegramModels;

import java.util.Optional;

/**
 * Created by raulm on 11/07/2017.
 */
public class CallbackQuery {

    /**
     * Unique identifier for this query
     */
    String id;

    /**
     * Sender
     */
    User from;

    /**
     * Message with the callback button that originated the query. Note that message content and message date will not be available if the message is too old
     */
    Optional<Message> message;

    /**
     * Identifier of the message sent via the bot in inline mode, that originated the query.
     */
    Optional<String> inline_message_id;

    /**
     * Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent. Useful for high scores in games.
     */
    String chat_instance;

    /**
     * Data associated with the callback button. Be aware that a bad client can send arbitrary data in this field.
     */
    Optional<String> data;

    /**
     * Short name of a Game to be returned, serves as the unique identifier for the game
     */
    Optional<String> game_short_name;
}
