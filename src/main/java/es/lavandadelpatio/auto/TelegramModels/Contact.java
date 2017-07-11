package es.lavandadelpatio.auto.TelegramModels;

import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import java.util.Optional;

/**
 * Created by raulm on 08/07/2017.
 */
public class Contact {

    /**
     * Contact's phone number
     */
    String phone_number;


    /**
     * Contact's first name
     */
    String first_name;


    /**
     * Contact's last name
     */
    Optional<String> last_name;


    /**
     * Contact's user identifier in Telegram
     */
    Optional<String> user_id;
}
