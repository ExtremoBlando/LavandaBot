package es.lavandadelpatio.auto.TelegramModels;

import java.util.Optional;

/**
 * Created by Carlos on 11/07/2017.
 */
public class OrderInfo {
    /**
     * User name
     */
    Optional<String> name;


    /**
     * User's phone number
     */
    Optional<String> phone_number;


    /**
     * User email
     */
    Optional<String> email;

    /**
     * User shipping address
     */
    Optional<String> shipping_address;
}
