package es.lavandadelpatio.auto.TelegramModels;

import javax.persistence.Entity;
import java.util.Optional;

/**
 * Created by raulm on 08/07/2017.
 */
public class SuccessfulPayment {

    /**
     * Three-letter ISO 4217 currency code
     */
    String currency;


    /**
     * Total price in the smallest units of the currency (integer, not float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
     */
    int total_amount;


    /**
     * Bot specified invoice payload
     */
    String invoice_payload;


    /**
     * Identifier of the shipping option chosen by the user
     */
    Optional<String> shipping_option_id;


    /**
     *  Order info provided by the user
     */
    Optional<OrderInfo> order_info;

}
