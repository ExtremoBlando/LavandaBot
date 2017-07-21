package es.lavandadelpatio.auto.TelegramModels;

import javax.persistence.Entity;
import java.util.Optional;

/**
 * Created by raulm on 07/07/2017.
 */
public class User {

    /**
     * Unique identifier for this user or bot
     */
    long id;

    /**
     * User‘s or bot’s first name
     */
    String first_name;

    /**
     * User‘s or bot’s last name
     */
    Optional<String> last_name;

    /**
     * User‘s or bot’s username
     */
    Optional<String> username;

    /**
     * IETF language tag of the user's language
     */
    Optional<String> language_code;

    public long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public Optional<String> getLast_name() {
        return last_name;
    }

    public Optional<String> getUsername() {
        return username;
    }

    public Optional<String> getLanguage_code() {
        return language_code;
    }
}
