package es.lavandadelpatio.auto.TelegramModels;

import javax.persistence.Entity;

/**
 * Created by raulm on 08/07/2017.
 */
public class Invoice {
    /**
     * 	Product name
     */
    String title;


    /**
     * Product description
     */
    String description;


    /**
     * Unique bot deep-linking parameter that can be used to generate this invoice
     */
    String start_parameter;


    /**
     * Three-letter ISO 4217 currency code
     */
    String currency;


    /**
     * Total price in the smallest units of the currency (integer, not float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
     */
    int total_amount;
}
