package es.lavandadelpatio.auto.TelegramModels;

/**
 * Created by Carlos on 11/07/2017.
 */
public class ShippingAddress {
    /**
     * ISO 3166-1 alpha-2 country code
     */
    String country_code;

    /**
     * State, if applicable
     */
    String state;

    /**
     * City
     */
    String city;

    /**
     * First line for the address
     */
    String street_line1;

    /**
     * Second line for the address
     */
    String street_line2;

    /**
     * Address post code
     */
    String post_code;
}
