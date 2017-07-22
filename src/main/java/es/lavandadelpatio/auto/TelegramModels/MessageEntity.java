package es.lavandadelpatio.auto.TelegramModels;

import javax.persistence.Entity;
import java.util.Optional;

/**
 * Created by raulm on 07/07/2017.
 */
public class MessageEntity {

    /**
     * Type of the entity. See MessageEntityType.
     */
    MessageEntityType type;

    /**
     * Offset in UTF-16 code units to the start of the entity
     */
    int offset;

    /**
     * Length of the entity in UTF-16 code units
     */
    int length;

    /**
     * For “text_link” only, url that will be opened after user taps on the text.
     */
    Optional<String> url;

    /**
     *  For “text_mention” only, the mentioned user
     */
    Optional<User> user;

    public MessageEntityType getType() {
        return type;
    }

    public int getOffset() {
        return offset;
    }

    public int getLength() {
        return length;
    }

    public Optional<String> getUrl() {
        return url;
    }

    public Optional<User> getUser() {
        return user;
    }
}
