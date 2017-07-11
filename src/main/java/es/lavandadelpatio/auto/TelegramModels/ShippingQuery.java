package es.lavandadelpatio.auto.TelegramModels;

import javax.persistence.Id;

/**
 * Created by raulm on 11/07/2017.
 */
public class ShippingQuery {
    /**
     * Unique query identifier
     */
    @Id
    String id;

    /**
     * 	User who sent the query
     */
    User from;

    /**
     * Bot specified invoice payload
     */
    String invoice_payload;

    /**
     * User specified shipping address
     */
    ShippingAddress shipping_address;
}
